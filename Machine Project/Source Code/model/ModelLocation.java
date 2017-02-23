package model;

import db_connection.MySQLConnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModelLocation {
    public static ArrayList<String> getRegion(){
        ArrayList<String> objectList = new ArrayList<String>();
        try {
            ResultSet rsList = MySQLConnector.executeQuery("SELECT DISTINCT(region) FROM es_enrollment UNION\n" +
                                                            "SELECT DISTINCT(region) FROM hs_enrollment UNION\n" +
                                                            "SELECT DISTINCT(region) FROM es_kto12_enrollment UNION\n" +
                                                            "SELECT DISTINCT(region) FROM hs_kto12_enrollment;");
            while(rsList.next()) {              
                objectList.add(rsList.getString("region"));               
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Base Query - " + objectList.size() + " rows");
        return objectList;
    }
    
    public static ArrayList<String> getProvince(){
        ArrayList<String> objectList = new ArrayList<String>();
        try {
            ResultSet rsList = MySQLConnector.executeQuery("SELECT DISTINCT(province) FROM es_enrollment UNION\n" +
                                                            "SELECT DISTINCT(province) FROM hs_enrollment UNION\n" +
                                                            "SELECT DISTINCT(province) FROM es_kto12_enrollment UNION\n" +
                                                            "SELECT DISTINCT(province) FROM hs_kto12_enrollment;");
            while(rsList.next()) {              
                objectList.add(rsList.getString("province"));               
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Base Query - " + objectList.size() + " rows");
        return objectList;
    }
    
    public static ArrayList<String> getMunicipality(){
        ArrayList<String> objectList = new ArrayList<String>();
        try {
            ResultSet rsList = MySQLConnector.executeQuery("SELECT DISTINCT(municipality) FROM es_enrollment UNION\n" +
                                                            "SELECT DISTINCT(municipality) FROM hs_enrollment UNION\n" +
                                                            "SELECT DISTINCT(municipality) FROM es_kto12_enrollment UNION\n" +
                                                            "SELECT DISTINCT(municipality) FROM hs_kto12_enrollment;");
            while(rsList.next()) {              
                objectList.add(rsList.getString("municipality"));               
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Base Query - " + objectList.size() + " rows");
        return objectList;
    }
    
    public static ArrayList<String> getDivision(){
        ArrayList<String> objectList = new ArrayList<String>();
        try {
            ResultSet rsList = MySQLConnector.executeQuery("SELECT DISTINCT(division) FROM es_enrollment UNION\n" +
                                                            "SELECT DISTINCT(division) FROM hs_enrollment UNION\n" +
                                                            "SELECT DISTINCT(division) FROM es_kto12_enrollment UNION\n" +
                                                            "SELECT DISTINCT(division) FROM hs_kto12_enrollment;");
            while(rsList.next()) {              
                objectList.add(rsList.getString("division"));               
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Base Query - " + objectList.size() + " rows");
        return objectList;
    }
    
    public static ArrayList<String> getDistrict(){
        ArrayList<String> objectList = new ArrayList<String>();
        try {
            ResultSet rsList = MySQLConnector.executeQuery("SELECT DISTINCT(district) FROM es_enrollment UNION\n" +
                                                            "SELECT DISTINCT(district) FROM es_kto12_enrollment");
            while(rsList.next()) {              
                objectList.add(rsList.getString("district"));               
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Base Query - " + objectList.size() + " rows");
        return objectList;
    }
}
