package model;

import db_connection.MySQLConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLModel {
    public static void addElementary(Elementary elementary, boolean isKto12){
        try {
            Connection conn = MySQLConnector.getConnection();
            PreparedStatement addElementary = null;
            String query;
            
            if(!isKto12)
                query = "INSERT INTO es_enrollment VALUES(?, ?, ?, ?, ?, ?, ?, ?, " +
                    "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            else
                query = "INSERT INTO es_kto12_enrollment VALUES(?, ?, ?, ?, ?, ?, ?, ?, " +
                    "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            
            conn.setAutoCommit(false);
            addElementary = conn.prepareStatement(query);
            addElementary.setDouble(1, elementary.getSchool_id());
            addElementary.setString(2, elementary.getSchool_name());
            addElementary.setString(3, elementary.getRegion());
            addElementary.setString(4, elementary.getProvince());
            addElementary.setString(5, elementary.getMunicipality());
            addElementary.setString(6, elementary.getDivision());
            addElementary.setString(7, elementary.getDistrict());
            addElementary.setString(8, elementary.getAcademic_year());
            addElementary.setDouble(9, elementary.getEnroll_count().get(0));
            addElementary.setDouble(10, elementary.getEnroll_count().get(1));
            addElementary.setDouble(11, elementary.getEnroll_count().get(3));
            addElementary.setDouble(12, elementary.getEnroll_count().get(4));
            addElementary.setDouble(13, elementary.getEnroll_count().get(6));
            addElementary.setDouble(14, elementary.getEnroll_count().get(7));
            addElementary.setDouble(15, elementary.getEnroll_count().get(9));
            addElementary.setDouble(16, elementary.getEnroll_count().get(10));
            addElementary.setDouble(17, elementary.getEnroll_count().get(12));
            addElementary.setDouble(18, elementary.getEnroll_count().get(13));
            addElementary.setDouble(19, elementary.getEnroll_count().get(15));
            addElementary.setDouble(20, elementary.getEnroll_count().get(16));
            addElementary.setDouble(21, elementary.getEnroll_count().get(18));
            addElementary.setDouble(22, elementary.getEnroll_count().get(19));
            addElementary.setDouble(23, elementary.getEnroll_count().get(21));
            addElementary.setDouble(24, elementary.getEnroll_count().get(22));
            
            if(!isKto12)
                addElementary.setDouble(25, elementary.getEnroll_count().get(23));
            else{
                addElementary.setDouble(25, elementary.getEnroll_count().get(24));
                addElementary.setDouble(26, elementary.getEnroll_count().get(25));
                addElementary.setDouble(27, elementary.getEnroll_count().get(26));
            }
            
            addElementary.execute();
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLModel.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    public static void addHighschool(HighSchool highschool, boolean isKto12){
        try {
            Connection conn = MySQLConnector.getConnection();
            PreparedStatement addHighSchool = null;
            String query;
            
            if(!isKto12)
                query = "INSERT INTO hs_enrollment VALUES(?, ?, ?, ?, ?, ?, ?, " +
                            "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            else
                query = "INSERT INTO hs_kto12_enrollment VALUES(?, ?, ?, ?, ?, ?, ?, " +
                            "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            
            conn.setAutoCommit(false);
            addHighSchool = conn.prepareStatement(query);
            addHighSchool.setDouble(1, highschool.getSchool_id());
            addHighSchool.setString(2, highschool.getSchool_name());
            addHighSchool.setString(3, highschool.getRegion());
            addHighSchool.setString(4, highschool.getProvince());
            addHighSchool.setString(5, highschool.getMunicipality());
            addHighSchool.setString(6, highschool.getDivision());
            addHighSchool.setString(7, highschool.getAcademic_year());
            addHighSchool.setDouble(8, highschool.getEnroll_count().get(0));
            addHighSchool.setDouble(9, highschool.getEnroll_count().get(1));
            addHighSchool.setDouble(10, highschool.getEnroll_count().get(3));
            addHighSchool.setDouble(11, highschool.getEnroll_count().get(4));
            addHighSchool.setDouble(12, highschool.getEnroll_count().get(6));
            addHighSchool.setDouble(13, highschool.getEnroll_count().get(7));
            addHighSchool.setDouble(14, highschool.getEnroll_count().get(9));
            addHighSchool.setDouble(15, highschool.getEnroll_count().get(10));
            addHighSchool.setDouble(16, highschool.getEnroll_count().get(12));
            addHighSchool.setDouble(17, highschool.getEnroll_count().get(13));
            
            if(!isKto12)
                addHighSchool.setDouble(18, highschool.getEnroll_count().get(14));
            else{
                addHighSchool.setDouble(18, highschool.getEnroll_count().get(15));
                addHighSchool.setDouble(19, highschool.getEnroll_count().get(16));
                addHighSchool.setDouble(20, highschool.getEnroll_count().get(18));
                addHighSchool.setDouble(21, highschool.getEnroll_count().get(19));
                addHighSchool.setDouble(22, highschool.getEnroll_count().get(21));
                addHighSchool.setDouble(23, highschool.getEnroll_count().get(22));
                addHighSchool.setDouble(24, highschool.getEnroll_count().get(23));
            }
           
            addHighSchool.execute();
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
