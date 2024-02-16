package com.aamirashraf.cryptocurrencyapp.data.repository

import com.aamirashraf.cryptocurrencyapp.data.remote.CoinPaprikaApi
import com.aamirashraf.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.aamirashraf.cryptocurrencyapp.data.remote.dto.CoinDto
import com.aamirashraf.cryptocurrencyapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
):CoinRepository {


    //in this class we got the actual implementation of the repository
    //as we know that the in repository we do many expensive operation
    //so the repository is not ideal for testing
    //so we implement the two repository which helps in testing easier
    override suspend fun getCoins(): List<CoinDto> {

        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}