package controller;

import db_connection.File;
import db_connection.TXTFile;
import javax.swing.JOptionPane;

public class Main_Driver {
    public static void main(String[] args) {
        File file = new TXTFile("src/db_connection/config.txt");
	if(file.getConnector().getConnection() != null){
            Controller.getInstance();
        }else
            JOptionPane.showMessageDialog(null, "Error connecting to MySQL!", "Message", JOptionPane.ERROR_MESSAGE);
    }
}
