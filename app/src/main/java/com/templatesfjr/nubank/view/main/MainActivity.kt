package com.templatesfjr.nubank.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.templatesfjr.nubank.databinding.ActivityMainBinding
import org.koin.core.parameter.parametersOf
import org.koin.android.viewmodel.ext.android.viewModel
import androidx.databinding.DataBindingUtil.setContentView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.templatesfjr.nubank.R
import com.templatesfjr.nubank.utils.NubankRouter
import com.templatesfjr.nubank.data.model.ItemMenu
import com.templatesfjr.nubank.view.main.adapter.ItemsMenuAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_bank.*


class MainActivity : AppCompatActivity() {

    private val router = NubankRouter(this)
    private lateinit var binding: ActivityMainBinding

    private val viewModel: WelcomeViewModel by viewModel {
        parametersOf(NubankRouter(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupObservers()
        binding = setContentView(
            this,
            R.layout.activity_main
        )
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        populateAdapter(viewModel.prepareMenus())
    }

    private fun populateAdapter(arrayList: List<ItemMenu>) {
        arrayList.let {
            binding.menus.apply {
                layoutManager =
                    LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
                adapter = ItemsMenuAdapter(this@MainActivity, it, router)
            }
        }
    }

    private fun setupObservers() {
        viewModel
            .balanceVisibleClicked
            .observe(this, Observer {
                if (viewModel.balanceVisible) {
                    visible.setImageResource(R.drawable.ic_visibility_visible)
                    value_credit_card_block.visibility = View.VISIBLE
                } else {
                    visible.setImageResource(R.drawable.visibility_1)
                    value_credit_card_block.visibility = View.INVISIBLE
                }
            })
    }
}