package com.rjt.retrofitrxjava.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.rjt.retrofitrxjava.R
import com.rjt.retrofitrxjava.adapters.Adapter
import com.rjt.retrofitrxjava.models.Users
import com.rjt.retrofitrxjava.network.ApiInterface
import com.rjt.retrofitrxjava.network.ApiService
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var single = ApiService.getRetrofit().create(ApiInterface::class.java).getUsers()

        single.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object: SingleObserver<List<Users>>{
                override fun onSuccess(t: List<Users>) {
                    Log.d("test", "Success!")

                    recycler_view.layoutManager = LinearLayoutManager(applicationContext)
                    adapter = Adapter(applicationContext, t as ArrayList<Users>)
                    recycler_view.adapter = adapter
                }

                override fun onSubscribe(d: Disposable) {
                    Log.d("test", "onSubscribe")
                }

                override fun onError(e: Throwable) {
                    Log.d("test", "failure: " + e.toString())
                }

            })

    }
}
