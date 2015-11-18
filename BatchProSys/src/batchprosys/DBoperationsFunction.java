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

/**
 *
 * @author prathibha
 */
public class DBoperationsFunction {
    String url = "jdbc:mysql://localhost:3306/batchproductionsystem?useUnicode=true&characterEncoding=utf-8";
    String username = "root";
    String password = "";
    private static String name;
    Connection con = null;
    PreparedStatement pst = null;
    PreparedStatement pst2 = null;
    ResultSet rs = null;
    ResultSet rs2 = null;
    String  UserID;
    
    //BatchFunction BP=new BatchFunction();
    
    int  getOrderQunatity(int orderArticle){
        try {
            
            con=DriverManager.getConnection(url, username, password);
            String quary="SELECT Order_Quantity FROM Order_Plan WHERE Oreder_Article="+orderArticle;
            pst=(PreparedStatement) con.prepareStatement(quary);
            rs=pst.executeQuery();
            rs.next();
            return rs.getInt(1);
            
            
        } catch (SQLException ex) {
            System.out.println(ex);
            return -1;
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
    
    double  getsetuptime(int orderArticle){
        try {
            
            con=DriverManager.getConnection(url, username, password);
            String quary="SELECT * FROM setup_time WHERE Order_Article="+orderArticle;
            pst=(PreparedStatement) con.prepareStatement(quary);
            rs=pst.executeQuery();
            rs.next();
            
            return (rs.getDouble(2)+rs.getDouble(3)+rs.getDouble(4)+rs.getDouble(5)+rs.getDouble(6)+rs.getDouble(7)+rs.getDouble(8))/7;
            
            
        } catch (SQLException ex) {
            System.out.println(ex);
            return -1;
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
    
    double  getAllraisiti(int[] orderArticleArray,int atime){
        try {
            
            con=DriverManager.getConnection(url, username, password);
            double [] rai_array=new double[orderArticleArray.length];
            for(int i=0;i<orderArticleArray.length;i++){
                String quary="SELECT Order_Quantity FROM Order_Plan WHERE Oreder_Article="+orderArticleArray[i];
                pst = (PreparedStatement) con.prepareStatement(quary);
                rs = pst.executeQuery();
                rs.next();
                //System.out.println(rs.getInt(1));
                rai_array[i]=(double)rs.getInt(1)/atime;
            
            }
            //System.out.println("compleate - rai");
            for(double a:rai_array){
                System.out.println("RAIarray-"+a);
            }
            double sum=0;
            for(int i=2;i<9;i++){
                
                for(int j=0;j<orderArticleArray.length;j++){
                    String quary1 = "SELECT * FROM Section_Wise_Time WHERE Order_Article=" + orderArticleArray[j];
                    String quary2 = "SELECT * FROM Setup_Time WHERE Order_Article=" + orderArticleArray[j];
                    pst = (PreparedStatement) con.prepareStatement(quary1);
                    rs = pst.executeQuery();
                    pst2 = (PreparedStatement) con.prepareStatement(quary2);
                    rs2 = pst2.executeQuery();
                    rs.next();
                    rs2.next();

                    //double rai = BP.rai(orderArticleArray[j], atime);
                    
                    
                    sum+= rai_array[j]*rs.getInt(i) * rs2.getInt(i);
                    //System.out.println(sum);
                }
            }
            return sum;
            
        } catch (SQLException ex) {
            System.out.println(ex);
            return -1;
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
    
    int  batchQuantity(double L,int orderArticle){
        try {
            
            con=DriverManager.getConnection(url, username, password);
            String quary1="SELECT * FROM Section_Wise_Time WHERE Order_Article="+orderArticle;
            String quary2="SELECT * FROM Setup_Time WHERE Order_Article="+orderArticle;
            pst=(PreparedStatement) con.prepareStatement(quary1);
            rs=pst.executeQuery();
            pst2=(PreparedStatement) con.prepareStatement(quary2);
            rs2=pst2.executeQuery();
            rs.next();
            rs2.next();
            /*
            double quantity=0;
            for (int i=2;i<9;i++){
                //System.out.println(rs.getInt(i));
                //System.out.println(rs2.getInt(i));
                if(rs.getDouble(i)==0){
                    quantity+=(L-rs2.getDouble(i));
                }
                else{
                    quantity+=(L-rs2.getDouble(i))/rs.getDouble(i);
                }
            }
            //System.out.println("filan-"+quantity);
            return (int)quantity/7;
            */
            double quantity=0;
            double zigmaSi=0;
            double zigmaTi=0;
            for(int i=2;i<9;i++){
                zigmaSi+=rs.getDouble(i)/7;
                zigmaTi+=rs.getDouble(i)/7;
            }
            quantity=(L-zigmaSi)/zigmaTi;
            return (int)quantity;
            
        } catch (SQLException ex) {
            System.out.println(ex);
            return -1;
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
    
    double[]  getAllUti(int[] orderArticleArray,int atime){
        try {
            
            con=DriverManager.getConnection(url, username, password);
            double [] rai_array=new double[orderArticleArray.length];
            for(int i=0;i<orderArticleArray.length;i++){
                String quary="SELECT Order_Quantity FROM Order_Plan WHERE Oreder_Article="+orderArticleArray[i];
                pst = (PreparedStatement) con.prepareStatement(quary);
                rs = pst.executeQuery();
                rs.next();
                //System.out.println(rs.getInt(1));
                rai_array[i]=(double)rs.getInt(1)/atime;
            
            }
            //System.out.println("compleate - rai");
            for(double a:rai_array){
                System.out.println("RAIarray-"+a);
            }
            
            double [] Us=new double[7];
            for(int i=2;i<9;i++){
                double sum=0;
                for(int j=0;j<orderArticleArray.length;j++){
                    String quary1 = "SELECT * FROM Section_Wise_Time WHERE Order_Article=" + orderArticleArray[j];
                    String quary2 = "SELECT * FROM Setup_Time WHERE Order_Article=" + orderArticleArray[j];
                    pst = (PreparedStatement) con.prepareStatement(quary1);
                    rs = pst.executeQuery();
                    pst2 = (PreparedStatement) con.prepareStatement(quary2);
                    rs2 = pst2.executeQuery();
                    rs.next();
                    rs2.next();

                    //double rai = BP.rai(orderArticleArray[j], atime);
                    
                    
                    sum+= rai_array[j]*(rs.getDouble(i)+rs2.getDouble(i));
                    System.out.println("rsgeti-"+rs.getDouble(i));
                    System.out.println("sum uti-"+sum);
                }
                Us[i-2]=sum;
            }
            return Us;
            
        } catch (SQLException ex) {
            System.out.println(ex);
            //return -1;
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
        return null;
    }
    
    
}
