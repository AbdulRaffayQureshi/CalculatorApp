# JavaFX Basic Calculator

A simple yet beautiful calculator application built with JavaFX 21 and Java 24. This project demonstrates the use of JavaFX for creating modern desktop applications with a clean user interface.

![Calculator Icon](./assets/icon.png)

## Features

- Basic arithmetic operations: addition, subtraction, multiplication, division
- Responsive and intuitive UI
- Custom application icon
- Built with JavaFX 21
- Runs on Java 24

## Requirements

- **Java 24** (JDK 24 or later)
- **JavaFX 21** libraries ([Download JavaFX](https://gluonhq.com/products/javafx/))
- (Optional) JavaFX Scene Builder for UI prototyping

## Setup

1. **Clone the repository:**

   ```sh
   git clone https://github.com/yourusername/CalculatorApp.git
   cd CalculatorApp
   ```

2. **Download JavaFX 21:**

   - Visit [https://gluonhq.com/products/javafx/](https://gluonhq.com/products/javafx/) and download the JavaFX SDK for your platform.
   - Extract the SDK and note the path to the `lib` directory.

3. **Compile and Run:**

   ```sh
   javac --module-path /path/to/javafx-sdk-21/lib --add-modules javafx.controls,javafx.fxml -d out src/*.java
   java --module-path /path/to/javafx-sdk-21/lib --add-modules javafx.controls,javafx.fxml -cp out Main
   ```

   Replace `/path/to/javafx-sdk-21/lib` with the actual path to your JavaFX SDK `lib` folder.

4. **Icon:**
   - The application uses a custom icon located at `assets/icon.png`. Make sure this file exists or replace it with your preferred icon.

## Screenshots

<p align="center">
  <img src="assets/screenshot.png" alt="Calculator UI" width="400"/>
</p>

## Beautiful UI

The calculator features a modern, minimalistic design with clear buttons and a responsive layout. The color scheme and button styles are chosen for clarity and ease of use.

<p align="center">
  <img src="https://user-images.githubusercontent.com/yourusername/yourrepo/main/assets/final-output.png" alt="Colorful Simple Calculator Output" width="400"/>
</p>

## License

This project is licensed under the MIT License.

---

> **Note:** JavaFX Scene Builder was downloaded for this project but not used in the final implementation.
