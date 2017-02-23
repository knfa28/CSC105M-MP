package controller;

import java.util.ArrayList;
import model.ModelBase;
import model.ModelLocation;
import model.ModelPredict;
import model.ModelSped;
import model.ModelTrends;
import view.AppView;

public class Controller {
    private AppView appView;
    private static Controller firstInstance = null;
    
    private Controller() {
        appView = new AppView(this);
        updateLocationDetails();
    }
    
    public static Controller getInstance(){
        if(firstInstance == null)
            firstInstance = new Controller();       
        
        return firstInstance;
    }
    
    public void updateLocationDetails(){
        appView.updateLocationDetails(ModelLocation.getRegion(),
                                      ModelLocation.getProvince(),
                                      ModelLocation.getMunicipality(),
                                      ModelLocation.getDivision(),
                                      ModelLocation.getDistrict());
    }
    
    public void updateBaseTables(){
        appView.updateBaseTables(ModelBase.getElementary(),
                                 ModelBase.getHighSchool(),
                                 ModelBase.getEKto12(),
                                 ModelBase.getHKto12());
    }
    
    public void sliceBaseTables(ArrayList<String> cond){
        appView.updateBaseTables(ModelBase.drillDownElementary(cond),
                                 ModelBase.drillDownHighSchool(cond),
                                 ModelBase.drillDownEKto12(cond),
                                 ModelBase.drillDownHKto12(cond));
    }
    
    public void updatePredictTables(){
        appView.updatePredictTables(ModelPredict.get1stGrade());
    }
    
    public void slicePredictTables(ArrayList<String> cond){
        appView.updatePredictTables(ModelPredict.drillDown1stGrade(cond));
    }
    
    public void updateTrendsTables(){
        appView.updateTrendsTables(ModelTrends.getElementary(),
                                 ModelTrends.getHighSchool(),
                                 ModelTrends.getEKto12(),
                                 ModelTrends.getHKto12());
    }
    
    public void sliceTrendsTables(ArrayList<String> cond){
        appView.updateTrendsTables(ModelTrends.drillDownElementary(cond),
                                 ModelTrends.drillDownHighSchool(cond),
                                 ModelTrends.drillDownEKto12(cond),
                                 ModelTrends.drillDownHKto12(cond));
    }
    
    public void showLocationTrend(String level, ArrayList<String> cond)
    {
        
    }
    
    public void updateSpedTables(){
        appView.updateSpedTables(ModelSped.getElementary(),
                                 ModelSped.getHighSchool());
    } 
    
    public void sliceSpedTables(ArrayList<String> cond){
        appView.updateSpedTables(ModelSped.drillDownElementary(cond),
                                 ModelSped.drillDownHighSchool(cond));
    } 
}
