# Flight Search App

Flight Search es una aplicación de Android que permite a los usuarios buscar vuelos y guardarlos como favoritos. La aplicación utiliza una base de datos local para almacenar información sobre aeropuertos y vuelos favoritos, y está construida siguiendo las mejores prácticas de la arquitectura de Android moderna.

## Estructura del Proyecto

El proyecto está organizado en los siguientes paquetes principales:

*   **`data`**: Contiene las clases relacionadas con el acceso y la gestión de datos.
*   **`di`**: Contiene la configuración para la inyección de dependencias.
*   **`model`**: Contiene las clases de modelo que representan los datos de la aplicación.
*   **`ui`**: Contiene los componentes de la interfaz de usuario, organizados por pantalla.

### Clases Principales

A continuación se describe cada una de las clases importantes del proyecto:

#### `data`

*   **`FlightDao`**: Interfaz de objeto de acceso a datos (DAO) para la base de datos de Room. Define los métodos para interactuar con la base de datos, como obtener aeropuertos, obtener vuelos favoritos e insertar/eliminar favoritos.
*   **`FlightDatabase`**: Clase de base de datos de Room que define la base de datos de la aplicación y sus tablas.
*   **`FlightRepository`**: Interfaz que define los métodos para acceder a los datos de la aplicación, ya sea desde una fuente de datos local o remota.
*   **`OfflineFlightRepository`**: Implementación de `FlightRepository` que obtiene los datos de la base de datos local de Room.
*   **`MockData`**: Proporciona datos de muestra para la base de datos, como la lista de aeropuertos.
*   **`UserPreferences`**: Gestiona las preferencias del usuario, como el tema de la aplicación.

#### `di`

*   **`AppContainer`**: Clase que gestiona la inyección de dependencias, proporcionando instancias de clases como `FlightRepository`.

#### `model`

*   **`Airport`**: Clase de datos que representa un aeropuerto, con propiedades como el código IATA y el nombre.
*   **`Favorite`**: Clase de datos que representa un vuelo favorito, con los códigos de los aeropuertos de salida y llegada.

#### `ui`

*   **`screens/search`**:
    *   **`SearchViewModel`**: ViewModel para la pantalla de búsqueda, que gestiona la lógica de búsqueda de aeropuertos y la visualización de resultados.
    *   **`SearchResults`**: Composable que muestra los resultados de la búsqueda de aeropuertos.
    *   **`FavoriteResult`**: Composable que muestra la lista de vuelos favoritos.
    *   **`SearchTextField`**: Composable para el campo de texto de búsqueda.
*   **`screens/flight_screen`**:
    *   **`FlightViewModel`**: ViewModel para la pantalla de resultados de vuelos, que muestra los posibles vuelos desde un aeropuerto de salida seleccionado.
    *   **`FlightResults`**: Composable que muestra la lista de vuelos de destino.
    *   **`FlightRow`**: Composable que representa una sola fila en la lista de vuelos, ya sea un resultado de búsqueda o un favorito.

*   **`MainActivity`**: Actividad principal de la aplicación que aloja los Composables de la interfaz de usuario.
*   **`FlightSearchApp`**: Composable principal de la aplicación que configura la navegación entre las diferentes pantallas.
*   **`FlightApplication`**: Clase de aplicación que inicializa el contenedor de inyección de dependencias.
*   **`NavigationDestination`**: Interfaz que define los destinos de navegación en la aplicación.

## Cómo Compilar y Ejecutar

1.  Clona este repositorio.
2.  Abre el proyecto en Android Studio.
3.  Ejecuta la aplicación en un emulador o dispositivo físico.

## Dependencias

El proyecto utiliza las siguientes dependencias principales:

*   **Jetpack Compose**: Para la creación de la interfaz de usuario.
*   **Room**: Para la persistencia de datos locales.
*   **Kotlin Coroutines**: Para la gestión de operaciones asíncronas.
*   **ViewModel**: Para gestionar la lógica de la interfaz de usuario y el estado.
*   **Navigation Compose**: Para la navegación entre pantallas.
*   **DataStore**: Para almacenar preferencias de usuario simples.