package com.aamirashraf.cryptocurrencyapp.domain.usecases.get_coins

import com.aamirashraf.cryptocurrencyapp.domain.repository.CoinRepository
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
}