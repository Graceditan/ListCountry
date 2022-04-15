package binar.and.lima.listcountry.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import binar.and.lima.listcountry.R
import binar.and.lima.listcountry.model.GetAllCountryResponseItem
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_country.view.*

class AdapterCountry (private var datacountry : List<GetAllCountryResponseItem>): RecyclerView.Adapter<AdapterCountry.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewitem = LayoutInflater.from(parent.context).inflate(
            R.layout
                .item_country, parent, false
        )
        return ViewHolder(viewitem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.tv_namecountry.text = datacountry[position].name
        holder.itemView.tv_capitalcountry.text = datacountry[position].capital
        holder.itemView.tv_languangecountry.text = datacountry[position].languages.toString()

        Glide.with(holder.itemView.context).load(datacountry[position].flags.png).into(holder.itemView.img_flagcountry)

    }

    override fun getItemCount(): Int {
        return datacountry.size


    }
}