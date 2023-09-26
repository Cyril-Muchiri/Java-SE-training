package com.systechafrica.dbloggers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.regex.Pattern;

import javax.swing.text.DateFormatter;

public class CustomFormatter extends Formatter {

    @Override
    public String format(LogRecord record) {
       
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
       String classMethod= record.getSourceClassName()+" "+record.getSourceMethodName();
       String level=record.getLevel().getName();
String message= record.getMessage();
LocalDateTime now=LocalDateTime.now();

return pattern.format(now)+"|"+level+"|"+classMethod+"|"+message+"\n";
        // throw new UnsupportedOperationException("Unimplemented method 'format'");
    }
    
}
