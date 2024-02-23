package com.aamirashraf.cryptocurrencyapp.presentation.coin_list


import androidx.lifecycle.ViewModel
import com.aamirashraf.cryptocurrencyapp.domain.usecases.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {
    // ViewModel logic goes here
}