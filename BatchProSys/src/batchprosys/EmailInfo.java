/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batchprosys;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import static javafx.beans.binding.Bindings.length;
//import static jdk.nashorn.internal.objects.ArrayBufferView.length;
import static oracle.jrockit.jfr.events.Bits.length;

/**
 *
 * @author prathibha
 */
public class EmailInfo {
    String url = "jdbc:mysql://localhost:3306/batchproductionsystem?useUnicode=true&characterEncoding=utf-8";
    String username = "root";
    String password = "";
    private static String name;
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    String  UserID;
    
    String[] getEmailInfo(String userid){
        
        
         String[] Array=new String[5];
        try {
            con=DriverManager.getConnection(url, this.username, this.password);
            String quary="SELECT User_ID,User_Name,Password,Email  FROM user WHERE User_ID='"+userid+"'";
            pst=(PreparedStatement) con.prepareStatement(quary);
            rs=pst.executeQuery();
            
            if(rs.next()){
                
                
                Array[0] = rs.getString(1);
                Array[1] = rs.getString(2);
                Array[2] = rs.getString(3);
                Array[3] = rs.getString(4);
                
            };
            
            return Array;
            
            
        } catch (SQLException ex) {
            System.out.println(ex);
            return  null;
        }finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }     
        
    }
    
    String[] getUser(){
        try {
            String[] Array = new String[100];
            con=DriverManager.getConnection(url, username, password);
            String quary="SELECT User_ID FROM user ";
            pst=(PreparedStatement) con.prepareStatement(quary);
            rs=pst.executeQuery();
            int i=0;
            while(rs.next()){
                Array[i]=(rs.getString(1));
                i+=1;
            }
            return Array;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
        finally {

            try {
                if (pst != null) {
                    pst.close();
                }
                
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }   
    }
    
    /*
    int getUser(String userid){
        try {
            String[] Array = new String[100];
            con=DriverManager.getConnection(url, username, password);
            String quary="SELECT User_ID FROM user ";
            pst=(PreparedStatement) con.prepareStatement(quary);
            rs=pst.executeQuery();
            int i=0;
            for(i;i<100;i++){
            while(rs.next()){
                if(userid.equals(rs.getString(1))){
                    return 1;
                    i+=100;
                }
                else {
                    
                }
            }
            }
            return 4;
        } catch (SQLException ex) {
            System.out.println(ex);
            return 3;
        }
        finally {

            try {
                if (pst != null) {
                    pst.close();
                }
                
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }   
    }
    */
    
    int SerachUserID(String userid){
        String arr[]=getUser();
        int check=0;
        for(int i=0;i<arr.length;i++)
        {
            if(userid.equals(arr[i])){
                check=1;
                break;
            }
            else{
                check=0;
            }
        }
        return check;
        
    }
}
