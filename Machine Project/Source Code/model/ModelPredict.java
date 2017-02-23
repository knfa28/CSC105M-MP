package model;

import db_connection.MySQLConnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.NeuralNet;

public class ModelPredict {
    public static ArrayList<Elementary> get1stGrade(){
        ArrayList<Elementary> objectList = new ArrayList<Elementary>();
        ArrayList<Double[]> input_output = new ArrayList<Double[]>();
        
        try {
            ResultSet rsList = MySQLConnector.executeQuery("SELECT DISTINCT(school_id),school_name,region,province,municipality,division,district from es_enrollment UNION\n" +
                                                            "SELECT DISTINCT(school_id),school_name,region,province,municipality,division,district from es_kto12_enrollment ORDER BY school_id");
            while(rsList.next()) {
                objectList.add(new Elementary(rsList.getInt("school_id"),
                                          rsList.getString("school_name"),
                                          rsList.getString("region"),
                                          rsList.getString("province"),
                                          rsList.getString("municipality"),
                                          rsList.getString("division"),
                                          rsList.getString("district")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelPredict.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(int i = 0; i < objectList.size(); i++){
            try {
                ResultSet rsList = MySQLConnector.executeQuery("SELECT school_id, kinder_m, kinder_f, grade1_m, grade1_f FROM enrollment_data.es_kto12_enrollment WHERE school_id = " + objectList.get(i).getSchool_id() + " UNION \n" +
"SELECT school_id, kinder_m, kinder_f, grade1_m, grade1_f FROM enrollment_data.es_enrollment WHERE school_id = " + objectList.get(i).getSchool_id() + " order by school_id;");
            
                while(rsList.next()) {
                     Double[] temp = {rsList.getDouble("kinder_m") + rsList.getDouble("kinder_f"), rsList.getDouble("grade1_m") + rsList.getDouble("grade1_f")};
                     input_output.add(temp);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ModelPredict.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            NeuralNet nn = new NeuralNet(input_output);
            objectList.get(i).setEnroll_count(nn.predict());
            System.out.println(objectList.get(i).getEnroll_count().get(0) + " , " +
            objectList.get(i).getEnroll_count().get(1));
        }
        
        System.out.println("Base Query - " + objectList.size() + " rows");
        return objectList;
    } 
    
     public static ArrayList<Elementary> drillDown1stGrade(ArrayList<String> cond){
        ArrayList<Elementary> objectList = new ArrayList<Elementary>();
        ArrayList<Double[]> input_output = new ArrayList<Double[]>();
        
        String query;
        String condition = "";
        
        if(!cond.isEmpty()){
            condition = " ";

            for(int i = 0; i < cond.size() - 1; i ++)
                condition = condition.concat(cond.get(i) + " AND ");

            condition = condition.concat(cond.get(cond.size() - 1));
        }
        
        query = "SELECT DISTINCT(school_id),school_name,region,province,municipality,division,district from es_enrollment WHERE " + condition + " UNION\n" +
                "SELECT DISTINCT(school_id),school_name,region,province,municipality,division,district from es_kto12_enrollment WHERE " + condition + " ORDER BY school_id";
        
        try {
            ResultSet rsList = MySQLConnector.executeQuery(query);
            while(rsList.next()) {
                objectList.add(new Elementary(rsList.getInt("school_id"),
                                          rsList.getString("school_name"),
                                          rsList.getString("region"),
                                          rsList.getString("province"),
                                          rsList.getString("municipality"),
                                          rsList.getString("division"),
                                          rsList.getString("district")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelPredict.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(int i = 0; i < objectList.size(); i++){
            try {
                ResultSet rsList = MySQLConnector.executeQuery("SELECT school_id, kinder_m, kinder_f, grade1_m, grade1_f FROM enrollment_data.es_kto12_enrollment WHERE school_id = " + objectList.get(i).getSchool_id() + " AND " + condition + " UNION \n" +
"SELECT school_id, kinder_m, kinder_f, grade1_m, grade1_f FROM enrollment_data.es_enrollment WHERE school_id = " + objectList.get(i).getSchool_id() + " AND " + condition + " order by school_id;");
            
                while(rsList.next()) {
                     Double[] temp = {rsList.getDouble("kinder_m") + rsList.getDouble("kinder_f"), rsList.getDouble("grade1_m") + rsList.getDouble("grade1_f")};
                     input_output.add(temp);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ModelPredict.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            System.out.println(input_output.get(0)[0]);
            NeuralNet nn = new NeuralNet(input_output);
            objectList.get(i).setEnroll_count(nn.predict());
        }
        
        System.out.println("Base Query - " + objectList.size() + " rows");
        return objectList;
    } 
}
