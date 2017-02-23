package model;

import model.*;
import db_connection.MySQLConnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModelTrends {
    public static ArrayList<Elementary> getElementary(){
        ArrayList<Elementary> objectList = new ArrayList<Elementary>();
        try {
            ResultSet rsList = MySQLConnector.executeQuery("SELECT DISTINCT(school_id), region, province, municipality, division, district, school_name, grand_total FROM es_enrollment ORDER BY school_id");
            while(rsList.next()) {             
                objectList.add(new Elementary(rsList.getInt("school_id"),
                                 rsList.getString("school_name"),
                                 rsList.getString("region"),
                                 rsList.getString("province"),
                                 rsList.getString("municipality"),
                                 rsList.getString("division"),
                                 rsList.getString("district"),
                                 rsList.getDouble("grand_total")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Base Query - " + objectList.size() + " rows");
        return objectList;
    }
    
    public static ArrayList<Elementary> drillDownElementary(ArrayList<String> cond){
        ArrayList<Elementary> objectList = new ArrayList<Elementary>();
        
        String query;
        String condition = "";
        
        if(!cond.isEmpty()){
            condition = "WHERE ";

            for(int i = 0; i < cond.size() - 1; i ++)
                condition = condition.concat(cond.get(i) + " AND ");

            condition = condition.concat(cond.get(cond.size() - 1));
        }
        
        query = "SELECT DISTINCT(school_id), region, province, municipality, division, district, school_name, grand_total FROM es_enrollment " + condition + "ORDER BY school_id";
        
        try {
            ResultSet rsList = MySQLConnector.executeQuery(query);
            while(rsList.next()) {             
                objectList.add(new Elementary(rsList.getInt("school_id"),
                                 rsList.getString("school_name"),
                                 rsList.getString("region"),
                                 rsList.getString("province"),
                                 rsList.getString("municipality"),
                                 rsList.getString("division"),
                                 rsList.getString("district"),
                                 rsList.getDouble("grand_total")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Base Query - " + objectList.size() + " rows");
        return objectList;
    }
    
    public static ArrayList<HighSchool> getHighSchool(){
        ArrayList<HighSchool> objectList = new ArrayList<HighSchool>();
        try {
            ResultSet rsList = MySQLConnector.executeQuery("SELECT DISTINCT(school_id), region, province, municipality, division, school_name, grand_total FROM hs_enrollment ORDER BY school_id");
            while(rsList.next()) {             
                objectList.add(new HighSchool(rsList.getInt("school_id"),
                                 rsList.getString("school_name"),
                                 rsList.getString("region"),
                                 rsList.getString("province"),
                                 rsList.getString("municipality"),
                                 rsList.getString("division"),
                                 rsList.getDouble("grand_total")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Base Query - " + objectList.size() + " rows");
        return objectList;
    }
    
    public static ArrayList<HighSchool> drillDownHighSchool(ArrayList<String> cond){
        ArrayList<HighSchool> objectList = new ArrayList<HighSchool>();
        
        String query;
        String condition = "";
        
        if(!cond.isEmpty()){
            condition = "WHERE ";

            for(int i = 0; i < cond.size() - 1; i ++)
                condition = condition.concat(cond.get(i) + " AND ");

            condition = condition.concat(cond.get(cond.size() - 1));
        }
        
        query = "SELECT DISTINCT(school_id), region, province, municipality, division, school_name, grand_total FROM hs_enrollment " + condition + "ORDER BY school_id;";
        
        try {
            ResultSet rsList = MySQLConnector.executeQuery(query);
            while(rsList.next()) {             
                objectList.add(new HighSchool(rsList.getInt("school_id"),
                                 rsList.getString("school_name"),
                                 rsList.getString("region"),
                                 rsList.getString("province"),
                                 rsList.getString("municipality"),
                                 rsList.getString("division"),
                                 rsList.getDouble("grand_total")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Base Query - " + objectList.size() + " rows");
        return objectList;
    }
    
    public static ArrayList<Elementary> getEKto12(){
        ArrayList<Elementary> objectList = new ArrayList<Elementary>();
        try {
            ResultSet rsList = MySQLConnector.executeQuery("SELECT DISTINCT(school_id), region, province, municipality, division, district, school_name, grand_total FROM es_kto12_enrollment ORDER BY school_id");
            while(rsList.next()) {             
                objectList.add(new Elementary(rsList.getInt("school_id"),
                                 rsList.getString("school_name"),
                                 rsList.getString("region"),
                                 rsList.getString("province"),
                                 rsList.getString("municipality"),
                                 rsList.getString("division"),
                                 rsList.getString("district"),
                                 rsList.getDouble("grand_total")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Base Query - " + objectList.size() + " rows");
        return objectList;
    }
    
    public static ArrayList<Elementary> drillDownEKto12(ArrayList<String> cond){
        ArrayList<Elementary> objectList = new ArrayList<Elementary>();
        
        String query;
        String condition = "";
        
        if(!cond.isEmpty()){
            condition = "WHERE ";

            for(int i = 0; i < cond.size() - 1; i ++)
                condition = condition.concat(cond.get(i) + " AND ");

            condition = condition.concat(cond.get(cond.size() - 1));
        }
        
        query = "SELECT DISTINCT(school_id), region, province, municipality, division, district, school_name, grand_total FROM es_kto12_enrollment " + condition + "ORDER BY school_id";
        
        try {
            ResultSet rsList = MySQLConnector.executeQuery(query);
            while(rsList.next()) {             
                objectList.add(new Elementary(rsList.getInt("school_id"),
                                 rsList.getString("school_name"),
                                 rsList.getString("region"),
                                 rsList.getString("province"),
                                 rsList.getString("municipality"),
                                 rsList.getString("division"),
                                 rsList.getString("district"),
                                 rsList.getDouble("grand_total")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Base Query - " + objectList.size() + " rows");
        return objectList;
    }
    
    public static ArrayList<HighSchool> getHKto12(){
        ArrayList<HighSchool> objectList = new ArrayList<HighSchool>();
        try {
            ResultSet rsList = MySQLConnector.executeQuery("SELECT DISTINCT(school_id), region, province, municipality, division, school_name, grand_total FROM hs_kto12_enrollment ORDER BY school_id");
            while(rsList.next()) {             
                objectList.add(new HighSchool(rsList.getInt("school_id"),
                                 rsList.getString("school_name"),
                                 rsList.getString("region"),
                                 rsList.getString("province"),
                                 rsList.getString("municipality"),
                                 rsList.getString("division"),
                                 rsList.getDouble("grand_total")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Base Query - " + objectList.size() + " rows");
        return objectList;
    }
    
    public static ArrayList<HighSchool> drillDownHKto12(ArrayList<String> cond){
        ArrayList<HighSchool> objectList = new ArrayList<HighSchool>();
        
        String query;
        String condition = "";
        
        if(!cond.isEmpty()){
            condition = "WHERE ";

            for(int i = 0; i < cond.size() - 1; i ++)
                condition = condition.concat(cond.get(i) + " AND ");

            condition = condition.concat(cond.get(cond.size() - 1));
        }
        
        query = "SELECT DISTINCT(school_id), region, province, municipality, division, school_name, grand_total FROM hs_kto12_enrollment " + condition + "ORDER BY school_id;";
        
        try {
            ResultSet rsList = MySQLConnector.executeQuery(query);
            while(rsList.next()) {             
                objectList.add(new HighSchool(rsList.getInt("school_id"),
                                 rsList.getString("school_name"),
                                 rsList.getString("region"),
                                 rsList.getString("province"),
                                 rsList.getString("municipality"),
                                 rsList.getString("division"),
                                 rsList.getDouble("grand_total")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Base Query - " + objectList.size() + " rows");
        return objectList;
    }
    
    public static ArrayList<HighSchool> graphHighschool()
    {
        ArrayList<HighSchool> objectList = new ArrayList<HighSchool>();
        ArrayList<Double> enroll_count = new ArrayList<Double>();
    	String query = "SELECT region, province, municipality, division, academic_year, sum(year1_f + year1_m), sum(year2_f + year2_m), sum(year3_f + year3_m), sum(year4_f + year4_m)" +  
    			"FROM enrollment_dataset.hs_enrollment" + 
    			"GROUP BY region, province, municipality, division, academic_year;";
    	
    	try {
            ResultSet rsList = MySQLConnector.executeQuery(query);
            while(rsList.next()) {
            	
            	enroll_count = new ArrayList<Double>();
            	enroll_count.add(rsList.getDouble("sum(year1_f + year1_m"));
            	enroll_count.add(rsList.getDouble("sum(year2_f + year2_m"));
            	enroll_count.add(rsList.getDouble("sum(year3_f + year3_m"));
            	enroll_count.add(rsList.getDouble("sum(year4_f + year4_m"));
                objectList.add(new HighSchool(rsList.getString("region"),
                                 rsList.getString("province"),
                                 rsList.getString("municipality"),
                                 rsList.getString("division"),
                                 rsList.getString("academic_year"),
                                 enroll_count
                                 ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Base Query - " + objectList.size() + " rows");
        return objectList;
    
    	
    }
    
}
