package controller;

import db_connection.File;
import db_connection.TXTFile;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ETL_Driver {
    public void extract() {
        File file = new TXTFile("src/db_connection/config.txt");
        
        if(file.getConnector().getConnection() != null){
            System.out.println("IT WORKS!!!");
            
            ArrayList<String> es_dataset = new ArrayList<String>();
            es_dataset.add("src/data_sets/ES-2011-2012.csv");
            es_dataset.add("src/data_sets/ES-2012-2013.csv");
            es_dataset.add("src/data_sets/ES-2013-2014.csv");
            es_dataset.add("src/data_sets/ES-2014-2015.csv");
            es_dataset.add("src/data_sets/ES-2015-2016.csv");
            
            ArrayList<String> hs_dataset = new ArrayList<String>();
            hs_dataset.add("src/data_sets/HS-2011-2012.csv");
            hs_dataset.add("src/data_sets/HS-2012-2013.csv");
            hs_dataset.add("src/data_sets/HS-2013-2014.csv");
            hs_dataset.add("src/data_sets/HS-2014-2015.csv");
            hs_dataset.add("src/data_sets/HS-2015-2016.csv");
           
            ArrayList<String> year = new ArrayList<String>();
            year.add("2011 - 2012");
            year.add("2012 - 2013");
            year.add("2013 - 2014");
            year.add("2014 - 2015");
            year.add("2015 - 2016");
            
            for(int i = 3; i < 5; i++){
                if(i < 3) {
                    System.out.println("Now extracting: ES " + year.get(i));
                    Extract.readElementary(es_dataset.get(i), year.get(i), false);
                    System.out.println("Now extracting: HS " + year.get(i));
                    Extract.readHighSchool(hs_dataset.get(i), year.get(i), false);                   
                } else if (i >= 3) {
                    System.out.println("Now extracting: ES " + year.get(i));
                    Extract.readElementary(es_dataset.get(i), year.get(i), true);
                    System.out.println("Now extracting: HS " + year.get(i));
                    Extract.readHighSchool(hs_dataset.get(i), year.get(i), true);
                }
            }
                
        }else{
            System.out.println("IT DOESN'T WORK!!!");
            JOptionPane.showMessageDialog(null, "Error connecting to MySQL!", "Message", JOptionPane.ERROR_MESSAGE);
        }
    }
}
