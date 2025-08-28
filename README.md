# World Cup Results App
This repository contains an Android application that allows users to browse through historical FIFA World Cup match data from 1930 to 2014.

## Features

*   **View Match Details:** Displays the year, stadium, home team, away team, and final score for each match.
*   **Data-driven UI:** Loads all match data from a local `worldcup.csv` file at runtime.
*   **Simple Navigation:** Users can cycle through match records using "Next" and "Previous" buttons.

## How It Works

The application follows a simple architecture to display the World Cup data.

*   **Data Source**: A comprehensive `worldcup.csv` file located in the `app/src/main/assets/` directory serves as the local database for all match records.

*   **Data Parsing and Management**:
    *   On startup, `MainActivity` reads the `worldcup.csv` file.
    *   The `CSVParser` utility class processes each line of the CSV, extracting relevant fields based on predefined column indices managed by the `DataIndexsSingleTon`.
    *   Each parsed line is converted into a `MatchModelRecord` object.
    *   The `DataManager` singleton stores all `MatchModelRecord` objects in an in-memory `ArrayList` and manages the state, tracking the currently displayed match.

*   **User Interface**:
    *   The UI is defined in `activity_main.xml` and consists of `TextViews` to display match information.
    *   `MainActivity` is responsible for binding the data from the current `MatchModelRecord` to the UI elements.
    *   The "Next" and "Previous" `ImageViews` trigger methods in `DataManager` to update the current match index and refresh the UI with the new data.

## Data Structure

The application parses the `worldcup.csv` file and utilizes the following data fields for each match:

*   **Year**: The year the match was played.
*   **Stadium**: The name of the stadium where the match took place.
*   **City**: The host city of the match.
*   **Home Team Name**: The name of the home team.
*   **Away Team Name**: The name of the away team.
*   **Home Team Goals**: The number of goals scored by the home team.
*   **Away Team Goals**: The number of goals scored by the away team.

## Getting Started

To build and run this project, follow these steps:

1.  **Clone the repository:**
    ```sh
    git clone https://github.com/nourhanbakry/WorldCup.git
    ```
2.  **Open in Android Studio:**
    *   Open Android Studio.
    *   Select `File` > `Open` and navigate to the cloned repository folder.
3.  **Build and Run:**
    *   Let Android Studio sync the Gradle files.
    *   Click the `Run 'app'` button or use the `Shift + F10` shortcut to build and deploy the application to an emulator or a connected Android device.
