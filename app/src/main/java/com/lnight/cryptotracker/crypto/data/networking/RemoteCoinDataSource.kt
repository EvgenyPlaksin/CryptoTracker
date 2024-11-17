package com.lnight.cryptotracker.crypto.data.networking

import com.lnight.cryptotracker.core.data.networking.constructUrl
import com.lnight.cryptotracker.core.data.networking.safeCall
import com.lnight.cryptotracker.core.domain.util.NetworkError
import com.lnight.cryptotracker.core.domain.util.Result
import com.lnight.cryptotracker.core.domain.util.map
import com.lnight.cryptotracker.crypto.data.mappers.toCoin
import com.lnight.cryptotracker.crypto.data.mappers.toCoinPrice
import com.lnight.cryptotracker.crypto.data.networking.dto.CoinHistoryDto
import com.lnight.cryptotracker.crypto.data.networking.dto.CoinsResponseDto
import com.lnight.cryptotracker.crypto.domain.Coin
import com.lnight.cryptotracker.crypto.domain.CoinDataSource
import com.lnight.cryptotracker.crypto.domain.CoinPrice
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.time.ZoneId
import java.time.ZonedDateTime

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

    override suspend fun getCoinHistory(
        coinId: String,
        start: ZonedDateTime,
        end: ZonedDateTime
    ): Result<List<CoinPrice>, NetworkError> {
        val startMillis = start
            .withZoneSameInstant(ZoneId.of("UTC"))
            .toInstant()
            .toEpochMilli()

        val endMillis = end
            .withZoneSameInstant(ZoneId.of("UTC"))
            .toInstant()
            .toEpochMilli()

        return withContext(Dispatchers.IO) {
            safeCall<CoinHistoryDto> {
                httpClient.get(
                    urlString = constructUrl("/assets/$coinId/history")
                ) {
                    parameter("interval", "h6")
                    parameter("start", startMillis)
                    parameter("end", endMillis)
                }
            }.map { response ->
                response.data.map { it.toCoinPrice() }
            }
        }
    }
}