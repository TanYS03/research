package src;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.collections.FXCollections;
import java.util.Arrays;


public class Main extends Application {

    @Override
    public void start(Stage stage) {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");

        //Create x-axis and Y-axis
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList("June", "July", "August", "September", "October", "November", "December")));
        NumberAxis yAxis = new NumberAxis();

        // Create chart
        BarChart<String, Number> chart = new BarChart<>(xAxis, yAxis);
//        StackedBarChart<String, Number> chart = new StackedBarChart<>(xAxis, yAxis);
        chart.setTitle("Total of Created Job & Pending Job");
        Assignment a = new Assignment();

        //Create data arrays
        String[] datax = a.getMonth();
        int[] datay = a.getAmount();

        //Create series data
        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
        series1.setName("CreatedJob");
        for (int i = 0; i < datax.length; i++) {
            series1.getData().add(new XYChart.Data<>(datax[i], datay[i]));
        }

//        Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        Scene scene = new Scene(chart, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}