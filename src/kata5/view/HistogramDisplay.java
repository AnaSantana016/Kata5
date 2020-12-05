package kata5.view;

import kata5.model.Histogram;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class HistogramDisplay extends ApplicationFrame{
    
    private final Histogram<String> histogram;
    
     public HistogramDisplay(String title, Histogram<String> histogram) {
        super(title);
        this.histogram = histogram;
        this.setContentPane(createPanel());
        this.pack();
    }
    
    private JPanel createPanel(){
        ChartPanel charPanel = new ChartPanel(createChart(createDataset()));
        return charPanel;
    }
    
    private JFreeChart createChart(DefaultCategoryDataset dataSet){
        JFreeChart freeChart = ChartFactory.createBarChart("JFreeChart Hitogram",
                                                       "email domains", 
                                                       "nº emails", 
                                                       dataSet, 
                                                       PlotOrientation.VERTICAL,
                                                       false, 
                                                       false, 
                                                       rootPaneCheckingEnabled);
        return freeChart;
    }
    
    private DefaultCategoryDataset createDataset(){
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        
        int other = 0;
        for (String key : this.histogram.keySet()) {
            
            if(histogram.get(key) > 1)
                dataSet.addValue(this.histogram.get(key), "", key);
            else 
                other++;
        }
         
        dataSet.addValue(other, "", "other");
        
        return dataSet;
    }
    
    public void execute(){
        this.setVisible(true);
    }
    
}
