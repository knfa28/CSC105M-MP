package model;

import db_connection.MySQLConnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModelSped {
    public static ArrayList<Elementary> getElementary(){
        ArrayList<Elementary> objectList = new ArrayList<Elementary>();
        ArrayList<Double> enroll_count = new ArrayList<Double>();
        
        try {
            ResultSet rsList = MySQLConnector.executeQuery("SELECT DISTINCT(school_id), school_name, region, province, municipality, division, district, academic_year, \n" +
                                                            "sum(grade1_m), sum(grade1_f),\n" +
                                                            "sum(grade2_m), sum(grade2_f),\n" +
                                                            "sum(grade3_m), sum(grade3_f),\n" +
                                                            "sum(grade4_m), sum(grade4_f),\n" +
                                                            "sum(grade5_m), sum(grade5_f),\n" +
                                                            "sum(kinder_m), sum(kinder_f),\n" +
                                                            "sum(sped_m), sum(sped_f)\n" +
                                                            "FROM enrollment_data.es_kto12_enrollment GROUP BY school_id;");
            while(rsList.next()) {
                enroll_count = new ArrayList<Double>();
                enroll_count.add(rsList.getDouble("sum(sped_m)") + rsList.getDouble("sum(sped_f)"));
                enroll_count.add(rsList.getDouble("sum(grade1_m)") +
                                    rsList.getInt("sum(grade1_f)") +
                                    rsList.getInt("sum(grade2_m)") +
                                    rsList.getInt("sum(grade2_f)") +
                                    rsList.getInt("sum(grade3_m)") +
                                    rsList.getInt("sum(grade3_f)") +
                                    rsList.getInt("sum(grade4_m)") +
                                    rsList.getInt("sum(grade4_f)") +
                                    rsList.getInt("sum(grade5_m)") +
                                    rsList.getInt("sum(grade5_f)") +
                                    rsList.getInt("sum(kinder_m)") +
                                    rsList.getInt("sum(kinder_f)"));        
                
                objectList.add(new Elementary(rsList.getInt("school_id"),
                                 rsList.getString("school_name"),
                                 rsList.getString("region"),
                                 rsList.getString("province"),
                                 rsList.getString("municipality"),
                                 rsList.getString("division"),
                                 rsList.getString("district"),
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
        ArrayList<Double> enroll_count = new ArrayList<Double>();
        
        String query;
        String condition = "";
        
        if(!cond.isEmpty()){
            condition = "WHERE ";

            for(int i = 0; i < cond.size() - 1; i ++)
                condition = condition.concat(cond.get(i) + " AND ");

            condition = condition.concat(cond.get(cond.size() - 1));
        }
        
        query = "SELECT DISTINCT(school_id), school_name, region, province, municipality, division, district, academic_year, \n" +
                "sum(grade1_m) + sum(grade1_f) + \n" +
                "sum(grade2_m) + sum(grade2_f) + \n" +
                "sum(grade3_m) + sum(grade3_f) + \n" +
                "sum(grade4_m) + sum(grade4_f) + \n" +
                "sum(grade5_m) + sum(grade5_f) + \n" +
                "sum(kinder_m) + sum(kinder_f) as total\n" +
                "sum(sped_m), sum(sped_f)\n" +
                "FROM enrollment_data.es_kto12_enrollment " + condition + " GROUP BY school_id;";
        
        try {
            ResultSet rsList = MySQLConnector.executeQuery(query);
            while(rsList.next()) {
                enroll_count = new ArrayList<Double>();
                enroll_count.add(rsList.getDouble("sum(sped_m)") + rsList.getInt("sum(sped_f)"));
                enroll_count.add(rsList.getDouble("total"));        
                
                objectList.add(new Elementary(rsList.getInt("school_id"),
                                 rsList.getString("school_name"),
                                 rsList.getString("region"),
                                 rsList.getString("province"),
                                 rsList.getString("municipality"),
                                 rsList.getString("division"),
                                 rsList.getString("district"),
                                 rsList.getString("academic_year"),
                                 enroll_count));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Base Query - " + objectList.size() + " rows");
        return objectList;
    }
    
    public static ArrayList<HighSchool> getHighSchool(){
        ArrayList<HighSchool> objectList = new ArrayList<HighSchool>();
        ArrayList<Double> enroll_count = new ArrayList<Double>();
        
        try {
            ResultSet rsList = MySQLConnector.executeQuery("SELECT DISTINCT(school_id), school_name, region, province, municipality, division, academic_year,\n" +
                                                            "sum(grade7_m) + sum(grade7_f) + \n" +
                                                            "sum(grade8_m) + sum(grade8_f) + \n" +
                                                            "sum(grade9_m) + sum(grade9_f) + \n" +
                                                            "sum(grade10_m) + sum(grade10_f) + \n" +
                                                            "sum(grade11_m) + sum(grade11_f)+ \n" +
                                                            "sum(grade12_m) + sum(grade12_f) as total,\n" +
                                                            "sum(sped_m), sum(sped_f)\n" +
                                                            "FROM enrollment_data.hs_kto12_enrollment GROUP BY school_id;");
            while(rsList.next()) {
                enroll_count = new ArrayList<Double>();

                enroll_count.add(rsList.getDouble("sum(sped_m)") + rsList.getDouble("sum(sped_f)"));
                enroll_count.add(rsList.getDouble("total"));        
                
                objectList.add(new HighSchool(rsList.getInt("school_id"),
                                 rsList.getString("school_name"),
                                 rsList.getString("region"),
                                 rsList.getString("province"),
                                 rsList.getString("municipality"),
                                 rsList.getString("division"), 
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
        ArrayList<Double> enroll_count = new ArrayList<Double>();
        
        String query;
        String condition = "";
        
        if(!cond.isEmpty()){
            condition = "WHERE ";

            for(int i = 0; i < cond.size() - 1; i ++)
                condition = condition.concat(cond.get(i) + " AND ");

            condition = condition.concat(cond.get(cond.size() - 1));
        }
        
        query = "SELECT DISTINCT(school_id), school_name, region, province, municipality, division, \n" +
                "sum(grade7_m) + sum(grade7_f) + \n" +
                "sum(grade8_m) + sum(grade8_f) + \n" +
                "sum(grade9_m) + sum(grade9_f) + \n" +
                "sum(grade10_m) + sum(grade10_f) + \n" +
                "sum(grade11_m) + sum(grade11_f)+ \n" +
                "sum(grade12_m) + sum(grade12_f) as total,\n" +
                "sum(sped_m), sum(sped_f)\n" +
                "FROM enrollment_data.hs_kto12_enrollment " + condition + " GROUP BY school_id;";
        
        try {
            ResultSet rsList = MySQLConnector.executeQuery(query);
            while(rsList.next()) {
                enroll_count = new ArrayList<Double>();
                enroll_count.add(rsList.getDouble("sum(sped_m)") + rsList.getDouble("sum(sped_f)"));
                enroll_count.add(rsList.getDouble("total"));           
                
                objectList.add(new HighSchool(rsList.getInt("school_id"),
                                 rsList.getString("school_name"),
                                 rsList.getString("region"),
                                 rsList.getString("province"),
                                 rsList.getString("municipality"),
                                 rsList.getString("division"),enroll_count));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Base Query - " + objectList.size() + " rows");
        return objectList;
    }
}
