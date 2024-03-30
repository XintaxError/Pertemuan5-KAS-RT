package com.rian.mykasrt.model

data class DataItem(
    val Nama_Depan: String,
    val Nama_Belakang: String,
    val Email: String,
    val Alamat: String,
    val Jumlah_Iuran_Bulanan: Int,
    val Total_Iuran_Individu: Int,
    val Total_Iuran_Warga: Int,
    val Pengeluaran_Iuran_Warga: Int,
    val Pemanfaatan_Iuran: String,
    val Gambar: String
)
