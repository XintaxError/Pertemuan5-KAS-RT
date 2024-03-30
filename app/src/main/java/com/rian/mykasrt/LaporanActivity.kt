package com.rian.mykasrt

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rian.mykasrt.model.DataItem
import com.rian.mykasrt.model.ResponseUser
import com.rian.mykasrt.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LaporanActivity : AppCompatActivity() {

    private lateinit var adapter: LaporanAdapter
    private lateinit var rv_laporan: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_laporan)

        rv_laporan = findViewById(R.id.rv_laporan)
        adapter = LaporanAdapter(mutableListOf())

        rv_laporan.layoutManager = LinearLayoutManager(this)
        rv_laporan.adapter = adapter

        getData()
    }

    private fun getData() {
        val apiService = ApiConfig.getApiService()
        val client = apiService.getData()

        client.enqueue(object : Callback<ResponseUser> {
            override fun onResponse(call: Call<ResponseUser>, response: Response<ResponseUser>) {
                if (response.isSuccessful) {
                    val dataArray = response.body()?.data
                    if (dataArray != null) {
                        adapter.setData(dataArray)
                    }
                } else {
                    Toast.makeText(this@LaporanActivity, "Failed to retrieve data", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ResponseUser>, t: Throwable) {
                Toast.makeText(this@LaporanActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
                t.printStackTrace()
            }
        })
    }
}