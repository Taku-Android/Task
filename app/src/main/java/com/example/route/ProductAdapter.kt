package com.example.route

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.route.api.model.Product
import com.example.route.databinding.ProductItemBinding

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
    }

    override fun getItemCount(): Int = items?.size ?: 0


    fun changeData(products: List<Product?>?){
        items = products;
        notifyDataSetChanged()
    }

}
