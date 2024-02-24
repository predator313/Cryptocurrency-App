package com.aamirashraf.cryptocurrencyapp.presentation.coin_details


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aamirashraf.cryptocurrencyapp.common.PARAM_COIN_ID
import com.aamirashraf.cryptocurrencyapp.common.Resource
import com.aamirashraf.cryptocurrencyapp.domain.usecases.get_coin.GetCoinUseCase
import com.aamirashraf.cryptocurrencyapp.domain.usecases.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
    savedStateHandle: SavedStateHandle  //this is like a bundle
) : ViewModel() {
    // ViewModel logic goes here
    private val _state = mutableStateOf(CoinDetailState())
    val state:State<CoinDetailState> = _state

    init {
        savedStateHandle.get<String>(PARAM_COIN_ID)?.let {coinId->
            getCoins(coinId)
        }

    }

    private fun getCoins(coinId:String){
        getCoinUseCase(coinId).onEach {result->
            when(result){
                is Resource.Success->{
                    _state.value= CoinDetailState(coin = result.data)
                }
                is Resource.Error ->{
                    _state.value= CoinDetailState(error=result.message?:"An unknown Error Occur")
                }
                is Resource.Loading ->{
                    _state.value= CoinDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}