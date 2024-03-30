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

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: UserAdapter
    private lateinit var rv_users: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_users = findViewById(R.id.rv_users)
        adapter = UserAdapter(mutableListOf())

        rv_users.layoutManager = LinearLayoutManager(this)
        rv_users.adapter = adapter

        getUser()
    }

    private fun getUser() {
        val apiService = ApiConfig.getApiService()
        val client = apiService.getUsers()

        client.enqueue(object : Callback<ResponseUser> {
            override fun onResponse(call: Call<ResponseUser>, response: Response<ResponseUser>) {
                if (response.isSuccessful) {
                    val dataArray = response.body()?.data
                    if (dataArray != null) {
                        adapter.setUsers(dataArray)
                    }
                } else {
                    Toast.makeText(this@MainActivity, "Failed to retrieve data", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ResponseUser>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
                t.printStackTrace()
            }
        })
    }
    fun openActivityInformation(view: View) {
        val intent = Intent(this, ActivityInformation::class.java)
        startActivity(intent)
    }

}
