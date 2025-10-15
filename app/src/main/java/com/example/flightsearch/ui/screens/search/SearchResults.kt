package com.example.flightsearch.ui.screens.search

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.flightsearch.model.Airport


/**
 * Muestra una lista de aeropuertos que se pueden seleccionar.
 *
 * @param modifier Modificador de la pantalla de resultados.
 * @param airports Lista de aeropuertos que se pueden seleccionar.
 * @param onSelectCode Funcion que se llama cuando se selecciona un codigo de aeropuerto.
 */
@Composable
fun SearchResults(
    modifier: Modifier = Modifier,
    airports: List<Airport>,
    onSelectCode: (String) -> Unit,
) {
    LazyColumn(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        items(
            items = airports
        ) {
            Card(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 8.dp
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
            ) {
                AirportRow(
                    code = it.code,
                    name = it.name,
                    onSelectCode = onSelectCode,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp)
                )
            }
        }
    }
}

//@Preview
//@Composable
//fun XPreview() {
//    val mockData = MockData.airports
//    SearchResults(
//        airports = mockData,
//        onSelectCode = {},
//    )
//}