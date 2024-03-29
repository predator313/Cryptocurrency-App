package com.aamirashraf.cryptocurrencyapp.presentation.coin_list


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aamirashraf.cryptocurrencyapp.common.Resource
import com.aamirashraf.cryptocurrencyapp.domain.usecases.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {
    // ViewModel logic goes here
    private val _state = mutableStateOf(CoinListState())
    val state:State<CoinListState> = _state

    init {
        getCoins()
    }

    private fun getCoins(){
        getCoinsUseCase().onEach {result->
            when(result){
                is Resource.Success->{
                    _state.value= CoinListState(coins = result.data?: emptyList())
                }
                is Resource.Error ->{
                    _state.value= CoinListState(error=result.message?:"An unknown Error Occur")
                }
                is Resource.Loading ->{
                    _state.value= CoinListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}