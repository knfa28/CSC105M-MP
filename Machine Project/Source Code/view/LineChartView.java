package view;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
 
 
public class LineChartView extends Application {   
    private String chartTitle;
    ArrayList<XYChart.Series> series = new ArrayList<XYChart.Series>();
    ArrayList<String> series_name = new ArrayList<String>();
 
    @Override public void start(Stage stage) {
        stage.setTitle("Line Chart View");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Enrollment Count");
        xAxis.setLabel("School Year");
        final LineChart<String,Number> lineChart = new LineChart<String,Number>(xAxis,yAxis);
       
        lineChart.setTitle(chartTitle);
                          
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("1st Year");
        series1.getData().add(new XYChart.Data("2011 - 2012", 1634189));
        series1.getData().add(new XYChart.Data("2012 - 2013", 1658715)); 
        series1.getData().add(new XYChart.Data("2013 - 2014", 1674371)); 
        series1.getData().add(new XYChart.Data("2014 - 2015", 1687500)); 
        series1.getData().add(new XYChart.Data("2015 - 2016", 1713333));
        lineChart.getData().add(series1);
        
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("2nd Year");
        series2.getData().add(new XYChart.Data("2011 - 2012", 1472133));
        series2.getData().add(new XYChart.Data("2012 - 2013", 1476574)); 
        series2.getData().add(new XYChart.Data("2013 - 2014", 1519650));
        series2.getData().add(new XYChart.Data("2014 - 2015", 1562087)); 
        series2.getData().add(new XYChart.Data("2015 - 2016", 1581325));       
        lineChart.getData().add(series2);
        
        XYChart.Series series3 = new XYChart.Series();
        series3.setName("3rd Year");
        series3.getData().add(new XYChart.Data("2011 - 2012", 1658715));
        series3.getData().add(new XYChart.Data("2012 - 2013", 1333950)); 
        series3.getData().add(new XYChart.Data("2013 - 2014", 1363968));
        series3.getData().add(new XYChart.Data("2014 - 2015", 1394064)); 
        series3.getData().add(new XYChart.Data("2015 - 2016", 1449567));  
        lineChart.getData().add(series3);
        
        XYChart.Series series4 = new XYChart.Series();
        series4.setName("4th Year");
        series4.getData().add(new XYChart.Data("2011 - 2012", 1153970));
        series4.getData().add(new XYChart.Data("2012 - 2013", 1172659));
        series4.getData().add(new XYChart.Data("2013 - 2014", 1211147));
        series4.getData().add(new XYChart.Data("2014 - 2015", 1277001));
        series4.getData().add(new XYChart.Data("2015 - 2016", 1260908));
        lineChart.getData().add(series4);
        
        Scene scene  = new Scene(lineChart,800,600);
       
        stage.setScene(scene);
        stage.show();
    }
 
 
    public static void main(String[] args) {
        launch(args);
    }
}