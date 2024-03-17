package com.aamirashraf.cryptocurrencyapp.presentation.coin_list

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun CoinListScreen(
    navController: NavController,
    viewModel: CoinListViewModel= androidx.hilt.navigation.compose.hiltViewModel()
){
    val state = viewModel.state.value
    androidx.compose.foundation.layout.Box(modifier = Modifier.fillMaxSize()) {
        androidx.compose.foundation.lazy.LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.coins){coin->
                com.aamirashraf.cryptocurrencyapp.presentation.coin_list.component.CoinListItem(coin = coin,
                    onItemClick = {
                        navController.navigate(Screen.CointDetailScreen.route+ "/{coin.id}")
                    }
                    ) {

                }

            }

        }
        if(state.error.isNotBlank()){
            androidx.compose.material3.Text(text = state.error,
                color = androidx.compose.material3.MaterialTheme.colorScheme.error,
                textAlign = androidx.compose.ui.text.style.TextAlign.Companion.Center,
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
                )
        }
        if(state.isLoading){
            androidx.compose.material3.CircularProgressIndicator(
                modifier = Modifier.align(androidx.compose.ui.Alignment.Companion.Center)
            )
        }
    }
}