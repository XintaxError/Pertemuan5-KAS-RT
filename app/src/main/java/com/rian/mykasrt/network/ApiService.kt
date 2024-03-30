package com.rian.mykasrt.network
import com.rian.mykasrt.model.ResponseUser
import retrofit2.http.GET
import retrofit2.Call

interface ApiService {

    @GET(".")
    fun getUsers(): Call<ResponseUser>
    @GET(".")
    fun getData(): Call<ResponseUser>
    @GET("Jumlah_Iuran_Bulanan")
    fun getJumlahIuranBulanan(): Call<Int>

    @GET("Total_Iuran")
    fun getTotalIuran(): Call<Int>

    @GET("Pengeluaran_Iuran_Warga")
    fun getPengeluaranIuran(): Call<Int>

    @GET("Pemanfaatan_Iuran")
    fun getPemanfaatanIuran(): Call<Int>
}