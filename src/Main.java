import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image; // Import Image class
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class Main extends Application {

    private TextField num1Field;
    private TextField num2Field;
    private Label resultLabel;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Colorful Simple Calculator");

        // --- Add Icon to the Stage ---
        try {
            // Load your image file.
            // If logo.png is directly in the src folder, you can use "/logo.png"
            // If it's in src/images/logo.png, use "/images/logo.png"
            Image applicationIcon = new Image(getClass().getResourceAsStream("/calc-icon.png")); // *** REPLACE THIS PATH ***
            primaryStage.getIcons().add(applicationIcon);
        } catch (Exception e) {
            System.err.println("Could not load application icon: " + e.getMessage());
            // Handle the error, maybe show a default icon or nothing
        }
        // --- End Add Icon ---


        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setStyle("-fx-background-color: #e9e9e9;");

        Label num1Label = new Label("Number 1:");
        GridPane.setConstraints(num1Label, 0, 0);

        num1Field = new TextField();
        num1Field.setPromptText("Enter first number");
        GridPane.setConstraints(num1Field, 1, 0);
        GridPane.setHgrow(num1Field, Priority.ALWAYS);


        Label num2Label = new Label("Number 2:");
        GridPane.setConstraints(num2Label, 0, 1);

        num2Field = new TextField();
        num2Field.setPromptText("Enter second number");
        GridPane.setConstraints(num2Field, 1, 1);
        GridPane.setHgrow(num2Field, Priority.ALWAYS);


        resultLabel = new Label("Result: ");
        GridPane.setConstraints(resultLabel, 0, 2, 3, 1);
        resultLabel.setStyle("-fx-font-weight: bold;");


        Button addButton = new Button("+");
        addButton.setPrefSize(70, 40);
        addButton.setOnAction(e -> performOperation('+'));
        addButton.setStyle("-fx-background-color: #a8e6cf; -fx-font-weight: bold; -fx-font-size: 14px;");

        Button subtractButton = new Button("-");
        subtractButton.setPrefSize(70, 40);
        subtractButton.setOnAction(e -> performOperation('-'));
        subtractButton.setStyle("-fx-background-color: #ffaaa5; -fx-font-weight: bold; -fx-font-size: 14px;");


        Button multiplyButton = new Button("*");
        multiplyButton.setPrefSize(70, 40);
        multiplyButton.setOnAction(e -> performOperation('*'));
        multiplyButton.setStyle("-fx-background-color: #ffd3b6; -fx-font-weight: bold; -fx-font-size: 14px;");


        Button divideButton = new Button("/");
        divideButton.setPrefSize(70, 40);
        divideButton.setOnAction(e -> performOperation('/'));
        divideButton.setStyle("-fx-background-color: #ffffb5; -fx-font-weight: bold; -fx-font-size: 14px;");


        HBox topButtons = new HBox(10);
        topButtons.setAlignment(Pos.CENTER);
        topButtons.getChildren().addAll(addButton, subtractButton);
        GridPane.setConstraints(topButtons, 2, 0);
        GridPane.setHgrow(topButtons, Priority.ALWAYS);


        HBox bottomButtons = new HBox(10);
        bottomButtons.setAlignment(Pos.CENTER);
        bottomButtons.getChildren().addAll(multiplyButton, divideButton);
        GridPane.setConstraints(bottomButtons, 2, 1);
        GridPane.setHgrow(bottomButtons, Priority.ALWAYS);

        grid.getChildren().addAll(
            num1Label, num1Field, num2Label, num2Field, resultLabel,
            topButtons, bottomButtons
        );

        Scene scene = new Scene(grid, 420, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void performOperation(char operator) {
        String num1Text = num1Field.getText();
        String num2Text = num2Field.getText();

        try {
            double num1 = Double.parseDouble(num1Text);
            double num2 = Double.parseDouble(num2Text);
            double result = 0.0;

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        resultLabel.setText("Result: Error (Cannot divide by zero)");
                        return;
                    }
                    result = num1 / num2;
                    break;
                default:
                    return;
            }

            resultLabel.setText("Result: " + result);

        } catch (NumberFormatException e) {
            resultLabel.setText("Result: Error (Invalid input)");
        }
    }
}