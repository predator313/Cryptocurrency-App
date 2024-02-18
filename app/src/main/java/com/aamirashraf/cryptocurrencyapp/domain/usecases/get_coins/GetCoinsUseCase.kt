package com.aamirashraf.cryptocurrencyapp.domain.usecases.get_coins

import com.aamirashraf.cryptocurrencyapp.common.Resource
import com.aamirashraf.cryptocurrencyapp.data.remote.dto.toCoin
import com.aamirashraf.cryptocurrencyapp.domain.model.Coin
import com.aamirashraf.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import java.net.HttpRetryException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke():Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins=repository.getCoins().map { it.toCoin() }
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