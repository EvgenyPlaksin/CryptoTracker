package com.lnight.cryptotracker.crypto.data.networking.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinDto(
    @SerialName("id")
    val id: String,
    @SerialName("marketCapUsd")
    val marketCapUsd: Double,
    @SerialName("name")
    val name: String,
    @SerialName("priceUsd")
    val priceUsd: Double,
    @SerialName("rank")
    val rank: Int,
    @SerialName("symbol")
    val symbol: String,
    @SerialName("changePercent24Hr")
    val changePercent24Hr: Double
)