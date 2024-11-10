package com.lnight.cryptotracker.crypto.presentation.coin_list

import com.lnight.cryptotracker.core.domain.util.NetworkError

sealed interface CoinListEvent {
    data class Error(val error: NetworkError): CoinListEvent
}