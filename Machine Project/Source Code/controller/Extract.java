package controller;

import model.Elementary;
import model.HighSchool;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import model.MySQLModel;

public class Extract {

    public static void readElementary(String filename, String academic_year, boolean isKto12){
        Path path = Paths.get(filename);
        Charset cs = StandardCharsets.ISO_8859_1;
        String temp;
        int y = 0;
        
        try(BufferedReader reader = Files.newBufferedReader(path, cs)){                
            while((temp = reader.readLine()) != null){
                String[] info = temp.split("#");
                
                int school_id = Integer.parseInt(info[0]);
                String school_name = info[1];
                String region = info[2];
                String province = info[3];
                String municipality = info[4];
                String division = info[5];
                String district = info[6];
                ArrayList<Double> enroll_count = new ArrayList<Double>();
                
                for(int i = 7; i < info.length; i++)
                    enroll_count.add(Double.parseDouble(info[i]));
                
                y++;
                MySQLModel.addElementary(new Elementary(school_id, school_name, region, province, municipality, division, district, academic_year, enroll_count), isKto12);              
                System.out.println("Added row #" + y + " from " + filename);
            }			
      	} catch(IOException x){
            System.err.println(x);
      	}
    }
    
    public static void readHighSchool(String filename, String academic_year, boolean isKto12){
        Path path = Paths.get(filename);
        Charset cs = StandardCharsets.ISO_8859_1;
        String temp;
        int y = 0;
		
        try(BufferedReader reader = Files.newBufferedReader(path, cs)){        
            while((temp = reader.readLine()) != null){
                String[] info = temp.split("#");
                
                int school_id = Integer.parseInt(info[0]);
                String school_name = info[1];
                String region = info[2];
                String province = info[3];
                String municipality = info[4];
                String division = info[5];
                ArrayList<Double> enroll_count = new ArrayList<Double>();
                
                for(int i = 6; i < info.length; i++)
                    enroll_count.add(Double.parseDouble(info[i]));
                
                y++;
                MySQLModel.addHighschool(new HighSchool(school_id, school_name, region, province, municipality, division, academic_year, enroll_count), isKto12);
                System.out.println("Added row #" + y + " from " + filename);
            }
      	} catch(IOException x){
            System.err.println(x);
      	}
    }
}
