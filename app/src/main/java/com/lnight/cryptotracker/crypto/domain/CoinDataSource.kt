package com.lnight.cryptotracker.crypto.domain

import com.lnight.cryptotracker.core.domain.util.NetworkError
import com.lnight.cryptotracker.core.domain.util.Result

interface CoinDataSource {
    suspend fun getCoins(): Result<List<Coin>, NetworkError>
}