package com.example.flightsearch.ui.screens.flight_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.flightsearch.data.MockData
import com.example.flightsearch.model.Airport
import com.example.flightsearch.model.Favorite

/**
 * Muestra una lista de vuelos que se pueden filtrar
 * por un codigo de aeropuerto de origen y una lista de favoritos
 * que se pueden agregar o eliminar.
 *
 * @param modifier Modificador de la pantalla de favoritos
 * @param departureAirport Aeropuerto de origen
 * @param destinationList Lista de aeropuertos de destino
 * @param favoriteList Lista de favoritos
 * @param onFavoriteClick Funcion que se llama cuando se selecciona un favorito
 */
@Composable
fun FlightResults(
    modifier: Modifier = Modifier,
    departureAirport: Airport,
    destinationList: List<Airport>,
    favoriteList: List<Favorite>,
    onFavoriteClick: (String, String) -> Unit
) {
    Column {
        //Text(text = uiState.value.play)
        LazyColumn(
            modifier = modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            items(destinationList, key = { it.id }) { item ->
                val isFavorite = favoriteList.find { f ->
                    f.departureCode == departureAirport.code &&
                            f.destinationCode == item.code
                }

                FlightRow(
                    isFavorite = isFavorite != null,
                    departureAirportCode = departureAirport.code,
                    departureAirportName = departureAirport.name,
                    destinationAirportCode = item.code,
                    destinationAirportName = item.name,
                    onFavoriteClick = onFavoriteClick
                )
            }
        }
    }
}

@Preview
@Composable
fun FlightResultsPreview() {
    val mockData = MockData.airports

    FlightResults(
        departureAirport = mockData[0],
        destinationList = mockData,
        favoriteList = emptyList(),
        onFavoriteClick = { _: String, _: String -> }
    )
}