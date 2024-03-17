package com.aamirashraf.cryptocurrencyapp.presentation

sealed class Screen(route:String) {
    object CoinListScreen:Screen("coin_list_screen")
    object CoinDetailScreen:Screen("coin_list_screen")
}