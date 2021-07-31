package com.example.demo1;

import java.awt.Color;
import java.io.IOException;
import java.util.List;
import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.VectorGraphicsEncoder;
import org.knowm.xchart.style.Styler;
import tech.tablesaw.api.Table;

/**
 *
 * @author GHADA KAMEL
 */
public class Graph {
    public void pieChart(Table WuzzfData){
        Table company_count=WuzzfData.countBy("company").sortDescendingOn("count");

        List<String> companyNames = company_count.first(10).stringColumn("category").asList();
        List<Integer> counts = company_count.first(10).intColumn("count").asList();

        PieChart chart = new PieChartBuilder().width(1110).height(1024).title("Most Demanding Companies For Jobs").build();

        Color[] sliceColors = new Color[11];

        for(int i=0;i<11;i++){
            sliceColors[i] = new Color((int) (Math.random( )*256), (int)(Math.random( )*256), (int)(Math.random( )*256));
        }
        chart.getStyler ().setSeriesColors (sliceColors);

        for(int i =0;i<10;i++){
            chart.addSeries(companyNames.get(i),counts.get(i));
        }

        try {
            BitmapEncoder.saveJPGWithQuality(chart,"src/main/resources/MostDemanding.jpg",1f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            VectorGraphicsEncoder.saveVectorGraphic(chart, "src/main/resources/Sample_Chart", VectorGraphicsEncoder.VectorGraphicsFormat.PDF);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //new SwingWrapper(chart).displayChart();
    }

    public void barChartJobs(Table WuzzfData){

        Table titleCount=WuzzfData.countBy("Title").sortDescendingOn("count");

        List<String> jobTitle = titleCount.first(8).stringColumn("category").asList();

        List<Integer> jobTitleCount = titleCount.first(8).intColumn("count").asList();

        CategoryChart bar = new CategoryChartBuilder ().width (1024).height (768).title ("Jobs Title ").xAxisTitle (" Title").yAxisTitle ("Count").build ();
        Color[] sliceColors = new Color[]{new Color (180, 68, 50)};
        bar.getStyler().setLegendPosition(Styler.LegendPosition.InsideNE);
        bar.getStyler ().setHasAnnotations (true);
        bar.getStyler ().setStacked (true);
        bar.getStyler().setAnnotationsFontColor(Color.black);
        bar.getStyler().setSeriesColors(sliceColors);

        bar.addSeries("Jobs Count", jobTitle,jobTitleCount);
        try {
            BitmapEncoder.saveJPGWithQuality(bar,"src/main/resources/static./Jobs Title.jpg",1f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //new SwingWrapper (bar).displayChart ();

    }

    public void barChartAreas(Table WuzzfData) {

        Table areaCount = WuzzfData.countBy("Location").sortDescendingOn("count");

        List<String> jobLocation = areaCount.first(8).stringColumn("category").asList();

        List<Integer> jobLocationCount = areaCount.first(8).intColumn("count").asList();

        CategoryChart bar = new CategoryChartBuilder ().width (1024).height (768).title ("Jobs Location").xAxisTitle ("Location").yAxisTitle ("Count").build ();
        Color[] sliceColors = new Color[]{new Color (180, 68, 50)};
        bar.getStyler().setLegendPosition(Styler.LegendPosition.InsideNE);
        bar.getStyler ().setHasAnnotations (true);
        bar.getStyler ().setStacked (true);
        //bar.getStyler().setAnnotationsFontColor(Color.black);
        bar.getStyler().setSeriesColors(sliceColors);
        bar.addSeries(" Jobs Location", jobLocation,jobLocationCount);

        try {
            BitmapEncoder.saveJPGWithQuality(bar,"src/main/resources/static./Jobs Location.jpg",1f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //new SwingWrapper (bar).displayChart ();
    }
}