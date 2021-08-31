package android.ptc.com.ptcflixing.view.search

import android.annotation.SuppressLint
import android.ptc.com.ptcflixing.R
import android.ptc.com.ptcflixing.databinding.ItemSearchBinding
import android.ptc.com.ptcflixing.model.response.search.SearchModel
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class SearchAdapter(private var data: MutableList<SearchModel>) :
    RecyclerView.Adapter<SearchAdapter.VH>() {
    class VH(var binding: ItemSearchBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding =
            ItemSearchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VH(binding)
    }

    @SuppressLint("StringFormatInvalid", "StringFormatMatches")
    override fun onBindViewHolder(holder: VH, position: Int) {
        Glide.with(holder.binding.imgPoaster.context).load(data[position].image)
            .placeholder(R.mipmap.launcher)
            .into(holder.binding.imgPoaster)
        holder.binding.txtBrand.text = data[position].brand
        holder.binding.txtName.text = data[position].name
        holder.binding.txtPrice.text = data[position].specialPrice
        holder.binding.txtOldPrice.text = data[position].price
        holder.binding.txtDiscount.text =
            holder.binding.imgPoaster.context.getString(
                R.string.txt_discount,
                data[position].maxSavingPercentage
            )
        holder.binding.ratingBar.rating = data[position].ratingAverage ?: 0F
    }

    fun updateData(items: List<SearchModel>) {
        data.clear()
        data.addAll(items)
        notifyDataSetChanged()
    }

    override fun getItemCount() = data.size
}