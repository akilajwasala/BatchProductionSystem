/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batchprosys;

import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRReport;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JRDesignViewer;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author prathibha
 */
public class JReportConnection {
    String url="jdbc:mysql://127.0.0.1:3306/batchproductionsystem?useUnicode=true&characterEncoding=utf-8";//url=jdbc:mysql://hostname/ databaseName
    String username="root";
    String password="";
    String database="batchproductionsystem";
    
    void generateReport(String path){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(url, username, password);
            //JasperDesign jasperDesign=Jasper
            //JasperReport jc=JasperCompileManager.compileReport(path);
            JasperPrint print = JasperFillManager.fillReport(path,null,con);
            //JasperViewer.viewReport(print);
            //con.close();
            JRViewer test=new JRViewer(print);
            con.close();
            JFrame frame=new JFrame("Final Report");
            frame.getContentPane().add("Center",test);
            frame.setSize(600, 1300);
            frame.setMinimumSize(new Dimension(600, 0));
            frame.setMaximumSize(new Dimension(600, Integer.MAX_VALUE));
            //frame.pack();
            frame.setVisible(true);
            
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
