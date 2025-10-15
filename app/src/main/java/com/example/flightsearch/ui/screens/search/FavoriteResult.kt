package com.example.flightsearch.ui.screens.search

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.flightsearch.model.Airport
import com.example.flightsearch.model.Favorite
import com.example.flightsearch.ui.screens.flight_screen.FlightRow

/**
 * Muestra una lista de favoritos con sus respectivos codigos de aeropuerto,
 * nombres de aeropuerto y botones para agregar o eliminar favoritos.
 *
 * @param modifier Modificador de la pantalla de favoritos
 * @param airportList Lista de aeropuertos
 * @param favoriteList Lista de favoritos
 * @param onFavoriteClick Funcion que se llama cuando se selecciona un favorito
 */
@Composable
fun FavoriteResult(
    modifier: Modifier = Modifier,
    airportList: List<Airport>,
    favoriteList: List<Favorite>,
    onFavoriteClick: (String, String) -> Unit
) {
    LazyColumn(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        items(favoriteList, key = { it.id }) { item ->
            val departAirport = airportList.first { airport -> airport.code == item.departureCode }
            val destinationAirport =
                airportList.first { airport -> airport.code == item.destinationCode }
            FlightRow(
                isFavorite = true,
                departureAirportCode = departAirport.code,
                departureAirportName = departAirport.name,
                destinationAirportCode = destinationAirport.code,
                destinationAirportName = destinationAirport.name,
                onFavoriteClick = onFavoriteClick
            )
        }
    }
}