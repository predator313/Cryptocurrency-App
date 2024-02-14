package com.aamirashraf.cryptocurrencyapp.domain.repository

import com.aamirashraf.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.aamirashraf.cryptocurrencyapp.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins():List<CoinDto>

    suspend fun getCoinById(coinId:String):CoinDetailDto
}