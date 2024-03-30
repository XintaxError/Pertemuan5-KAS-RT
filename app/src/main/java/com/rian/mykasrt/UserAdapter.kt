package com.rian.mykasrt
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.rian.mykasrt.model.DataItem

class UserAdapter(private val users: MutableList<DataItem>):
    RecyclerView.Adapter<UserAdapter.ListViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent,false)
        return ListViewHolder(
            view
        )
    }

    fun setUsers(users: List<DataItem>) {
        this.users.clear()
        this.users.addAll(users)
        notifyDataSetChanged()
    }

    fun addUser(newUser: DataItem?) {
        newUser?.let {
            users.add(it)
            notifyItemInserted(users.lastIndex)
        }
    }

    fun clear(){
        users.clear()
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int){
        val user = users[position]

        Glide.with(holder.itemView.context)
            .load(user.Gambar)
            .apply(RequestOptions().override(80, 80).placeholder(R.drawable.icon_avatar))
            .transform(CircleCrop())
            .into(holder.tvAvatar)
        holder.tvUserName.text = "${user.Nama_Depan} ${user.Nama_Belakang}"
        holder.tvEmail.text = user.Email
        holder.tvAddress.text = user.Alamat
        holder.tvTotalIuran.text = "Total Iuran Rp." + user.Total_Iuran_Individu.toString() // Ubah ke string karena TextView menerima string
    }

    class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var tvUserName: TextView = itemView.findViewById(R.id.itemName)
        var tvEmail: TextView = itemView.findViewById(R.id.itemEmail)
        var tvAvatar: ImageView = itemView.findViewById(R.id.itemAvatar)
        var tvAddress: TextView = itemView.findViewById(R.id.itemAddress)
        var tvTotalIuran: TextView = itemView.findViewById(R.id.itemTotalIuran) // Typo, diganti menjadi tvTotalIuran
    }
}