package com.example.flightsearch.ui.screens.flight_screen

import com.example.flightsearch.model.Airport
import com.example.flightsearch.model.Favorite


data class FlightsUiState(
    val code: String = "",
    val favoriteList: List<Favorite> = emptyList(),
    val destinationList: List<Airport> = emptyList(),
    val departureAirport: Airport = Airport(),
)