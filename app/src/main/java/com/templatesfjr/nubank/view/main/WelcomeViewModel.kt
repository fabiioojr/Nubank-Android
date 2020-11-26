package com.templatesfjr.nubank.view.main

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.templatesfjr.nubank.R
import com.templatesfjr.nubank.data.model.ItemMenu
import com.templatesfjr.nubank.utils.NubankRouter

class WelcomeViewModel(
    private val router: NubankRouter
) : ViewModel() {

    var balanceVisible: Boolean = true
    val balanceVisibleClicked = MutableLiveData<Unit>()

    fun onBackButton() {
        router.onBackPressed()
    }

    fun prepareMenus(): List<ItemMenu> {
        return listOf(
            ItemMenu(
                "Pix",
                R.drawable.image_4
            ),
            ItemMenu(
                "Pagar",
                R.drawable.barcode_product_1
            ),
            ItemMenu(
                "Indicar amigos",
                R.drawable.add_friend_1
            ),
            ItemMenu(
                "Transferir",
                R.drawable.coin_1_1
            ),
            ItemMenu(
                "Depositar",
                R.drawable.coin_1_1
            ),
            ItemMenu(
                "Cartão Virtual",
                R.drawable.coin_1_1
            ),
            ItemMenu(
                "Recargas de Celular",
                R.drawable.coin_1_1
            ),
            ItemMenu(
                "Cobrar",
                R.drawable.coin_1_1
            ),
            ItemMenu(
                "Me Ajuda",
                R.drawable.coin_1_1
            )
        )
    }

    fun toggleVisibility() {
        balanceVisible = !balanceVisible
        balanceVisibleClicked.postValue(Unit)
    }

    fun getBalanceVisibility(balanceVisible: Boolean?): Int =
        takeIf { balanceVisible == true }?.run { View.VISIBLE } ?: View.GONE
}