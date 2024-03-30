package com.rian.mykasrt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.rian.mykasrt.databinding.ActivityInformationBinding
import com.rian.mykasrt.model.DataItem

class ActivityInformation : AppCompatActivity() {

    private lateinit var binding: ActivityInformationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInformationBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    private fun displayUserData(userData: DataItem) {
        // Menampilkan gambar pengguna menggunakan Glide
        Glide.with(this)
            .load(userData.Gambar)
            .placeholder(R.drawable.icon_avatar) // Placeholder jika gambar tidak tersedia
            .error(R.drawable.icon_avatar) // Gambar kesalahan jika ada masalah saat memuat gambar
            .transform(CircleCrop()) // Mengubah gambar menjadi lingkaran
            .into(binding.itemAvatar)

        // Menampilkan nama pengguna
        binding.itemName.text = "${userData.Nama_Depan} ${userData.Nama_Belakang}"

        // Menampilkan email pengguna
        binding.itemEmail.text = userData.Email

        // Menampilkan alamat pengguna
        binding.itemAddress.text = userData.Alamat

        // Menampilkan total iuran pengguna
        binding.itemTotalIuran.text = userData.Total_Iuran_Individu.toString() // Ubah ke string karena TextView menerima string
    }
}