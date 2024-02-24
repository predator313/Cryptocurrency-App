package com.aamirashraf.cryptocurrencyapp.presentation.coin_details

import com.aamirashraf.cryptocurrencyapp.domain.model.Coin
import com.aamirashraf.cryptocurrencyapp.domain.model.CoinDetails

data class CoinDetailState(
    val isLoading:Boolean=false,
    val coin:CoinDetails?=null,
    val error:String=""
)
