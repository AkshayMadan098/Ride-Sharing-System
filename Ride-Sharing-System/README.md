# Ride Sharing System

A robust, console-based Ride Sharing System offering core functionalities for riders and drivers. This application demonstrates the use of standard software design patterns to handle dynamic strategies for ride matching and fare calculation.

## 🚀 Features

*   **Rider Management**: Register new riders effortlessly.
*   **Driver Management**: Onboard drivers and track their availability.
*   **Ride Management**:
    *   **Request a Ride**: Riders can request rides based on available drivers.
    *   **Complete a Ride**: Process ride completion and generate fare receipts.
*   **Smart Matching**: Matches riders with drivers using configurable strategies (e.g., Least Active Driver, Nearest Driver).
*   **Dynamic Pricing**: Calculates fares based on different strategies (e.g., Peak Hour, Default).

## 🛠 Tech Stack

*   **Language**: Java 17
*   **Build Tool**: Maven
*   **Testing**: JUnit 5, Mockito

## 🏗 Design Patterns

This project leverages the **Strategy Pattern** to allow flexible switching of algorithms at runtime:

1.  **Ride Matching Strategy**:
    *   `LeastActiveDriverStrategy`: Prioritizes drivers who have completed the fewest rides.
    *   `NearestDriverStrategy`: Finds the driver closest to the rider's location.

2.  **Fare Calculation Strategy**:
    *   `DefaultFareStrategy`: Standard distance/time-based calculation.
    *   `PeakHourFareStrategy`: Applies a multiplier during high-demand periods.

## 🏁 Getting Started

### Prerequisites

*   JDK 17 or higher
*   Maven 3.6+

### Installation

1.  **Clone the repository**:
    ```bash
    git clone https://github.com/AkshayMadan098/Ride-Sharing-System.git
    cd Ride-Sharing-System
    ```

2.  **Build the project**:
    ```bash
    mvn clean install
    ```

### Running the Application

You can run the application directly using the Maven exec plugin or by running the generated JAR file.

**Using IDE (IntelliJ/Eclipse):**
*   Locate the main class: `src/main/java/com/airtribe/ridesharingsystem/RideBookingApplication.java`
*   Run the `main` method.

**Using Command Line:**
*(Assuming the jar is built in the target directory)*
```bash
java -cp target/ride-sharing-system-1.0-SNAPSHOT.jar com.airtribe.ridesharingsystem.RideBookingApplication
```

## 🎮 Usage Example

Upon running the application, you will be presented with a menu:

```text
1. Add Rider
2. Add Driver
3. View Available Drivers
4. Request Ride
5. Exit
```

**Scenario:**
1.  **Register a Driver**: Select `2` and enter details (e.g., Name: "Rahul").
2.  **Register a Rider**: Select `1` and enter details (e.g., Name: "Akshay").
3.  **Request a Ride**: Select `4`. The system will match "Akshay" with "Rahul" and calculate the fare upon completion.

## 🧪 Running Tests

Execute the unit tests to verify the system logic:

```bash
mvn test
```
