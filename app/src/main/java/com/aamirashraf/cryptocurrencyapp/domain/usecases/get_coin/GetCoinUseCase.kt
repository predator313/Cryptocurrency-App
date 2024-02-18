package com.aamirashraf.cryptocurrencyapp.domain.usecases.get_coin

import com.aamirashraf.cryptocurrencyapp.common.Resource
import com.aamirashraf.cryptocurrencyapp.data.remote.dto.toCoin
import com.aamirashraf.cryptocurrencyapp.data.remote.dto.toCoinDetail
import com.aamirashraf.cryptocurrencyapp.domain.model.Coin
import com.aamirashraf.cryptocurrencyapp.domain.model.CoinDetails
import com.aamirashraf.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import java.net.HttpRetryException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId:String):Flow<Resource<CoinDetails>> = flow {
        try {
            emit(Resource.Loading())
            val coins=repository.getCoinById(coinId ).toCoinDetail()
            emit(Resource.Success(coins))
        }
        catch (e:HttpRetryException){
            emit(Resource.Error(e.localizedMessage?:"unknown Error"))
        }
        catch (e:IOException){
            emit(Resource.Error("Check your Internet"))
        }
    }
}