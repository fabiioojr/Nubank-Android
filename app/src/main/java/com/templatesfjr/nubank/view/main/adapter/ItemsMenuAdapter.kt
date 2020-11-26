package com.templatesfjr.nubank.view.main.adapter

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.templatesfjr.nubank.R
import com.templatesfjr.nubank.utils.NubankRouter
import com.templatesfjr.nubank.databinding.ItemMenuBinding
import com.templatesfjr.nubank.data.model.ItemMenu

class ItemsMenuAdapter(
    private val context: Context,
    var listMenus: List<ItemMenu>,
    private val router: NubankRouter
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MenuViewHolder(
            context,
            DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.item_menu,
                parent,
                false
            ), router
        )
    }

    override fun getItemCount(): Int {
        return listMenus.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        listMenus[position].let {
            (holder as MenuViewHolder).setData(it)
        }
    }

    class MenuViewHolder(
        val context: Context,
        val binding: ItemMenuBinding,
        val router: NubankRouter
    ) :
        RecyclerView.ViewHolder(binding.root) {
        @TargetApi(Build.VERSION_CODES.M)

        fun setData(contract: ItemMenu) {
            binding.apply {
                title = contract.title
                iconMenu = contract.icon?.let { context.getDrawable(it) }
                onClick = View.OnClickListener {
                }
            }
        }
    }
}