# CryptoTracker

CryptoTracker is an Android app for tracking cryptocurrency prices and viewing price history using a custom interactive chart. It’s built with Jetpack Compose for the UI, Ktor for networking, and Koin for dependency injection.

## Features

- **Cryptocurrency Price Tracking**: Fetches the latest cryptocurrency prices from an API.
- **Price History**: Displays the price history of coins in an interactive line chart.
- **Coin Details**: View detailed information about each coin, such as market cap, volume, and 24-hour change.

## Tech Stack

- **Kotlin**
- **Jetpack Compose**: For building the app's modern UI.
- **Ktor**: For making network requests to fetch cryptocurrency data.
- **Koin**: For managing dependency injection.

## Screenshots
<img src="https://github.com/user-attachments/assets/d32f07e6-c23a-418a-b57d-70dcf27d9cfe" width="200" height="400" />
<img src="https://github.com/user-attachments/assets/4b3ba59e-1211-414a-a306-86e1769fda1b" width="200" height="400" />
<img src="https://github.com/user-attachments/assets/61ef3d3b-14c6-4064-8296-fe259090f278" width="400" height="200" />

## Prerequisites

- **Android SDK**: Minimum version 24.

## Getting Started

### Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/EvgenyPlaksin/CryptoTracker.git
    ```
2. Open the project in Android Studio.
3. Sync the project with Gradle files.
4. Build and run the project on an Android device or emulator.

### Usage

1. Launch the app to view the list of cryptocurrencies and their latest prices.
2. Tap on any coin to access detailed information and view its price history.
3. Use the line chart to view the price history data.

## Dependencies

The project utilizes the following dependencies:

- **Ktor**: For network requests to fetch cryptocurrency data.
- **Jetpack Compose**: For building a modern and responsive UI.
- **Koin**: Dependency injection framework.
- **Material3**: For Material Design components.
- - **Material3 Adaptive Navigation**: For a responsive two-screen layout in landscape mode.
- **Kotlinx Serialization**: For JSON serialization and deserialization.

## Contributing

Contributions are welcome! Feel free to open issues or submit pull requests.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
