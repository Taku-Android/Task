package com.example.route

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.route.api.model.Product
import com.example.route.databinding.ProductItemBinding
import java.text.DecimalFormat


class ProductAdapter(var items: List<Product?>?) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>()  {

    class ProductViewHolder(var binding: ProductItemBinding ) : RecyclerView.ViewHolder(binding.root){
        fun bind(product: Product?) {
            binding.product = product
            binding.invalidateAll()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {

        val binding = DataBindingUtil.inflate<ProductItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.product_item,
            parent,
            false
        )

        return ProductViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

        val item = items?.get(position);
        holder.bind(item)
        val withDiscount = item!!.price?.minus(item!!.discountPercentage!!)
        val decimalFormat = DecimalFormat("0.00")
        val formattedPriceDiscount: String = decimalFormat.format(withDiscount)
        val formattedPrice: String = decimalFormat.format(item.price)

        holder.binding.productPrice.text = "EGP $formattedPriceDiscount"
        holder.binding.reviewCount.text =  "Review (${item!!.rating})"

        holder.binding.productPriceDiscunt.setPaintFlags(holder.binding.productPriceDiscunt.getPaintFlags() or Paint.STRIKE_THRU_TEXT_FLAG)
        holder.binding.productPriceDiscunt.text = "${formattedPrice} EGP "

    }

    override fun getItemCount(): Int = items?.size ?: 0


    fun changeData(products: List<Product?>?){
        items = products;
        notifyDataSetChanged()
    }

}
