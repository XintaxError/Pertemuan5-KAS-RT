package com.rian.mykasrt

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MenuAcitivity : AppCompatActivity() {

    private lateinit var tombolSatu: LinearLayout
    private lateinit var tombolDua: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_acitivity)

        val decorView: View = window.decorView
        decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        tombolSatu = findViewById(R.id.cdMenu1)
        tombolSatu.setOnClickListener {
            val intent = Intent(this@MenuAcitivity, MainActivity::class.java)
            startActivity(intent)
        }

        tombolDua = findViewById(R.id.cdMenu2)
        tombolDua.setOnClickListener {
            val intent = Intent(this@MenuAcitivity, LaporanActivity::class.java)
            startActivity(intent)
        }
    }
}
