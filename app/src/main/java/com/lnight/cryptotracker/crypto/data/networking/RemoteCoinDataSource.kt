package com.lnight.cryptotracker.crypto.data.networking

import com.lnight.cryptotracker.core.data.networking.constructUrl
import com.lnight.cryptotracker.core.data.networking.safeCall
import com.lnight.cryptotracker.core.domain.util.NetworkError
import com.lnight.cryptotracker.core.domain.util.Result
import com.lnight.cryptotracker.core.domain.util.map
import com.lnight.cryptotracker.crypto.data.mappers.toCoin
import com.lnight.cryptotracker.crypto.data.networking.dto.CoinsResponseDto
import com.lnight.cryptotracker.crypto.domain.Coin
import com.lnight.cryptotracker.crypto.domain.CoinDataSource
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RemoteCoinDataSource(
    private val httpClient: HttpClient
): CoinDataSource {

    override suspend fun getCoins(): Result<List<Coin>, NetworkError> {
        return withContext(Dispatchers.IO) {
            safeCall<CoinsResponseDto> {
                httpClient.get(
                    urlString = constructUrl("/assets")

                )
            }.map { response ->
                response.data.map { it.toCoin() }
            }
        }
    }
}