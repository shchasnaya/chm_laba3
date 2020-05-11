package sample;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.mariuszgromada.math.mxparser.Argument;

import javax.swing.*;

public class Graph {
    public static void show(String function, double a, double b) {
        final XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries a_line = new XYSeries("A");
        XYSeries b_line = new XYSeries("B");
        XYSeries series = new XYSeries("Graph");
        for (double i = a; i < b; i = i + 0.1) {
            series.add(i, functions(function, i));
        }
        dataset.addSeries(series);



        JFreeChart chart = ChartFactory
                .createXYLineChart("function", "x", "y",
                        dataset,
                        PlotOrientation.VERTICAL,
                        true, true, true);
        JFrame jFrame = new JFrame("MinimalStaticChart");
        jFrame.getContentPane()
                .add(new ChartPanel(chart));
        jFrame.setSize(800, 600);
        jFrame.show();

    }

    static double functions(String expression, Double variable) {
        String line = "x= " + variable.toString();
        Argument var = new Argument(line);
        org.mariuszgromada.math.mxparser.Expression e = new org.mariuszgromada.math.mxparser.Expression(expression, var);
        return e.calculate();
    }
}
