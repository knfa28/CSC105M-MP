package view;

import controller.*;
import java.util.ArrayList;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import model.HighSchool;
import model.Elementary;


public class AppView extends javax.swing.JFrame {
    private Controller control;
    private DefaultTableModel esBaseModel,
                              hsBaseModel,
                              esKBaseModel,
                              hsKBaseModel;
    private DefaultTableModel esPredictModel,
                              hsPredictModel;
    private DefaultTableModel esTrendsModel,
                              hsTrendsModel,
                              esKTrendsModel,
                              hsKTrendsModel;
    private DefaultTableModel esKSpedModel,
                              hsKSpedModel;
    
    public AppView(Controller control) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {}
        this.control = control;
        initComponents();
        
        esBaseTable.setAutoCreateRowSorter(true);
        esBaseModel = (DefaultTableModel) esBaseTable.getModel();
        hsBaseTable.setAutoCreateRowSorter(true);
        hsBaseModel = (DefaultTableModel) hsBaseTable.getModel();
        esKBaseTable.setAutoCreateRowSorter(true);
        esKBaseModel = (DefaultTableModel) esKBaseTable.getModel();
        hsKBaseTable.setAutoCreateRowSorter(true);
        hsKBaseModel = (DefaultTableModel) hsKBaseTable.getModel();
        
        esPredictTable.setAutoCreateRowSorter(true);
        esPredictModel = (DefaultTableModel) esPredictTable.getModel();
        hsPredictTable.setAutoCreateRowSorter(true);
        hsPredictModel = (DefaultTableModel) hsPredictTable.getModel();
        
        esTrendsTable.setAutoCreateRowSorter(true);
        esTrendsModel = (DefaultTableModel) esTrendsTable.getModel();
        hsTrendsTable.setAutoCreateRowSorter(true);
        hsTrendsModel = (DefaultTableModel) hsTrendsTable.getModel();
        esKTrendsTable.setAutoCreateRowSorter(true);
        esKTrendsModel = (DefaultTableModel) esKTrendsTable.getModel();
        hsKTrendsTable.setAutoCreateRowSorter(true);
        hsKTrendsModel = (DefaultTableModel) hsKTrendsTable.getModel();
        
        esKSpedTable.setAutoCreateRowSorter(true);
        esKSpedModel = (DefaultTableModel) esKSpedTable.getModel();
        hsKSpedTable.setAutoCreateRowSorter(true);
        hsKSpedModel = (DefaultTableModel) hsKSpedTable.getModel();
             
        this.setResizable(false);
        setLocationRelativeTo(null);  
        setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
    public void updateLocationDetails(ArrayList<String> region,
                                        ArrayList<String> province,
                                        ArrayList<String> municipality,
                                        ArrayList<String> division,
                                        ArrayList<String> district){
        
        for(int i = 0; i < region.size(); i++){
            regCombo.addItem(region.get(i));
            regCombo1.addItem(region.get(i));
            regCombo2.addItem(region.get(i));
            regCombo3.addItem(region.get(i));
        }
        
        for(int i = 0; i < province.size(); i++){
            provCombo.addItem(province.get(i));
            provCombo1.addItem(province.get(i));
            provCombo2.addItem(province.get(i));
            provCombo3.addItem(province.get(i));
        }
        
        for(int i = 0; i < municipality.size(); i++){
            munCombo.addItem(municipality.get(i));
            munCombo1.addItem(municipality.get(i));
            munCombo2.addItem(municipality.get(i));
            munCombo3.addItem(municipality.get(i));
        }
        
        for(int i = 0; i < division.size(); i++){
            divCombo.addItem(division.get(i));
            divCombo1.addItem(division.get(i));
            divCombo2.addItem(division.get(i));
            divCombo3.addItem(division.get(i));
        }
        
        for(int i = 0; i < district.size(); i++){
            disCombo.addItem(district.get(i));
            disCombo1.addItem(district.get(i));
            disCombo2.addItem(district.get(i));
            disCombo3.addItem(district.get(i));
        }
    }
    
    public void updateBaseTables(ArrayList<Elementary> es,
                                ArrayList<HighSchool> hs,
                                ArrayList<Elementary> esk,
                                ArrayList<HighSchool> hsk){
        Object temp[];
        
        esBaseModel.getDataVector().removeAllElements();
        esBaseModel.fireTableDataChanged();
        
        for(int i = 0; i < es.size(); i++) {
            temp = new Object[]{es.get(i).getSchool_id(),
                                es.get(i).getSchool_name(),
                                es.get(i).getAcademic_year(),
                                es.get(i).getEnroll_count().get(0) + es.get(i).getEnroll_count().get(1),
                                es.get(i).getEnroll_count().get(2) + es.get(i).getEnroll_count().get(3),
                                es.get(i).getEnroll_count().get(4) + es.get(i).getEnroll_count().get(5),
                                es.get(i).getEnroll_count().get(6) + es.get(i).getEnroll_count().get(7),
                                es.get(i).getEnroll_count().get(8) + es.get(i).getEnroll_count().get(9),
                                es.get(i).getEnroll_count().get(10) + es.get(i).getEnroll_count().get(11),
                                es.get(i).getEnroll_count().get(12) + es.get(i).getEnroll_count().get(13)};
            
            esBaseModel.addRow(temp);
        }
        
        hsBaseModel.getDataVector().removeAllElements();
        hsBaseModel.fireTableDataChanged();
        
        for(int i = 0; i < hs.size(); i++) {
            temp = new Object[]{hs.get(i).getSchool_id(),
                                hs.get(i).getSchool_name(),
                                hs.get(i).getAcademic_year(),
                                hs.get(i).getEnroll_count().get(0) + hs.get(i).getEnroll_count().get(1),
                                hs.get(i).getEnroll_count().get(2) + hs.get(i).getEnroll_count().get(3),
                                hs.get(i).getEnroll_count().get(4) + hs.get(i).getEnroll_count().get(5),
                                hs.get(i).getEnroll_count().get(6) + hs.get(i).getEnroll_count().get(7)};
            
            hsBaseModel.addRow(temp);
        }
        
        esKBaseModel.getDataVector().removeAllElements();
        esKBaseModel.fireTableDataChanged();
        
        for(int i = 0; i < esk.size(); i++) {
            temp = new Object[]{esk.get(i).getSchool_id(),
                                esk.get(i).getSchool_name(),
                                esk.get(i).getAcademic_year(),
                                esk.get(i).getEnroll_count().get(0) + esk.get(i).getEnroll_count().get(1),
                                esk.get(i).getEnroll_count().get(2) + esk.get(i).getEnroll_count().get(3),
                                esk.get(i).getEnroll_count().get(4) + esk.get(i).getEnroll_count().get(5),
                                esk.get(i).getEnroll_count().get(6) + esk.get(i).getEnroll_count().get(7),
                                esk.get(i).getEnroll_count().get(8) + esk.get(i).getEnroll_count().get(9),
                                esk.get(i).getEnroll_count().get(10) + esk.get(i).getEnroll_count().get(11),
                                esk.get(i).getEnroll_count().get(12) + esk.get(i).getEnroll_count().get(13),
                                esk.get(i).getEnroll_count().get(14) + esk.get(i).getEnroll_count().get(15)};
            
            esKBaseModel.addRow(temp);
        }
        
        hsKBaseModel.getDataVector().removeAllElements();
        hsKBaseModel.fireTableDataChanged();
        
        for(int i = 0; i < hsk.size(); i++) {
            temp = new Object[]{hsk.get(i).getSchool_id(),
                                hsk.get(i).getSchool_name(),
                                hsk.get(i).getAcademic_year(),
                                hsk.get(i).getEnroll_count().get(0) + hsk.get(i).getEnroll_count().get(1),
                                hsk.get(i).getEnroll_count().get(2) + hsk.get(i).getEnroll_count().get(3),
                                hsk.get(i).getEnroll_count().get(4) + hsk.get(i).getEnroll_count().get(5),
                                hsk.get(i).getEnroll_count().get(6) + hsk.get(i).getEnroll_count().get(7),
                                hsk.get(i).getEnroll_count().get(8) + hsk.get(i).getEnroll_count().get(9),
                                hsk.get(i).getEnroll_count().get(10) + hsk.get(i).getEnroll_count().get(11),
                                hsk.get(i).getEnroll_count().get(12) + hsk.get(i).getEnroll_count().get(13)};
            
            hsKBaseModel.addRow(temp);
        }
    }
    
    public void updatePredictTables(ArrayList<Elementary> es){
        Object temp[];
        
        esPredictModel.getDataVector().removeAllElements();
        esPredictModel.fireTableDataChanged();
        
        for(int i = 0; i < es.size(); i++) {
            temp = new Object[]{es.get(i).getSchool_id(),
                                es.get(i).getSchool_name(),
                                es.get(i).getEnroll_count().get(0),
                                es.get(i).getEnroll_count().get(1)};
            
            esPredictModel.addRow(temp);
        }
    }
    
    public void updateTrendsTables(ArrayList<Elementary> es,
                                ArrayList<HighSchool> hs,
                                ArrayList<Elementary> esk,
                                ArrayList<HighSchool> hsk){
        Object temp[];
        
        esTrendsModel.getDataVector().removeAllElements();
        esTrendsModel.fireTableDataChanged();
        
        for(int i = 0; i < es.size(); i++) {
            temp = new Object[]{es.get(i).getSchool_id(),
                                es.get(i).getSchool_name(),
                                es.get(i).getRegion(),
                                es.get(i).getProvince(),
                                es.get(i).getMunicipality(),
                                es.get(i).getDivision(),
                                es.get(i).getDistrict(),
                                es.get(i).getEnroll_count().get(0)};
            
            esTrendsModel.addRow(temp);
        }
        
        hsTrendsModel.getDataVector().removeAllElements();
        hsTrendsModel.fireTableDataChanged();
        
        for(int i = 0; i < hs.size(); i++) {
            temp = new Object[]{hs.get(i).getSchool_id(),
                                hs.get(i).getSchool_name(),
                                hs.get(i).getRegion(),
                                hs.get(i).getProvince(),
                                hs.get(i).getMunicipality(),
                                hs.get(i).getDivision(),
                                hs.get(i).getEnroll_count().get(0)};
            
            hsTrendsModel.addRow(temp);
        }
        
        esKTrendsModel.getDataVector().removeAllElements();
        esKTrendsModel.fireTableDataChanged();
        
        for(int i = 0; i < esk.size(); i++) {
            temp = new Object[]{esk.get(i).getSchool_id(),
                                esk.get(i).getSchool_name(),
                                esk.get(i).getRegion(),
                                esk.get(i).getProvince(),
                                esk.get(i).getMunicipality(),
                                esk.get(i).getDivision(),
                                esk.get(i).getDistrict(),
                                esk.get(i).getEnroll_count().get(0)};
            
            esKTrendsModel.addRow(temp);
        }
        
        hsKTrendsModel.getDataVector().removeAllElements();
        hsKTrendsModel.fireTableDataChanged();
        
        for(int i = 0; i < hsk.size(); i++) {
            temp = new Object[]{hsk.get(i).getSchool_id(),
                                hsk.get(i).getSchool_name(),
                                hsk.get(i).getRegion(),
                                hsk.get(i).getProvince(),
                                hsk.get(i).getMunicipality(),
                                hsk.get(i).getDivision(),
                                hsk.get(i).getEnroll_count().get(0)};

            hsKTrendsModel.addRow(temp);
        }
    }
    
    public void displayHLineChart(ArrayList<HighSchool> hs)
    {
    	
    }
    
    public void updateSpedTables(ArrayList<Elementary> es, ArrayList<HighSchool> hs){
        Object temp[];
        
        esKSpedModel.getDataVector().removeAllElements();
        esKSpedModel.fireTableDataChanged();
        
        for(int i = 0; i < es.size(); i++) {
            temp = new Object[]{
                                es.get(i).getRegion(),
                                es.get(i).getProvince(),
                                es.get(i).getMunicipality(),
                                es.get(i).getDivision(),
                                es.get(i).getDistrict(),
                                es.get(i).getSchool_id(),
                                es.get(i).getSchool_name(),
                                es.get(i).getAcademic_year(),
                                es.get(i).getEnroll_count().get(0),
                                es.get(i).getEnroll_count().get(1),
                                (es.get(i).getEnroll_count().get(0) * 1.0/(es.get(i).getEnroll_count().get(0) + es.get(i).getEnroll_count().get(1)) * 100),
                                (es.get(i).getEnroll_count().get(1) * 1.0/(es.get(i).getEnroll_count().get(0) + es.get(i).getEnroll_count().get(1)) * 100)};
            
            esKSpedModel.addRow(temp);
        }
        
        hsKSpedModel.getDataVector().removeAllElements();
        hsKSpedModel.fireTableDataChanged();
        
        for(int i = 0; i < hs.size(); i++) {
            temp = new Object[]{
                                hs.get(i).getRegion(),
                                hs.get(i).getProvince(),
                                hs.get(i).getMunicipality(),
                                hs.get(i).getDivision(),
                                hs.get(i).getSchool_id(),
                                hs.get(i).getSchool_name(),
                                hs.get(i).getAcademic_year(),
                                hs.get(i).getEnroll_count().get(0),
                                hs.get(i).getEnroll_count().get(1),
                               (hs.get(i).getEnroll_count().get(0) * 1.0/(hs.get(i).getEnroll_count().get(0) + hs.get(i).getEnroll_count().get(1)) * 100.0),
                               (hs.get(i).getEnroll_count().get(1) * 1.0/(hs.get(i).getEnroll_count().get(0) + hs.get(i).getEnroll_count().get(1)) * 100.0)};

            hsKSpedModel.addRow(temp);
        }
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        mainPanel = new javax.swing.JTabbedPane();
        basePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        baseExecute = new javax.swing.JButton();
        locationCheck = new javax.swing.JCheckBox();
        provButton = new javax.swing.JRadioButton();
        regCombo = new javax.swing.JComboBox();
        munButton = new javax.swing.JRadioButton();
        divButton = new javax.swing.JRadioButton();
        munCombo = new javax.swing.JComboBox();
        regButton = new javax.swing.JRadioButton();
        baseTablePanel = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        esBaseTable = new javax.swing.JTable();
        jPanel27 = new javax.swing.JPanel();
        jScrollPane36 = new javax.swing.JScrollPane();
        hsBaseTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        esKBaseTable = new javax.swing.JTable();
        jPanel28 = new javax.swing.JPanel();
        jScrollPane37 = new javax.swing.JScrollPane();
        hsKBaseTable = new javax.swing.JTable();
        disCombo = new javax.swing.JComboBox();
        disButton = new javax.swing.JRadioButton();
        provCombo = new javax.swing.JComboBox();
        divCombo = new javax.swing.JComboBox();
        yearCheck = new javax.swing.JCheckBox();
        yearCombo = new javax.swing.JComboBox();
        predictPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        predictExecute = new javax.swing.JButton();
        locationCheck1 = new javax.swing.JCheckBox();
        provButton1 = new javax.swing.JRadioButton();
        regCombo1 = new javax.swing.JComboBox();
        munButton1 = new javax.swing.JRadioButton();
        divButton1 = new javax.swing.JRadioButton();
        munCombo1 = new javax.swing.JComboBox();
        regButton1 = new javax.swing.JRadioButton();
        baseTablePanel1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        esPredictTable = new javax.swing.JTable();
        jPanel29 = new javax.swing.JPanel();
        jScrollPane38 = new javax.swing.JScrollPane();
        hsPredictTable = new javax.swing.JTable();
        disCombo1 = new javax.swing.JComboBox();
        disButton1 = new javax.swing.JRadioButton();
        provCombo1 = new javax.swing.JComboBox();
        divCombo1 = new javax.swing.JComboBox();
        graphPrediction = new javax.swing.JButton();
        trendsPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        trendSchoolButton = new javax.swing.JButton();
        locationCheck2 = new javax.swing.JCheckBox();
        provButton2 = new javax.swing.JRadioButton();
        regCombo2 = new javax.swing.JComboBox();
        munButton2 = new javax.swing.JRadioButton();
        divButton2 = new javax.swing.JRadioButton();
        munCombo2 = new javax.swing.JComboBox();
        regButton2 = new javax.swing.JRadioButton();
        trendsTablePanel = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        esTrendsTable = new javax.swing.JTable();
        jPanel30 = new javax.swing.JPanel();
        jScrollPane39 = new javax.swing.JScrollPane();
        hsTrendsTable = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        esKTrendsTable = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        hsKTrendsTable = new javax.swing.JTable();
        disCombo2 = new javax.swing.JComboBox();
        disButton2 = new javax.swing.JRadioButton();
        provCombo2 = new javax.swing.JComboBox();
        divCombo2 = new javax.swing.JComboBox();
        trendLocationButton = new javax.swing.JButton();
        levelCombo = new javax.swing.JComboBox();
        graphTrends = new javax.swing.JButton();
        basePanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        spedExecute = new javax.swing.JButton();
        locationCheck3 = new javax.swing.JCheckBox();
        provButton3 = new javax.swing.JRadioButton();
        regCombo3 = new javax.swing.JComboBox();
        munButton3 = new javax.swing.JRadioButton();
        divButton3 = new javax.swing.JRadioButton();
        munCombo3 = new javax.swing.JComboBox();
        regButton3 = new javax.swing.JRadioButton();
        baseTablePanel2 = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane17 = new javax.swing.JScrollPane();
        esKSpedTable = new javax.swing.JTable();
        jPanel32 = new javax.swing.JPanel();
        jScrollPane41 = new javax.swing.JScrollPane();
        hsKSpedTable = new javax.swing.JTable();
        disCombo3 = new javax.swing.JComboBox();
        disButton3 = new javax.swing.JRadioButton();
        provCombo3 = new javax.swing.JComboBox();
        divCombo3 = new javax.swing.JComboBox();
        graphSPED = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Original Queries");

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel1.setText("Enrollment data of public schools per grade level");

        baseExecute.setText("Execute");
        baseExecute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                baseExecuteActionPerformed(evt);
            }
        });

        locationCheck.setText("Location based");
        locationCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locationCheckActionPerformed(evt);
            }
        });

        provButton.setText("Province");
        provButton.setEnabled(false);
        provButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                provButtonActionPerformed(evt);
            }
        });

        regCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { }));
        regCombo.setEnabled(false);

        munButton.setText("Municipality");
        munButton.setEnabled(false);
        munButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                munButtonActionPerformed(evt);
            }
        });

        divButton.setText("Division");
        divButton.setEnabled(false);
        divButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                divButtonActionPerformed(evt);
            }
        });

        munCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { }));
        munCombo.setEnabled(false);

        regButton.setText("Region");
        regButton.setEnabled(false);
        regButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regButtonActionPerformed(evt);
            }
        });

        esBaseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "school_id", "school_name", "academic_year", "kinder", "grade_1", "grade_2", "grade_3", "grade_4", "grade_5", "grade_6"
            }){
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return false;
                }}
            );
            jScrollPane10.setViewportView(esBaseTable);

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 770, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE))
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 374, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE))
            );

            baseTablePanel.addTab("Elementary", jPanel1);

            hsBaseTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null}
                },
                new String [] {
                    "school_id", "school_name", "academic_year", "1st_year", "2nd_year", "3rd_year", "4th_year"
                }){
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return false;
                    }}
                );
                jScrollPane36.setViewportView(hsBaseTable);

                javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
                jPanel27.setLayout(jPanel27Layout);
                jPanel27Layout.setHorizontalGroup(
                    jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGap(0, 770, Short.MAX_VALUE)
                    .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane36, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE))
                );
                jPanel27Layout.setVerticalGroup(
                    jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGap(0, 374, Short.MAX_VALUE)
                    .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane36, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE))
                );

                baseTablePanel.addTab("High School", jPanel27);

                esKBaseTable.setModel(new javax.swing.table.DefaultTableModel(
                    new Object [][] {
                        {null, null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null, null}
                    },
                    new String [] {
                        "school_id", "school_name", "academic_year", "kinder", "grade_1", "grade_2", "grade_3", "grade_4", "grade_5", "grade_6", "sped"
                    }){
                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                            return false;
                        }}
                    );
                    jScrollPane11.setViewportView(esKBaseTable);

                    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
                    jPanel2.setLayout(jPanel2Layout);
                    jPanel2Layout.setHorizontalGroup(
                        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 770, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE))
                    );
                    jPanel2Layout.setVerticalGroup(
                        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 374, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE))
                    );

                    baseTablePanel.addTab("Elementary Kto12", jPanel2);

                    hsKBaseTable.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                            {null, null, null, null, null, null, null, null, null, null},
                            {null, null, null, null, null, null, null, null, null, null},
                            {null, null, null, null, null, null, null, null, null, null},
                            {null, null, null, null, null, null, null, null, null, null}
                        },
                        new String [] {
                            "school_id", "school_name", "academic_year", "grade_7", "grade_8", "grade_9", "grade_10", "grade_11", "grade_12", "sped"
                        }){
                            public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return false;
                            }}
                        );
                        jScrollPane37.setViewportView(hsKBaseTable);

                        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
                        jPanel28.setLayout(jPanel28Layout);
                        jPanel28Layout.setHorizontalGroup(
                            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGap(0, 770, Short.MAX_VALUE)
                            .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane37, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE))
                        );
                        jPanel28Layout.setVerticalGroup(
                            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGap(0, 374, Short.MAX_VALUE)
                            .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane37, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE))
                        );

                        baseTablePanel.addTab("High School Kto12", jPanel28);

                        disCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { }));
                        disCombo.setEnabled(false);

                        disButton.setText("District");
                        disButton.setEnabled(false);
                        disButton.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                disButtonActionPerformed(evt);
                            }
                        });

                        provCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { }));
                        provCombo.setEnabled(false);

                        divCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { }));
                        divCombo.setEnabled(false);

                        yearCheck.setText("School year");
                        yearCheck.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                yearCheckActionPerformed(evt);
                            }
                        });

                        yearCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"2011 - 2012", "2012 - 2013", "2013 - 2014", "2014 - 2015", "2015 - 2016" }));
                        yearCombo.setEnabled(false);

                        javax.swing.GroupLayout basePanelLayout = new javax.swing.GroupLayout(basePanel);
                        basePanel.setLayout(basePanelLayout);
                        basePanelLayout.setHorizontalGroup(
                            basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(baseTablePanel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(basePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(basePanelLayout.createSequentialGroup()
                                        .addGroup(basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jSeparator1))
                                            .addGroup(basePanelLayout.createSequentialGroup()
                                                .addComponent(yearCheck)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(locationCheck)
                                                .addGap(384, 384, 384)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(baseExecute)
                                        .addGap(14, 14, 14))
                                    .addGroup(basePanelLayout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(yearCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(provButton)
                                            .addComponent(regButton))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(provCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(regCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(divButton)
                                            .addComponent(munButton))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(divCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(munCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(disButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(disCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap())))
                        );
                        basePanelLayout.setVerticalGroup(
                            basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, basePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(baseExecute))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(locationCheck)
                                    .addComponent(yearCheck))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(basePanelLayout.createSequentialGroup()
                                            .addGroup(basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(regButton)
                                                .addComponent(yearCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(provButton))
                                        .addGroup(basePanelLayout.createSequentialGroup()
                                            .addGroup(basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(munButton)
                                                .addComponent(regCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(divButton)
                                                .addComponent(provCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(basePanelLayout.createSequentialGroup()
                                        .addGroup(basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(disButton)
                                            .addComponent(disCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(munCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(divCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(baseTablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                                .addContainerGap())
                        );

                        mainPanel.addTab("Home", basePanel);

                        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
                        jLabel2.setText("Expected number of incoming 1st grade elementary and 1st year high school students");

                        predictExecute.setText("Execute");
                        predictExecute.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                predictExecuteActionPerformed(evt);
                            }
                        });

                        locationCheck1.setText("Location based");
                        locationCheck1.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                locationCheck1ActionPerformed(evt);
                            }
                        });

                        provButton1.setText("Province");
                        provButton1.setEnabled(false);
                        provButton1.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                provButton1ActionPerformed(evt);
                            }
                        });

                        regCombo1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { }));
                        regCombo1.setEnabled(false);

                        munButton1.setText("Municipality");
                        munButton1.setEnabled(false);
                        munButton1.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                munButton1ActionPerformed(evt);
                            }
                        });

                        divButton1.setText("Division");
                        divButton1.setEnabled(false);
                        divButton1.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                divButton1ActionPerformed(evt);
                            }
                        });

                        munCombo1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { }));
                        munCombo1.setEnabled(false);

                        regButton1.setText("Region");
                        regButton1.setEnabled(false);
                        regButton1.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                regButton1ActionPerformed(evt);
                            }
                        });

                        esPredictTable.setModel(new javax.swing.table.DefaultTableModel(
                            new Object [][] {
                                {null, null, null},
                                {null, null, null},
                                {null, null, null},
                                {null, null, null}
                            },
                            new String [] {
                                "school_id", "school_name", "predicted 1st grade enrollees for SY 2016-2017"
                            }){
                                public boolean isCellEditable(int rowIndex, int columnIndex) {
                                    return false;
                                }}
                            );
                            jScrollPane12.setViewportView(esPredictTable);

                            javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
                            jPanel3.setLayout(jPanel3Layout);
                            jPanel3Layout.setHorizontalGroup(
                                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGap(0, 770, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE))
                            );
                            jPanel3Layout.setVerticalGroup(
                                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGap(0, 371, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE))
                            );

                            baseTablePanel1.addTab("Elementary", jPanel3);

                            hsPredictTable.setModel(new javax.swing.table.DefaultTableModel(
                                new Object [][] {
                                    {null, null, null},
                                    {null, null, null},
                                    {null, null, null},
                                    {null, null, null}
                                },
                                new String [] {
                                    "school_id", "school_name", "predicted 1st year enrollees for SY 2016-2017"
                                }){
                                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                                        return false;
                                    }}
                                );
                                jScrollPane38.setViewportView(hsPredictTable);

                                javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
                                jPanel29.setLayout(jPanel29Layout);
                                jPanel29Layout.setHorizontalGroup(
                                    jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGap(0, 770, Short.MAX_VALUE)
                                    .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane38, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE))
                                );
                                jPanel29Layout.setVerticalGroup(
                                    jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGap(0, 371, Short.MAX_VALUE)
                                    .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane38, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE))
                                );

                                baseTablePanel1.addTab("High School", jPanel29);

                                disCombo1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { }));
                                disCombo1.setEnabled(false);

                                disButton1.setText("District");
                                disButton1.setEnabled(false);
                                disButton1.addActionListener(new java.awt.event.ActionListener() {
                                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                                        disButton1ActionPerformed(evt);
                                    }
                                });

                                provCombo1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { }));
                                provCombo1.setEnabled(false);

                                divCombo1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { }));
                                divCombo1.setEnabled(false);

                                graphPrediction.setText("Graph");

                                javax.swing.GroupLayout predictPanelLayout = new javax.swing.GroupLayout(predictPanel);
                                predictPanel.setLayout(predictPanelLayout);
                                predictPanelLayout.setHorizontalGroup(
                                    predictPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(baseTablePanel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(predictPanelLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(predictPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(predictPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(predictPanelLayout.createSequentialGroup()
                                                    .addGroup(predictPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(provButton1)
                                                        .addComponent(regButton1))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addGroup(predictPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(provCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(regCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addGroup(predictPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(divButton1)
                                                        .addComponent(munButton1))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addGroup(predictPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(divCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(munCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(disButton1)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(disCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(predictPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jSeparator2)))
                                            .addComponent(locationCheck1))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(predictPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(predictExecute, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(graphPrediction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addContainerGap())
                                );
                                predictPanelLayout.setVerticalGroup(
                                    predictPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, predictPanelLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(predictPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(predictExecute))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(predictPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(predictPanelLayout.createSequentialGroup()
                                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(locationCheck1))
                                            .addComponent(graphPrediction))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(predictPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(predictPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(predictPanelLayout.createSequentialGroup()
                                                    .addComponent(regButton1)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(provButton1))
                                                .addGroup(predictPanelLayout.createSequentialGroup()
                                                    .addGroup(predictPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(munButton1)
                                                        .addComponent(regCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addGroup(predictPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(divButton1)
                                                        .addComponent(provCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(predictPanelLayout.createSequentialGroup()
                                                .addGroup(predictPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(disButton1)
                                                    .addComponent(disCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(munCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(divCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(16, 16, 16)
                                        .addComponent(baseTablePanel1)
                                        .addContainerGap())
                                );

                                mainPanel.addTab("Predict Enrollees", predictPanel);

                                jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
                                jLabel3.setText("Enrollment trends per grade level per year");

                                trendSchoolButton.setText("Execute by school");
                                trendSchoolButton.addActionListener(new java.awt.event.ActionListener() {
                                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                                        trendSchoolButtonActionPerformed(evt);
                                    }
                                });

                                locationCheck2.setText("Location based");
                                locationCheck2.addActionListener(new java.awt.event.ActionListener() {
                                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                                        locationCheck2ActionPerformed(evt);
                                    }
                                });

                                provButton2.setText("Province");
                                provButton2.setEnabled(false);
                                provButton2.addActionListener(new java.awt.event.ActionListener() {
                                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                                        provButton2ActionPerformed(evt);
                                    }
                                });

                                regCombo2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { }));
                                regCombo2.setEnabled(false);

                                munButton2.setText("Municipality");
                                munButton2.setEnabled(false);
                                munButton2.addActionListener(new java.awt.event.ActionListener() {
                                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                                        munButton2ActionPerformed(evt);
                                    }
                                });

                                divButton2.setText("Division");
                                divButton2.setEnabled(false);
                                divButton2.addActionListener(new java.awt.event.ActionListener() {
                                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                                        divButton2ActionPerformed(evt);
                                    }
                                });

                                munCombo2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { }));
                                munCombo2.setEnabled(false);

                                regButton2.setText("Region");
                                regButton2.setEnabled(false);
                                regButton2.addActionListener(new java.awt.event.ActionListener() {
                                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                                        regButton2ActionPerformed(evt);
                                    }
                                });

                                esTrendsTable.setModel(new javax.swing.table.DefaultTableModel(
                                    new Object [][] {
                                        {null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null}
                                    },
                                    new String [] {
                                        "school_id", "school_name", "region", "province", "municipality", "division", "district", "enroll count"
                                    }){
                                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                            return false;
                                        }}
                                    );
                                    jScrollPane13.setViewportView(esTrendsTable);

                                    javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
                                    jPanel4.setLayout(jPanel4Layout);
                                    jPanel4Layout.setHorizontalGroup(
                                        jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGap(0, 770, Short.MAX_VALUE)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE))
                                    );
                                    jPanel4Layout.setVerticalGroup(
                                        jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGap(0, 359, Short.MAX_VALUE)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE))
                                    );

                                    trendsTablePanel.addTab("Elementary", jPanel4);

                                    hsTrendsTable.setModel(new javax.swing.table.DefaultTableModel(
                                        new Object [][] {
                                            {null, null, null},
                                            {null, null, null},
                                            {null, null, null},
                                            {null, null, null}
                                        },
                                        new String [] {
                                            "school_id", "school_name", "region", "province", "municipality", "division", "enroll count"
                                        }){
                                            public boolean isCellEditable(int rowIndex, int columnIndex) {
                                                return false;
                                            }}
                                        );
                                        jScrollPane39.setViewportView(hsTrendsTable);

                                        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
                                        jPanel30.setLayout(jPanel30Layout);
                                        jPanel30Layout.setHorizontalGroup(
                                            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGap(0, 770, Short.MAX_VALUE)
                                            .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jScrollPane39, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE))
                                        );
                                        jPanel30Layout.setVerticalGroup(
                                            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGap(0, 359, Short.MAX_VALUE)
                                            .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jScrollPane39, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE))
                                        );

                                        trendsTablePanel.addTab("High School", jPanel30);

                                        esKTrendsTable.setModel(new javax.swing.table.DefaultTableModel(
                                            new Object [][] {
                                                {null, null, null, null, null, null, null},
                                                {null, null, null, null, null, null, null},
                                                {null, null, null, null, null, null, null},
                                                {null, null, null, null, null, null, null}
                                            },
                                            new String [] {
                                                "school_id", "school_name", "region", "province", "municipality", "division", "district", "enroll count"
                                            }){
                                                public boolean isCellEditable(int rowIndex, int columnIndex) {
                                                    return false;
                                                }}
                                            );
                                            jScrollPane14.setViewportView(esKTrendsTable);

                                            javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
                                            jPanel5.setLayout(jPanel5Layout);
                                            jPanel5Layout.setHorizontalGroup(
                                                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGap(0, 770, Short.MAX_VALUE)
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jScrollPane14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE))
                                            );
                                            jPanel5Layout.setVerticalGroup(
                                                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGap(0, 359, Short.MAX_VALUE)
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE))
                                            );

                                            trendsTablePanel.addTab("Elementary Kto12", jPanel5);

                                            hsKTrendsTable.setModel(new javax.swing.table.DefaultTableModel(
                                                new Object [][] {
                                                    {null, null, null, null, null, null, null},
                                                    {null, null, null, null, null, null, null},
                                                    {null, null, null, null, null, null, null},
                                                    {null, null, null, null, null, null, null}
                                                },
                                                new String [] {
                                                    "school_id", "school_name", "region", "province", "municipality", "division", "enroll count"
                                                }){
                                                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                                                        return false;
                                                    }}
                                                );
                                                jScrollPane15.setViewportView(hsKTrendsTable);

                                                javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
                                                jPanel6.setLayout(jPanel6Layout);
                                                jPanel6Layout.setHorizontalGroup(
                                                    jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGap(0, 770, Short.MAX_VALUE)
                                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE))
                                                );
                                                jPanel6Layout.setVerticalGroup(
                                                    jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGap(0, 359, Short.MAX_VALUE)
                                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE))
                                                );

                                                trendsTablePanel.addTab("HighSchool Kto12", jPanel6);

                                                disCombo2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { }));
                                                disCombo2.setEnabled(false);

                                                disButton2.setText("District");
                                                disButton2.setEnabled(false);
                                                disButton2.addActionListener(new java.awt.event.ActionListener() {
                                                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                        disButton2ActionPerformed(evt);
                                                    }
                                                });

                                                provCombo2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { }));
                                                provCombo2.setEnabled(false);

                                                divCombo2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { }));
                                                divCombo2.setEnabled(false);

                                                trendLocationButton.setText("Execute by location");
                                                trendLocationButton.setEnabled(false);
                                                trendLocationButton.addActionListener(new java.awt.event.ActionListener() {
                                                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                        trendLocationButtonActionPerformed(evt);
                                                    }
                                                });

                                                levelCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"es_enrollment", "hs_enrollment", "es_kto12_enrollment", "hs_kto12_enrollment" }));
                                                levelCombo.setEnabled(false);

                                                graphTrends.setText("Graph");
                                                graphTrends.addActionListener(new java.awt.event.ActionListener() {
                                                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                        graphTrendsActionPerformed(evt);
                                                    }
                                                });

                                                javax.swing.GroupLayout trendsPanelLayout = new javax.swing.GroupLayout(trendsPanel);
                                                trendsPanel.setLayout(trendsPanelLayout);
                                                trendsPanelLayout.setHorizontalGroup(
                                                    trendsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(trendsTablePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                    .addGroup(trendsPanelLayout.createSequentialGroup()
                                                        .addContainerGap()
                                                        .addGroup(trendsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(trendsPanelLayout.createSequentialGroup()
                                                                .addGap(21, 21, 21)
                                                                .addGroup(trendsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                    .addComponent(provButton2)
                                                                    .addComponent(regButton2))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(trendsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                    .addComponent(provCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(regCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(trendsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                    .addComponent(divButton2)
                                                                    .addComponent(munButton2))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(trendsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                    .addComponent(divCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(munCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(disButton2)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(disCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(trendsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jSeparator3))
                                                            .addComponent(locationCheck2))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addGroup(trendsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(trendsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(trendLocationButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(levelCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                            .addComponent(trendSchoolButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(graphTrends, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                );
                                                trendsPanelLayout.setVerticalGroup(
                                                    trendsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trendsPanelLayout.createSequentialGroup()
                                                        .addContainerGap()
                                                        .addGroup(trendsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(trendSchoolButton))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(trendsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(trendsPanelLayout.createSequentialGroup()
                                                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(locationCheck2))
                                                            .addComponent(graphTrends))
                                                        .addGap(18, 18, 18)
                                                        .addGroup(trendsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(trendsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addGroup(trendsPanelLayout.createSequentialGroup()
                                                                    .addComponent(regButton2)
                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                    .addComponent(provButton2))
                                                                .addGroup(trendsPanelLayout.createSequentialGroup()
                                                                    .addGroup(trendsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(munButton2)
                                                                        .addComponent(regCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                    .addGroup(trendsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(divButton2)
                                                                        .addComponent(provCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                            .addGroup(trendsPanelLayout.createSequentialGroup()
                                                                .addGroup(trendsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                    .addComponent(disButton2)
                                                                    .addComponent(disCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(munCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(trendLocationButton))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(trendsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                    .addComponent(divCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(levelCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                        .addGap(18, 18, 18)
                                                        .addComponent(trendsTablePanel)
                                                        .addContainerGap())
                                                );

                                                mainPanel.addTab("Enrollment Trends", trendsPanel);

                                                jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
                                                jLabel4.setText("Percentage of public schools that offer a special education program");

                                                spedExecute.setText("Execute");
                                                spedExecute.addActionListener(new java.awt.event.ActionListener() {
                                                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                        spedExecuteActionPerformed(evt);
                                                    }
                                                });

                                                locationCheck3.setText("Location based");
                                                locationCheck3.addActionListener(new java.awt.event.ActionListener() {
                                                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                        locationCheck3ActionPerformed(evt);
                                                    }
                                                });

                                                provButton3.setText("Province");
                                                provButton3.setEnabled(false);
                                                provButton3.addActionListener(new java.awt.event.ActionListener() {
                                                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                        provButton3ActionPerformed(evt);
                                                    }
                                                });

                                                regCombo3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { }));
                                                regCombo3.setEnabled(false);

                                                munButton3.setText("Municipality");
                                                munButton3.setEnabled(false);
                                                munButton3.addActionListener(new java.awt.event.ActionListener() {
                                                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                        munButton3ActionPerformed(evt);
                                                    }
                                                });

                                                divButton3.setText("Division");
                                                divButton3.setEnabled(false);
                                                divButton3.addActionListener(new java.awt.event.ActionListener() {
                                                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                        divButton3ActionPerformed(evt);
                                                    }
                                                });

                                                munCombo3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { }));
                                                munCombo3.setEnabled(false);

                                                regButton3.setText("Region");
                                                regButton3.setEnabled(false);
                                                regButton3.addActionListener(new java.awt.event.ActionListener() {
                                                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                        regButton3ActionPerformed(evt);
                                                    }
                                                });

                                                esKSpedTable.setModel(new javax.swing.table.DefaultTableModel(
                                                    new Object [][] {
                                                        {null, null, null, null, null, null, null, null, null, null, null},
                                                        {null, null, null, null, null, null, null, null, null, null, null},
                                                        {null, null, null, null, null, null, null, null, null, null, null},
                                                        {null, null, null, null, null, null, null, null, null, null, null}
                                                    },
                                                    new String [] {
                                                        "region", "province", "municipality", "division", "district", "school_id", "school_name", "academic_year", "sped_count", "regular_count", "sped_percentage", "regular_percentage"
                                                    }){
                                                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                                            return false;
                                                        }}
                                                    );
                                                    jScrollPane17.setViewportView(esKSpedTable);

                                                    javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
                                                    jPanel8.setLayout(jPanel8Layout);
                                                    jPanel8Layout.setHorizontalGroup(
                                                        jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGap(0, 770, Short.MAX_VALUE)
                                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jScrollPane17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE))
                                                    );
                                                    jPanel8Layout.setVerticalGroup(
                                                        jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGap(0, 374, Short.MAX_VALUE)
                                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE))
                                                    );

                                                    baseTablePanel2.addTab("Elementary Kto12", jPanel8);

                                                    hsKSpedTable.setModel(new javax.swing.table.DefaultTableModel(
                                                        new Object [][] {
                                                            {null, null, null, null, null, null, null, null, null, null, null},
                                                            {null, null, null, null, null, null, null, null, null, null, null},
                                                            {null, null, null, null, null, null, null, null, null, null, null},
                                                            {null, null, null, null, null, null, null, null, null, null, null}
                                                        },
                                                        new String [] {
                                                            "region", "province", "municipality", "division", "school_id", "school_name", "academic_year", "sped_count", "regular_count", "sped_percentage","regular_percentage"
                                                        }){
                                                            public boolean isCellEditable(int rowIndex, int columnIndex) {
                                                                return false;
                                                            }}
                                                        );
                                                        jScrollPane41.setViewportView(hsKSpedTable);

                                                        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
                                                        jPanel32.setLayout(jPanel32Layout);
                                                        jPanel32Layout.setHorizontalGroup(
                                                            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGap(0, 770, Short.MAX_VALUE)
                                                            .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jScrollPane41, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE))
                                                        );
                                                        jPanel32Layout.setVerticalGroup(
                                                            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGap(0, 374, Short.MAX_VALUE)
                                                            .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jScrollPane41, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE))
                                                        );

                                                        baseTablePanel2.addTab("High School Kto12", jPanel32);

                                                        disCombo3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { }));
                                                        disCombo3.setEnabled(false);

                                                        disButton3.setText("District");
                                                        disButton3.setEnabled(false);
                                                        disButton3.addActionListener(new java.awt.event.ActionListener() {
                                                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                                disButton3ActionPerformed(evt);
                                                            }
                                                        });

                                                        provCombo3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { }));
                                                        provCombo3.setEnabled(false);

                                                        divCombo3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { }));
                                                        divCombo3.setEnabled(false);

                                                        graphSPED.setText("Graph");

                                                        javax.swing.GroupLayout basePanel1Layout = new javax.swing.GroupLayout(basePanel1);
                                                        basePanel1.setLayout(basePanel1Layout);
                                                        basePanel1Layout.setHorizontalGroup(
                                                            basePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(baseTablePanel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addGroup(basePanel1Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(basePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                    .addGroup(basePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(jSeparator4))
                                                                    .addComponent(locationCheck3)
                                                                    .addGroup(basePanel1Layout.createSequentialGroup()
                                                                        .addGap(6, 6, 6)
                                                                        .addGroup(basePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                            .addComponent(provButton3)
                                                                            .addComponent(regButton3))
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addGroup(basePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                            .addComponent(provCombo3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(regCombo3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addGroup(basePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                            .addComponent(divButton3)
                                                                            .addComponent(munButton3))
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addGroup(basePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                            .addComponent(divCombo3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(munCombo3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addComponent(disButton3)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(disCombo3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGroup(basePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                    .addComponent(spedExecute, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                    .addComponent(graphSPED, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addContainerGap())
                                                        );
                                                        basePanel1Layout.setVerticalGroup(
                                                            basePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, basePanel1Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(basePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(spedExecute))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(basePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                    .addGroup(basePanel1Layout.createSequentialGroup()
                                                                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(locationCheck3))
                                                                    .addComponent(graphSPED))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(basePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                    .addGroup(basePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addGroup(basePanel1Layout.createSequentialGroup()
                                                                            .addComponent(regButton3)
                                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                            .addComponent(provButton3))
                                                                        .addGroup(basePanel1Layout.createSequentialGroup()
                                                                            .addGroup(basePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(munButton3)
                                                                                .addComponent(regCombo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                            .addGroup(basePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(divButton3)
                                                                                .addComponent(provCombo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                    .addGroup(basePanel1Layout.createSequentialGroup()
                                                                        .addGroup(basePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                            .addComponent(disButton3)
                                                                            .addComponent(disCombo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(munCombo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(divCombo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(18, 18, 18)
                                                                .addComponent(baseTablePanel2)
                                                                .addContainerGap())
                                                        );

                                                        mainPanel.addTab("SPED Percentage", basePanel1);

                                                        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                                                        getContentPane().setLayout(layout);
                                                        layout.setHorizontalGroup(
                                                            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(mainPanel)
                                                        );
                                                        layout.setVerticalGroup(
                                                            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        );

                                                        pack();
                                                    }// </editor-fold>//GEN-END:initComponents

    private void disButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disButtonActionPerformed
        if(disButton.isSelected())
        disCombo.setEnabled(true);
        else
        disCombo.setEnabled(false);
    }//GEN-LAST:event_disButtonActionPerformed

    private void regButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regButtonActionPerformed
        if(regButton.isSelected())
        regCombo.setEnabled(true);
        else
        regCombo.setEnabled(false);
    }//GEN-LAST:event_regButtonActionPerformed

    private void divButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_divButtonActionPerformed
        if(divButton.isSelected())
        divCombo.setEnabled(true);
        else
        divCombo.setEnabled(false);
    }//GEN-LAST:event_divButtonActionPerformed

    private void munButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_munButtonActionPerformed
        if(munButton.isSelected())
        munCombo.setEnabled(true);
        else
        munCombo.setEnabled(false);
    }//GEN-LAST:event_munButtonActionPerformed

    private void provButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_provButtonActionPerformed
        if(provButton.isSelected())
        provCombo.setEnabled(true);
        else
        provCombo.setEnabled(false);
    }//GEN-LAST:event_provButtonActionPerformed

    private void locationCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locationCheckActionPerformed
        if(locationCheck.isSelected()){
            regButton.setEnabled(true);
            provButton.setEnabled(true);
            munButton.setEnabled(true);
            divButton.setEnabled(true);
            disButton.setEnabled(true);
        } else{
            regButton.setEnabled(false);
            provButton.setEnabled(false);
            munButton.setEnabled(false);
            divButton.setEnabled(false);
            disButton.setEnabled(false);
        }
    }//GEN-LAST:event_locationCheckActionPerformed

    private void baseExecuteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baseExecuteActionPerformed
        ArrayList<String> cond = new ArrayList<String>();
        String reg, prov, mun, div, dis, year;

        if(!locationCheck.isSelected() && !yearCheck.isSelected()){
            control.updateBaseTables();
        } else{
            if(yearCheck.isSelected()){
                year = yearCombo.getSelectedItem().toString();
                cond.add("academic_year = '" + year + "'");
            }
            
            if(locationCheck.isSelected()){
                if(regButton.isSelected()){
                    reg = regCombo.getSelectedItem().toString();
                    cond.add("region = '" + reg + "'");
                }
                
                if(provButton.isSelected()){
                    prov = provCombo.getSelectedItem().toString();
                    cond.add("province = '" + prov + "'");
                }
                
                if(munButton.isSelected()){
                    mun = munCombo.getSelectedItem().toString();
                    cond.add("municipality = '" + mun + "'");
                }

                if(divButton.isSelected()){
                    div = divCombo.getSelectedItem().toString();
                    cond.add("division = '" + div + "'");
                }

                if(disButton.isSelected()){
                    dis = disCombo.getSelectedItem().toString();
                    cond.add("district = '" + dis + "'");
                }
            }
            control.sliceBaseTables(cond);
        }
    }//GEN-LAST:event_baseExecuteActionPerformed

    private void yearCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearCheckActionPerformed
        if(yearCheck.isSelected())
        yearCombo.setEnabled(true);
        else
        yearCombo.setEnabled(false);
    }//GEN-LAST:event_yearCheckActionPerformed

    private void predictExecuteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_predictExecuteActionPerformed
        ArrayList<String> cond = new ArrayList<String>();
        String reg, prov, mun, div, dis, year;

        if(!locationCheck1.isSelected()){
            control.updatePredictTables();
        } else{
            if(locationCheck1.isSelected()){
                if(regButton1.isSelected()){
                    reg = regCombo1.getSelectedItem().toString();
                    cond.add("region = '" + reg + "'");
                }
                
                if(provButton1.isSelected()){
                    prov = provCombo1.getSelectedItem().toString();
                    cond.add("province = '" + prov + "'");
                }
                
                if(munButton1.isSelected()){
                    mun = munCombo1.getSelectedItem().toString();
                    cond.add("municipality = '" + mun + "'");
                }

                if(divButton1.isSelected()){
                    div = divCombo1.getSelectedItem().toString();
                    cond.add("division =  '" + div + "'");
                }

                if(disButton.isSelected()){
                    dis = disCombo1.getSelectedItem().toString();
                    cond.add("district =  '" + dis + "'");
                }
            }
            control.slicePredictTables(cond);
        }
    }//GEN-LAST:event_predictExecuteActionPerformed

    private void locationCheck1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locationCheck1ActionPerformed
         if(locationCheck1.isSelected()){
            regButton1.setEnabled(true);
            provButton1.setEnabled(true);
            munButton1.setEnabled(true);
            divButton1.setEnabled(true);
            disButton1.setEnabled(true);
        } else{
            regButton1.setEnabled(false);
            provButton1.setEnabled(false);
            munButton1.setEnabled(false);
            divButton1.setEnabled(false);
            disButton1.setEnabled(false);
        }
    }//GEN-LAST:event_locationCheck1ActionPerformed

    private void provButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_provButton1ActionPerformed
        if(provButton1.isSelected())
        provCombo1.setEnabled(true);
        else
        provCombo1.setEnabled(false);
    }//GEN-LAST:event_provButton1ActionPerformed

    private void munButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_munButton1ActionPerformed
        if(munButton1.isSelected())
        munCombo1.setEnabled(true);
        else
        munCombo1.setEnabled(false);
    }//GEN-LAST:event_munButton1ActionPerformed

    private void divButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_divButton1ActionPerformed
        if(divButton1.isSelected())
        divCombo1.setEnabled(true);
        else
        divCombo1.setEnabled(false);
    }//GEN-LAST:event_divButton1ActionPerformed

    private void regButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regButton1ActionPerformed
        if(regButton1.isSelected())
        regCombo1.setEnabled(true);
        else
        regCombo1.setEnabled(false);
    }//GEN-LAST:event_regButton1ActionPerformed

    private void disButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disButton1ActionPerformed
        if(disButton1.isSelected())
        disCombo1.setEnabled(true);
        else
        disCombo1.setEnabled(false);
    }//GEN-LAST:event_disButton1ActionPerformed

    private void trendSchoolButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trendSchoolButtonActionPerformed
        ArrayList<String> cond = new ArrayList<String>();
        String reg, prov, mun, div, dis, year;

        if(!locationCheck2.isSelected()){
            control.updateTrendsTables();
        } else{
            if(locationCheck2.isSelected()){
                if(regButton2.isSelected()){
                    reg = regCombo2.getSelectedItem().toString();
                    cond.add("region = '" + reg + "'");
                }
                
                if(provButton2.isSelected()){
                    prov = provCombo2.getSelectedItem().toString();
                    cond.add("province =  '" + prov + "'");
                }
                
                if(munButton2.isSelected()){
                    mun = munCombo2.getSelectedItem().toString();
                    cond.add("municipality = '" + mun + "'");
                }

                if(divButton2.isSelected()){
                    div = divCombo2.getSelectedItem().toString();
                    cond.add("division = '" + div + "'");
                }

                if(disButton2.isSelected()){
                    dis = disCombo2.getSelectedItem().toString();
                    cond.add("district = '" + dis + "'");
                }
            }
            control.sliceTrendsTables(cond);
        }
    }//GEN-LAST:event_trendSchoolButtonActionPerformed

    private void locationCheck2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locationCheck2ActionPerformed
        if(locationCheck2.isSelected()){
            trendLocationButton.setEnabled(true);
            regButton2.setEnabled(true);
            provButton2.setEnabled(true);
            munButton2.setEnabled(true);
            divButton2.setEnabled(true);
            disButton2.setEnabled(true);
            levelCombo.setEnabled(true);
        } else{
            trendLocationButton.setEnabled(false);
            regButton2.setEnabled(false);
            provButton2.setEnabled(false);
            munButton2.setEnabled(false);
            divButton2.setEnabled(false);
            disButton2.setEnabled(false);
            levelCombo.setEnabled(true);
        }
    }//GEN-LAST:event_locationCheck2ActionPerformed

    private void provButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_provButton2ActionPerformed
        if(provButton2.isSelected())
        provCombo2.setEnabled(true);
        else
        provCombo2.setEnabled(false);
    }//GEN-LAST:event_provButton2ActionPerformed

    private void munButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_munButton2ActionPerformed
        if(munButton2.isSelected())
        munCombo2.setEnabled(true);
        else
        munCombo2.setEnabled(false);
    }//GEN-LAST:event_munButton2ActionPerformed

    private void divButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_divButton2ActionPerformed
        if(divButton2.isSelected())
        divCombo2.setEnabled(true);
        else
        divCombo2.setEnabled(false);
    }//GEN-LAST:event_divButton2ActionPerformed

    private void regButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regButton2ActionPerformed
        if(regButton2.isSelected())
        regCombo2.setEnabled(true);
        else
        regCombo2.setEnabled(false);
    }//GEN-LAST:event_regButton2ActionPerformed

    private void disButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disButton2ActionPerformed
        if(disButton2.isSelected())
        disCombo2.setEnabled(true);
        else
        disCombo2.setEnabled(false);
    }//GEN-LAST:event_disButton2ActionPerformed

    private void trendLocationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trendLocationButtonActionPerformed
        ArrayList<String> cond = new ArrayList<String>();
        String reg, prov, mun, div, dis, level;

        if(!locationCheck2.isSelected()){
            control.updateTrendsTables();
        } else{
            level = levelCombo.getSelectedItem().toString();
            
            if(locationCheck2.isSelected()){
                if(regButton2.isSelected()){
                    reg = regCombo2.getSelectedItem().toString();
                    cond.add("region = '" + reg + "'");
                }
                
                if(provButton2.isSelected()){
                    prov = provCombo2.getSelectedItem().toString();
                    cond.add("province = '" + prov + "'");
                }
                
                if(munButton2.isSelected()){
                    mun = munCombo2.getSelectedItem().toString();
                    cond.add("municipality = '" + mun + "'");
                }

                if(divButton2.isSelected()){
                    div = divCombo2.getSelectedItem().toString();
                    cond.add("division = '" + div + "'");
                }

                if(disButton2.isSelected()){
                    dis = disCombo2.getSelectedItem().toString();
                    cond.add("district = '" + dis + "'");
                }
            }
            control.showLocationTrend(level, cond);
        }
    }//GEN-LAST:event_trendLocationButtonActionPerformed

    private void spedExecuteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spedExecuteActionPerformed
        ArrayList<String> cond = new ArrayList<String>();
        String reg, prov, mun, div, dis, level;

        if(!locationCheck3.isSelected()){
            control.updateSpedTables();
        } else{
            if(locationCheck3.isSelected()){
                if(regButton3.isSelected()){
                    reg = regCombo3.getSelectedItem().toString();
                    cond.add("region = '" + reg + "'");
                }
                
                if(provButton3.isSelected()){
                    prov = provCombo3.getSelectedItem().toString();
                    cond.add("province = '" + prov + "'");
                }
                
                if(munButton3.isSelected()){
                    mun = munCombo3.getSelectedItem().toString();
                    cond.add("municipality = '" + mun + "'");
                }

                if(divButton3.isSelected()){
                    div = divCombo3.getSelectedItem().toString();
                    cond.add("division = '" + div + "'");
                }

                if(disButton3.isSelected()){
                    dis = disCombo3.getSelectedItem().toString();
                    cond.add("district = '" + dis + "'");
                }
            }
            control.sliceSpedTables(cond);
        }
    }//GEN-LAST:event_spedExecuteActionPerformed

    private void locationCheck3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locationCheck3ActionPerformed
        if(locationCheck3.isSelected()){
            regButton3.setEnabled(true);
            provButton3.setEnabled(true);
            munButton3.setEnabled(true);
            divButton3.setEnabled(true);
            disButton3.setEnabled(true);
        } else{
            regButton3.setEnabled(false);
            provButton3.setEnabled(false);
            munButton3.setEnabled(false);
            divButton3.setEnabled(false);
            disButton3.setEnabled(false);
        }
    }//GEN-LAST:event_locationCheck3ActionPerformed

    private void provButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_provButton3ActionPerformed
        if(provButton3.isSelected())
        provCombo3.setEnabled(true);
        else
        provCombo3.setEnabled(false);
    }//GEN-LAST:event_provButton3ActionPerformed

    private void munButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_munButton3ActionPerformed
        if(munButton3.isSelected())
        munCombo3.setEnabled(true);
        else
        munCombo3.setEnabled(false);
    }//GEN-LAST:event_munButton3ActionPerformed

    private void divButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_divButton3ActionPerformed
        if(divButton3.isSelected())
        divCombo3.setEnabled(true);
        else
        divCombo3.setEnabled(false);
    }//GEN-LAST:event_divButton3ActionPerformed

    private void regButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regButton3ActionPerformed
        if(regButton3.isSelected())
        regCombo3.setEnabled(true);
        else
        regCombo3.setEnabled(false);
    }//GEN-LAST:event_regButton3ActionPerformed

    private void disButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disButton3ActionPerformed
        if(disButton3.isSelected())
        disCombo3.setEnabled(true);
        else
        disCombo3.setEnabled(false);
    }//GEN-LAST:event_disButton3ActionPerformed

    private void graphTrendsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graphTrendsActionPerformed
        javafx.application.Application.launch(LineChartView.class);
    }//GEN-LAST:event_graphTrendsActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton baseExecute;
    private javax.swing.JPanel basePanel;
    private javax.swing.JPanel basePanel1;
    private javax.swing.JTabbedPane baseTablePanel;
    private javax.swing.JTabbedPane baseTablePanel1;
    private javax.swing.JTabbedPane baseTablePanel2;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton disButton;
    private javax.swing.JRadioButton disButton1;
    private javax.swing.JRadioButton disButton2;
    private javax.swing.JRadioButton disButton3;
    private javax.swing.JComboBox disCombo;
    private javax.swing.JComboBox disCombo1;
    private javax.swing.JComboBox disCombo2;
    private javax.swing.JComboBox disCombo3;
    private javax.swing.JRadioButton divButton;
    private javax.swing.JRadioButton divButton1;
    private javax.swing.JRadioButton divButton2;
    private javax.swing.JRadioButton divButton3;
    private javax.swing.JComboBox divCombo;
    private javax.swing.JComboBox divCombo1;
    private javax.swing.JComboBox divCombo2;
    private javax.swing.JComboBox divCombo3;
    private javax.swing.JTable esBaseTable;
    private javax.swing.JTable esKBaseTable;
    private javax.swing.JTable esKSpedTable;
    private javax.swing.JTable esKTrendsTable;
    private javax.swing.JTable esPredictTable;
    private javax.swing.JTable esTrendsTable;
    private javax.swing.JButton graphPrediction;
    private javax.swing.JButton graphSPED;
    private javax.swing.JButton graphTrends;
    private javax.swing.JTable hsBaseTable;
    private javax.swing.JTable hsKBaseTable;
    private javax.swing.JTable hsKSpedTable;
    private javax.swing.JTable hsKTrendsTable;
    private javax.swing.JTable hsPredictTable;
    private javax.swing.JTable hsTrendsTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane36;
    private javax.swing.JScrollPane jScrollPane37;
    private javax.swing.JScrollPane jScrollPane38;
    private javax.swing.JScrollPane jScrollPane39;
    private javax.swing.JScrollPane jScrollPane41;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JComboBox levelCombo;
    private javax.swing.JCheckBox locationCheck;
    private javax.swing.JCheckBox locationCheck1;
    private javax.swing.JCheckBox locationCheck2;
    private javax.swing.JCheckBox locationCheck3;
    private javax.swing.JTabbedPane mainPanel;
    private javax.swing.JRadioButton munButton;
    private javax.swing.JRadioButton munButton1;
    private javax.swing.JRadioButton munButton2;
    private javax.swing.JRadioButton munButton3;
    private javax.swing.JComboBox munCombo;
    private javax.swing.JComboBox munCombo1;
    private javax.swing.JComboBox munCombo2;
    private javax.swing.JComboBox munCombo3;
    private javax.swing.JButton predictExecute;
    private javax.swing.JPanel predictPanel;
    private javax.swing.JRadioButton provButton;
    private javax.swing.JRadioButton provButton1;
    private javax.swing.JRadioButton provButton2;
    private javax.swing.JRadioButton provButton3;
    private javax.swing.JComboBox provCombo;
    private javax.swing.JComboBox provCombo1;
    private javax.swing.JComboBox provCombo2;
    private javax.swing.JComboBox provCombo3;
    private javax.swing.JRadioButton regButton;
    private javax.swing.JRadioButton regButton1;
    private javax.swing.JRadioButton regButton2;
    private javax.swing.JRadioButton regButton3;
    private javax.swing.JComboBox regCombo;
    private javax.swing.JComboBox regCombo1;
    private javax.swing.JComboBox regCombo2;
    private javax.swing.JComboBox regCombo3;
    private javax.swing.JButton spedExecute;
    private javax.swing.JButton trendLocationButton;
    private javax.swing.JButton trendSchoolButton;
    private javax.swing.JPanel trendsPanel;
    private javax.swing.JTabbedPane trendsTablePanel;
    private javax.swing.JCheckBox yearCheck;
    private javax.swing.JComboBox yearCombo;
    // End of variables declaration//GEN-END:variables
}
