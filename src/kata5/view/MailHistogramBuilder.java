package kata5.view;

import kata5.model.Mail;
import kata5.model.Histogram;
import java.util.List;

public class MailHistogramBuilder {
 
    public static Histogram<String> build (List<Mail> mailList){
        Histogram<String> histogram = new Histogram<>();
    
        for (Mail mail: mailList){
            histogram.increment(mail.getDomain());
        }
        
        return histogram;
    }
    
}
