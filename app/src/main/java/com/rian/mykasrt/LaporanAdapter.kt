package com.rian.mykasrt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rian.mykasrt.model.DataItem

class LaporanAdapter(private val data: MutableList<DataItem>) :
    RecyclerView.Adapter<LaporanAdapter.ListViewHolder>() {
    constructor() : this(mutableListOf())
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_laporan, parent, false)
        return ListViewHolder(view)
    }

    fun setData(dataItems: List<DataItem>) {
        data.clear()
        data.addAll(dataItems)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val item = data[position]

        holder.tvJumlahIuranBulanan.text = "1. Jumlah iuran Bulanan : "+ item.Jumlah_Iuran_Bulanan.toString()
        holder.tvTotalIuran.text = "2. Total Iuran      : "+ item.Total_Iuran_Warga.toString()
        holder.tvPengeluaran.text = "3. Pengeluaran     : "+ item.Pengeluaran_Iuran_Warga.toString()
        holder.tvPemanfaatan.text = "4. Pemanfaatan     :  "+ item.Pemanfaatan_Iuran
    }

    class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var tvJumlahIuranBulanan: TextView = itemView.findViewById(R.id.jumlahIuranBulananTextView)
        var tvPengeluaran: TextView = itemView.findViewById(R.id.pengeluaranTextView)
        var tvPemanfaatan: TextView = itemView.findViewById(R.id.pemanfaatanTextView)
        var tvTotalIuran: TextView = itemView.findViewById(R.id.totalIuranTextView) // Typo, diganti menjadi tvTotalIuran
    }
}