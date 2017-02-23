package model;

import model.*;
import java.util.ArrayList;

public class HighSchool implements Level{
    private int school_id;
    private String school_name;
    private String region;
    private String province;
    private String municipality;
    private String division;
    private String academic_year;
    private ArrayList<Double> enroll_count;

    public HighSchool(int school_id, String school_name, String region, String province, String municipality, String division, String academic_year, ArrayList<Double> enroll_count) {
        this.school_id = school_id;
        this.school_name = school_name;
        this.region = region;
        this.province = province;
        this.municipality = municipality;
        this.division = division;
        this.academic_year = academic_year;
        this.enroll_count = enroll_count;
    }

    public HighSchool(int school_id, String school_name, String region, String province, String municipality, String division, ArrayList<Double> enroll_count) {
        this.school_id = school_id;
        this.school_name = school_name;
        this.region = region;
        this.province = province;
        this.municipality = municipality;
        this.division = division;
        this.enroll_count = enroll_count;
    }
    
    public HighSchool(String region, String province, String municipality, String division, String academic_year, ArrayList<Double> enroll_count) {
        this.region = region;
        this.academic_year = academic_year;
        this.province = province;
        this.municipality = municipality;
        this.division = division;
        this.enroll_count = enroll_count;
    }

    public HighSchool(int school_id, String school_name, String region, String province, String municipality, String division, Double enroll_count) {
        this.school_id = school_id;
        this.school_name = school_name;
        this.region = region;
        this.province = province;
        this.municipality = municipality;
        this.division = division;
        this.enroll_count = new ArrayList<Double>();
        this.enroll_count.add(enroll_count);
    }

    public HighSchool(int school_id, String school_name, String academic_year, ArrayList<Double> enroll_count) {
        this.school_id = school_id;
        this.school_name = school_name;
        this.academic_year = academic_year;
        this.enroll_count = enroll_count;
    }

    public int getSchool_id() {
        return school_id;
    }

    public void setSchool_id(int school_id) {
        this.school_id = school_id;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getAcademic_year() {
        return academic_year;
    }

    public void setAcademic_year(String academic_year) {
        this.academic_year = academic_year;
    }

    public ArrayList<Double> getEnroll_count() {
        return enroll_count;
    }

    public void setEnroll_count(ArrayList<Double> enroll_count) {
        this.enroll_count = enroll_count;
    }
}
