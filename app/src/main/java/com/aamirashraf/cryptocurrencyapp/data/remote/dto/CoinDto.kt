package com.aamirashraf.cryptocurrencyapp.data.remote.dto

import com.aamirashraf.cryptocurrencyapp.domain.model.Coin
import com.google.gson.annotations.SerializedName

data class CoinDto(
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

//this function is used to map coinDto to Coin
//because there is some extra parameter in CoinDto which we doesn't want in Coin
fun CoinDto.toCoin():Coin{
    return Coin(
        id=id,
        isActive=isActive,
        name=name,
        rank=rank,
        symbol=symbol
    )
}