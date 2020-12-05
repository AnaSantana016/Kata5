package kata5;

import kata5.view.MailHistogramBuilder;
import kata5.view.HistogramDisplay;
import kata5.model.Mail;
import kata5.model.Histogram;
import java.io.IOException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Kata5 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        Class.forName("org.sqlite.JDBC");
        List<Mail> listEmail= new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:data/us500.db"); 
             Statement statement = connection.createStatement()) {
            
            ResultSet result = statement.executeQuery("SELECT * FROM people");
            while (result.next()){
                String email = result.getString("email");
                System.out.println(email);
                listEmail.add(new Mail(email));
            }
                    
        }
        
        Histogram<String> histogram = MailHistogramBuilder.build(listEmail);        
        HistogramDisplay histogramDisplay = new HistogramDisplay("HISTOGRAM...", histogram);        
        histogramDisplay.execute();
        
    }
    
}
