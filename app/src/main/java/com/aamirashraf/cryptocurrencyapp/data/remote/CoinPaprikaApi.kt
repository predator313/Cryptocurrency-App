package com.aamirashraf.cryptocurrencyapp.data.remote

import com.aamirashraf.cryptocurrencyapp.domain.model.Coin
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {
    //v1/coins/ is the end point
    //prior to this there is baseUrl
    //after the end point there is query parameter which use for the filtering purpose
    @GET("/v1/coins")
    suspend fun getCoins():List<Coin>

    //get coins by id like bitcoin dogeCoin etc
    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId")coinId:String)
}