package model;

import db_connection.MySQLConnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModelBase {
    public static ArrayList<Elementary> getElementary(){
        ArrayList<Elementary> objectList = new ArrayList<Elementary>();
        try {
            ResultSet rsList = MySQLConnector.executeQuery("SELECT * from es_enrollment;");
            while(rsList.next()) {
                ArrayList<Double> enroll_count = new ArrayList<Double>();
                enroll_count.add(rsList.getDouble("kinder_m"));
                enroll_count.add(rsList.getDouble("kinder_f"));
                enroll_count.add(rsList.getDouble("grade1_m"));
                enroll_count.add(rsList.getDouble("grade1_f"));
                enroll_count.add(rsList.getDouble("grade2_m"));
                enroll_count.add(rsList.getDouble("grade2_f"));
                enroll_count.add(rsList.getDouble("grade3_m"));
                enroll_count.add(rsList.getDouble("grade3_f"));
                enroll_count.add(rsList.getDouble("grade4_m"));
                enroll_count.add(rsList.getDouble("grade4_f"));
                enroll_count.add(rsList.getDouble("grade5_m"));
                enroll_count.add(rsList.getDouble("grade5_f"));
                enroll_count.add(rsList.getDouble("grade6_m"));
                enroll_count.add(rsList.getDouble("grade6_f"));
                
                objectList.add(new Elementary(rsList.getInt("school_id"),
                                 rsList.getString("school_name"),
                                 rsList.getString("academic_year"), enroll_count));
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
        
        query = "SELECT * from es_enrollment " + condition + ";";
        
        try {
            ResultSet rsList = MySQLConnector.executeQuery(query);
            while(rsList.next()) {
                ArrayList<Double> enroll_count = new ArrayList<Double>();
                enroll_count.add(rsList.getDouble("kinder_m"));
                enroll_count.add(rsList.getDouble("kinder_f"));
                enroll_count.add(rsList.getDouble("grade1_m"));
                enroll_count.add(rsList.getDouble("grade1_f"));
                enroll_count.add(rsList.getDouble("grade2_m"));
                enroll_count.add(rsList.getDouble("grade2_f"));
                enroll_count.add(rsList.getDouble("grade3_m"));
                enroll_count.add(rsList.getDouble("grade3_f"));
                enroll_count.add(rsList.getDouble("grade4_m"));
                enroll_count.add(rsList.getDouble("grade4_f"));
                enroll_count.add(rsList.getDouble("grade5_m"));
                enroll_count.add(rsList.getDouble("grade5_f"));
                enroll_count.add(rsList.getDouble("grade6_m"));
                enroll_count.add(rsList.getDouble("grade6_f"));
                
                objectList.add(new Elementary(rsList.getInt("school_id"),
                                 rsList.getString("school_name"),
                                 rsList.getString("academic_year"), enroll_count));
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
            ResultSet rsList = MySQLConnector.executeQuery("SELECT * from hs_enrollment;");
            while(rsList.next()) {              
                ArrayList<Double> enroll_count = new ArrayList<Double>();
                enroll_count.add(rsList.getDouble("year1_m"));
                enroll_count.add(rsList.getDouble("year1_f"));
                enroll_count.add(rsList.getDouble("year2_m"));
                enroll_count.add(rsList.getDouble("year2_f"));
                enroll_count.add(rsList.getDouble("year3_m"));
                enroll_count.add(rsList.getDouble("year3_f"));
                enroll_count.add(rsList.getDouble("year4_m"));
                enroll_count.add(rsList.getDouble("year4_f"));
                
                objectList.add(new HighSchool(rsList.getInt("school_id"),
                                 rsList.getString("school_name"),
                                 rsList.getString("academic_year"), enroll_count));               
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
        
        query = "SELECT * from hs_enrollment " + condition + ";";
        
        try {
            ResultSet rsList = MySQLConnector.executeQuery(query);
            while(rsList.next()) {              
                ArrayList<Double> enroll_count = new ArrayList<Double>();
                enroll_count.add(rsList.getDouble("year1_m"));
                enroll_count.add(rsList.getDouble("year1_f"));
                enroll_count.add(rsList.getDouble("year2_m"));
                enroll_count.add(rsList.getDouble("year2_f"));
                enroll_count.add(rsList.getDouble("year3_m"));
                enroll_count.add(rsList.getDouble("year3_f"));
                enroll_count.add(rsList.getDouble("year4_m"));
                enroll_count.add(rsList.getDouble("year4_f"));
                
                objectList.add(new HighSchool(rsList.getInt("school_id"),
                                 rsList.getString("school_name"),
                                 rsList.getString("academic_year"), enroll_count));               
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
            ResultSet rsList = MySQLConnector.executeQuery("SELECT * from es_kto12_enrollment;");
            while(rsList.next()) {
                ArrayList<Double> enroll_count = new ArrayList<Double>();
                enroll_count.add(rsList.getDouble("kinder_m"));
                enroll_count.add(rsList.getDouble("kinder_f"));
                enroll_count.add(rsList.getDouble("grade1_m"));
                enroll_count.add(rsList.getDouble("grade1_f"));
                enroll_count.add(rsList.getDouble("grade2_m"));
                enroll_count.add(rsList.getDouble("grade2_f"));
                enroll_count.add(rsList.getDouble("grade3_m"));
                enroll_count.add(rsList.getDouble("grade3_f"));
                enroll_count.add(rsList.getDouble("grade4_m"));
                enroll_count.add(rsList.getDouble("grade4_f"));
                enroll_count.add(rsList.getDouble("grade5_m"));
                enroll_count.add(rsList.getDouble("grade5_f"));
                enroll_count.add(rsList.getDouble("grade6_m"));
                enroll_count.add(rsList.getDouble("grade6_f"));
                enroll_count.add(rsList.getDouble("sped_m"));
                enroll_count.add(rsList.getDouble("sped_f"));
                
                objectList.add(new Elementary(rsList.getInt("school_id"),
                                 rsList.getString("school_name"),
                                 rsList.getString("academic_year"), enroll_count));
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
        
        query = "SELECT * from es_kto12_enrollment " + condition + ";";
        
        try {
            ResultSet rsList = MySQLConnector.executeQuery(query);
            while(rsList.next()) {
                ArrayList<Double> enroll_count = new ArrayList<Double>();
                enroll_count.add(rsList.getDouble("kinder_m"));
                enroll_count.add(rsList.getDouble("kinder_f"));
                enroll_count.add(rsList.getDouble("grade1_m"));
                enroll_count.add(rsList.getDouble("grade1_f"));
                enroll_count.add(rsList.getDouble("grade2_m"));
                enroll_count.add(rsList.getDouble("grade2_f"));
                enroll_count.add(rsList.getDouble("grade3_m"));
                enroll_count.add(rsList.getDouble("grade3_f"));
                enroll_count.add(rsList.getDouble("grade4_m"));
                enroll_count.add(rsList.getDouble("grade4_f"));
                enroll_count.add(rsList.getDouble("grade5_m"));
                enroll_count.add(rsList.getDouble("grade5_f"));
                enroll_count.add(rsList.getDouble("grade6_m"));
                enroll_count.add(rsList.getDouble("grade6_f"));
                enroll_count.add(rsList.getDouble("sped_m"));
                enroll_count.add(rsList.getDouble("sped_f"));
                
                objectList.add(new Elementary(rsList.getInt("school_id"),
                                 rsList.getString("school_name"),
                                 rsList.getString("academic_year"), enroll_count));
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
            ResultSet rsList = MySQLConnector.executeQuery("SELECT * from hs_kto12_enrollment;");
            while(rsList.next()) {
                ArrayList<Double> enroll_count = new ArrayList<Double>();
                enroll_count.add(rsList.getDouble("grade7_m"));
                enroll_count.add(rsList.getDouble("grade7_f"));
                enroll_count.add(rsList.getDouble("grade8_m"));
                enroll_count.add(rsList.getDouble("grade8_f"));
                enroll_count.add(rsList.getDouble("grade9_m"));
                enroll_count.add(rsList.getDouble("grade9_f"));
                enroll_count.add(rsList.getDouble("grade10_m"));
                enroll_count.add(rsList.getDouble("grade10_f"));
                enroll_count.add(rsList.getDouble("grade11_m"));
                enroll_count.add(rsList.getDouble("grade11_f"));
                enroll_count.add(rsList.getDouble("grade12_m"));
                enroll_count.add(rsList.getDouble("grade12_f"));
                enroll_count.add(rsList.getDouble("sped_m"));
                enroll_count.add(rsList.getDouble("sped_f"));
                
                objectList.add(new HighSchool(rsList.getInt("school_id"),
                                 rsList.getString("school_name"),
                                 rsList.getString("academic_year"), enroll_count));
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
        
        query = "SELECT * from hs_kto12_enrollment " + condition + ";";
        
        try {
            ResultSet rsList = MySQLConnector.executeQuery(query);
            while(rsList.next()) {
                ArrayList<Double> enroll_count = new ArrayList<Double>();
                enroll_count.add(rsList.getDouble("grade7_m"));
                enroll_count.add(rsList.getDouble("grade7_f"));
                enroll_count.add(rsList.getDouble("grade8_m"));
                enroll_count.add(rsList.getDouble("grade8_f"));
                enroll_count.add(rsList.getDouble("grade9_m"));
                enroll_count.add(rsList.getDouble("grade9_f"));
                enroll_count.add(rsList.getDouble("grade10_m"));
                enroll_count.add(rsList.getDouble("grade10_f"));
                enroll_count.add(rsList.getDouble("grade11_m"));
                enroll_count.add(rsList.getDouble("grade11_f"));
                enroll_count.add(rsList.getDouble("grade12_m"));
                enroll_count.add(rsList.getDouble("grade12_f"));
                enroll_count.add(rsList.getDouble("sped_m"));
                enroll_count.add(rsList.getDouble("sped_f"));
                
                objectList.add(new HighSchool(rsList.getInt("school_id"),
                                 rsList.getString("school_name"),
                                 rsList.getString("academic_year"), enroll_count));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Base Query - " + objectList.size() + " rows");
        return objectList;
    }
}
