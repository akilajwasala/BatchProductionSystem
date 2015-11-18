/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batchprosys;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;
import static java.util.Calendar.MINUTE;
import java.util.Date;
/**
 *
 * @author sumi
 */
public class DBOperations {
// get url from text file
// encript password fields
// dont show the text 
    String url = "jdbc:mysql://localhost:3306/batchproductionsystem?useUnicode=true&characterEncoding=utf-8";
    String username = "root";
    String password = "";
    private static String name;
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    private static String  UserID;
    private static String Password;
    
    public boolean addUser(User s) {//insert student data into the database
        try {
            System.out.println("p1*");
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO user VALUES (?,?,?,?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
            System.out.println("p2*");
            
            pst.setString(1, s.getUserID());
            pst.setString(6, s.getUserType());
            pst.setString(2, s.getUsername());
            pst.setString(3, s.getPassword());
            pst.setString(7, s.getSection());
            pst.setInt(8, s.getAvailability());
            pst.setString(4, s.getInitialUsername());
            pst.setString(5, s.getInitialPassword());
            pst.setString(9, "null");
            //pst.setArray(i, null);
            System.out.println("p3*");
       
            pst.executeUpdate();
            
            System.out.println("p4");
            return true;

        } catch (Exception e) {
            System.out.println("exception --->" + e);
            return false;
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    pst.close();
                }
            } catch (Exception e) {
            }

        }
    }
    int checkUsernamePassword(String userID,String password){
        try {
            con=DriverManager.getConnection(url, this.username, this.password);
            String quary="SELECT User_ID,Password FROM user";
            pst=(PreparedStatement) con.prepareStatement(quary);
            rs=pst.executeQuery();
            
            while(rs.next()){
                if(rs.getString(1).equals(userID) & rs.getString(2).equals(password)){
                    UserID=userID;
                    Password=password;
                    return 1;
                }
            }return 0;
            
        } catch (SQLException ex) {
            System.out.println(ex);
            return 2;
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
    
    ArrayList<User> getUser(){
        try {
            ArrayList<User> list=new ArrayList<User>();
            con=DriverManager.getConnection(url, username, password);
            String quary="SELECT * FROM user ";
            pst=(PreparedStatement) con.prepareStatement(quary);
            rs=pst.executeQuery();
            
            while(rs.next()){
                User user=new User();
                
                user.setUserID(rs.getString(1));
                user.setUserType(rs.getString(6));
                user.setUsername(rs.getString(2));
                user.setAvailability(rs.getInt(8));
                user.setSection(rs.getString(7));
                list.add(user);
            }
            return list;
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
    
    public boolean updateUser(User user){
        try {
            con=DriverManager.getConnection(url, username, password);
            String quary="UPDATE user SET Designation='"+user.getUserType()+"',Section='"+user.getSection()+"' WHERE User_ID='"+user.getUserID()+"'";
            pst=(PreparedStatement) con.prepareStatement(quary);
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
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
    
    public boolean updateUserAvailability(User user){
        try {
            con=DriverManager.getConnection(url, username, password);
            String quary="UPDATE user SET Availability='"+user.getAvailability()+"' WHERE User_ID='"+user.getUserID()+"'";
            pst=(PreparedStatement) con.prepareStatement(quary);
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
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
    /*ArrayList<User> getUserSL(){
        try {
            ArrayList<User> list=new ArrayList<User>();
            con=DriverManager.getConnection(url, username, password);
            String quary="SELECT * FROM user WHERE usertype='Section Leader'";
            pst=(PreparedStatement) con.prepareStatement(quary);
            rs=pst.executeQuery();
            
            while(rs.next()){
                User user=new User();
                user.setUserID(rs.getString(3));
                user.setUsername(rs.getString(1));
                user.setSection(rs.getString(5));
                list.add(user);
            }
            return list;
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
    }*/

    int checkUserAvailability(String userID){
        try {
            con=DriverManager.getConnection(url, this.username, this.password);
            String quary="SELECT Availability FROM user WHERE User_Id='"+userID+"'";
            pst=(PreparedStatement) con.prepareStatement(quary);
            rs=pst.executeQuery();
            rs.next();
            if(rs.getInt(1)==1){
                return 1;
            }else{
                return 0;
            }
            
            
        } catch (SQLException ex) {
            System.out.println(ex);
            return 2;
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
    
    
    int OpenInterface(String userID) {
        try {
            con = DriverManager.getConnection(url, this.username, this.password);
            String quary = "SELECT Designation FROM user WHERE User_Id='" + userID + "'";
            pst = (PreparedStatement) con.prepareStatement(quary);
            rs = pst.executeQuery();
            rs.next();
            if (null != rs.getString(1)) switch (rs.getString(1)) {
                case "Admin":
                    return 1;
                case "Production Manager":
                    return 2;
                case "Production Planner":
                    return 3;
                case "Section Leader":
                    return 4;
            }

        } catch (SQLException ex) {
            System.out.println(ex);
            return 2;
        } finally {
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
        return 0;
    }
    
    
    public static String getName(){
        return name;
    
    }
    
    
    
    void getUserName(String userID){
        
        try {
            //System.out.println("adv");
            con=DriverManager.getConnection(url, this.username, this.password);
            String quary="SELECT User_Name FROM user WHERE User_Id='"+userID+"'";
            pst=(PreparedStatement) con.prepareStatement(quary);
            rs=pst.executeQuery();
            rs.next();
           
            name=rs.getString(1);
            
            
        } catch (SQLException ex) {
            System.out.println(ex);
            
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
    
    public Vector<Vector> getSectionWiseTime(){
        try {
            con=DriverManager.getConnection(url, username, password);
            //User currentUser=this.getCurrentUser();
            String quary="SELECT * FROM Section_Wise_Time ";
            pst=(PreparedStatement) con.prepareStatement(quary);
            rs=pst.executeQuery();
            
            Vector<Vector> table=new Vector<Vector>();
            while(rs.next()){
                Vector<Object> row=new Vector<Object>();
                row.addElement(rs.getString(1));
                row.addElement(rs.getFloat(2));
                row.addElement(rs.getFloat(3));
                row.addElement(rs.getFloat(4));
                row.addElement(rs.getFloat(5));
                row.addElement(rs.getFloat(6));
                row.addElement(rs.getFloat(7));
                row.addElement(rs.getFloat(8));
                
                table.add(row);
            }
            return table;
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
    
    
    public Vector<Vector> getSetupTime(){
        try {
            con=DriverManager.getConnection(url, username, password);
            //User currentUser=this.getCurrentUser();
            String quary="SELECT * FROM Setup_Time ";
            pst=(PreparedStatement) con.prepareStatement(quary);
            rs=pst.executeQuery();
            
            Vector<Vector> table=new Vector<Vector>();
            while(rs.next()){
                Vector<Object> row=new Vector<Object>();
                row.addElement(rs.getString(1));
                row.addElement(rs.getFloat(2));
                row.addElement(rs.getFloat(3));
                row.addElement(rs.getFloat(4));
                row.addElement(rs.getFloat(5));
                row.addElement(rs.getFloat(6));
                row.addElement(rs.getFloat(7));
                row.addElement(rs.getFloat(8));
                
                table.add(row);
            }
            return table;
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
    
    
    String[] getRowFromSetupTime(String tableRow){
        
        
         String[] Array=new String[7];
        try {
            con=DriverManager.getConnection(url, this.username, this.password);
            String quary="SELECT * FROM Setup_Time WHERE Order_Article='"+tableRow+"'";
            pst=(PreparedStatement) con.prepareStatement(quary);
            rs=pst.executeQuery();
            
            if(rs.next()){
                
                
                Array[0] = rs.getString("Pre_Work");
                Array[1] = rs.getString("Assembly_Line");
                Array[2] = rs.getString("Wave_Soldering");
                Array[3] = rs.getString("Quality_Control");
                Array[4] = rs.getString("Testing");
                Array[5] = rs.getString("Final");
                Array[6] = rs.getString("Packing");
               
                
                
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
    
    String[] getRowFromSectionWiseTime(String tableRow){
        
        
         String[] Array=new String[7];
        try {
            con=DriverManager.getConnection(url, this.username, this.password);
            String quary="SELECT * FROM Section_Wise_Time WHERE Order_Article='"+tableRow+"'";
            pst=(PreparedStatement) con.prepareStatement(quary);
            rs=pst.executeQuery();
            
            if(rs.next()){
                
                
                Array[0] = rs.getString("Pre_Work");
                Array[1] = rs.getString("Assembly_Line");
                Array[2] = rs.getString("Wave_Soldering");
                Array[3] = rs.getString("Quality_Control");
                Array[4] = rs.getString("Testing");
                Array[5] = rs.getString("Final");
                Array[6] = rs.getString("Packing");
               
                
                
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
    
    
    public boolean updateTimeSWT(Timings T){
        try {
            con=DriverManager.getConnection(url, username, password);
            String quary="UPDATE Section_Wise_Time SET Pre_Work='"+T.getPreWork()+"',Assembly_Line='"+T.getAssemblyLine()+"',Wave_Soldering='"+T.getWaveSoldering()+"',Quality_Control='"+T.getQualityControl()+"',Testing='"+T.getTesting()+"',Final='"+T.getFinal()+"',Packing='"+T.getPacking()+"' WHERE Order_Article='"+T.getOrderArticle()+"'";
            pst=(PreparedStatement) con.prepareStatement(quary);
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
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
    
    public boolean updateTimeST(Timings T){
        try {
            con=DriverManager.getConnection(url, username, password);
            String quary="UPDATE Setup_Time SET Pre_Work='"+T.getPreWork()+"',Assembly_Line='"+T.getAssemblyLine()+"',Wave_Soldering='"+T.getWaveSoldering()+"',Quality_Control='"+T.getQualityControl()+"',Testing='"+T.getTesting()+"',Final='"+T.getFinal()+"',Packing='"+T.getPacking()+"' WHERE Order_Article='"+T.getOrderArticle()+"'";
            pst=(PreparedStatement) con.prepareStatement(quary);
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
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
    
    public boolean InsertTimeST(Timings T) {//insert student data into the database
        try {
            System.out.println("p1");
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO Setup_Time VALUES (?,?,?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
            System.out.println("p2");
            
            pst.setString(1, T.getOrderArticle());
            pst.setString(2, T.getPreWork());
            pst.setString(3, T.getAssemblyLine());
            pst.setString(4, T.getWaveSoldering());
            pst.setString(5, T.getQualityControl());
            pst.setString(6, T.getTesting());
            pst.setString(7, T.getFinal());
            pst.setString(8,T.getPacking());
           
            //pst.setArray(i, null);
            System.out.println("p3");
       
            pst.executeUpdate();
            
            System.out.println("p4");
            return true;

        } catch (Exception e) {
            System.out.println("exception --->" + e);
            return false;
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    pst.close();
                }
            } catch (Exception e) {
            }

        }
    }
    
    
    public boolean InsertTimeSWT(Timings T) {//insert student data into the database
        try {
            System.out.println("p1");
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO Section_Wise_Time VALUES (?,?,?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
            System.out.println("p2");
            
            pst.setString(1, T.getOrderArticle());
            pst.setString(2, T.getPreWork());
            pst.setString(3, T.getAssemblyLine());
            pst.setString(4, T.getWaveSoldering());
            pst.setString(5, T.getQualityControl());
            pst.setString(6, T.getTesting());
            pst.setString(7, T.getFinal());
            pst.setString(8,T.getPacking());
           
            //pst.setArray(i, null);
            System.out.println("p3");
       
            pst.executeUpdate();
            
            System.out.println("p4");
            return true;

        } catch (Exception e) {
            System.out.println("exception --->" + e);
            return false;
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    pst.close();
                }
            } catch (Exception e) {
            }

        }
    }
    
    public boolean DeleteTimeST(Timings T){
        
        try {
            //System.out.println("adv");
            con=DriverManager.getConnection(url, this.username, this.password);
            String quary="DELETE FROM Setup_Time WHERE Order_Article='"+T.getOrderArticle()+"'";
            pst=(PreparedStatement) con.prepareStatement(quary);
            pst.executeUpdate();
            
           
            return true;
            
            
        } catch (SQLException ex) {
            System.out.println(ex);
            
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
        return false;
       
    }
    
    public boolean DeleteTimeSWT(Timings T){
        
        try {
            //System.out.println("adv");
            con=DriverManager.getConnection(url, this.username, this.password);
            String quary="DELETE FROM Section_Wise_Time WHERE Order_Article='"+T.getOrderArticle()+"'";
            pst=(PreparedStatement) con.prepareStatement(quary);
            pst.executeUpdate();
            //rs.next();
           
            return true;
            
            
        } catch (SQLException ex) {
            System.out.println(ex);
            
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
        return false;
       
        }
    
    public boolean addOrderPP(ArrayList<ArrayList<String>> table) {//insert student data into the database
        try {
            System.out.println("add user-p1");
            
            System.out.println("add user-p2");
            for (int i = 0; i < table.size(); i++) {
                con = (Connection) DriverManager.getConnection(url, username, password);
                String query = "INSERT INTO Order_Plan (Oreder_Article,SAP_No,Order_Quantity)VALUES (?,?,?)";
                pst = (PreparedStatement) con.prepareStatement(query);
                
                pst.setString(1, table.get(i).get(1));
                pst.setString(2, table.get(i).get(0));
                pst.setString(3, table.get(i).get(2));
                //pst.setString(4, table.get(i).get(3));
                
               
                pst.executeUpdate();
            }
            
            //pst.setArray(i, null);
        System.out.println("add user-p3");
       
            
            
            System.out.println("add user-p4");
            return true;

        } catch (Exception e) {
            System.out.println("exception --->" + e);
            return false;
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    pst.close();
                }
            } catch (Exception e) {
            }

        }
    }
    
    public boolean addBatchQuantity(int[] batchq,int[] articleno){//insert student data into the database
        try {
            System.out.println("q-p1");
            
            System.out.println("q-p2");
            for (int i = 0; i < articleno.length; i++) {
                con = (Connection) DriverManager.getConnection(url, username, password);
                String quary="UPDATE Order_Plan SET Batch_Quantity='"+batchq[i]+"' WHERE Oreder_Article='"+articleno[i]+"'";
                pst = (PreparedStatement) con.prepareStatement(quary);
                pst.executeUpdate();
                
            }
            
            
            System.out.println("q-p3");
       
            
            
            System.out.println("q-p4");
            return true;

        } catch (Exception e) {
            System.out.println("exception --->" + e);
            return false;
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    pst.close();
                }
            } catch (Exception e) {
            }

        }
    }
    
    public boolean addNoOfBathches(int[] noofbatches,int[] articleno){//insert student data into the database
        try {
            System.out.println("q-p1");
            
            System.out.println("q-p2");
            for (int i = 0; i < articleno.length; i++) {
                con = (Connection) DriverManager.getConnection(url, username, password);
                String quary="UPDATE Order_Plan SET No_Of_Batches='"+noofbatches[i]+"' WHERE Oreder_Article='"+articleno[i]+"'";
                pst = (PreparedStatement) con.prepareStatement(quary);
                pst.executeUpdate();
                
            }
            
            
            System.out.println("q-p3");
       
            
            
            System.out.println("q-p4");
            return true;

        } catch (Exception e) {
            System.out.println("exception --->" + e);
            return false;
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    pst.close();
                }
            } catch (Exception e) {
            }

        }
    }
    
    public Vector<Vector> getOrderPlan(){
        try {
            con=DriverManager.getConnection(url, username, password);
            //User currentUser=this.getCurrentUser();
            String quary="SELECT * FROM Order_Plan ";
            pst=(PreparedStatement) con.prepareStatement(quary);
            rs=pst.executeQuery();
            
            Vector<Vector> table=new Vector<Vector>();
            while(rs.next()){
                Vector<Object> row=new Vector<Object>();
                row.addElement(rs.getString(2));
                row.addElement(rs.getString(1));
                row.addElement(rs.getInt(3));
                row.addElement(rs.getInt(4));
                row.addElement(rs.getInt(5));
                
                table.add(row);
            }
            return table;
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
    
    public ArrayList<Vector<Vector>> getOrderPlanforSWorkAllocation() {
        try {
            con=DriverManager.getConnection(url, username, password);
            //User currentUser=this.getCurrentUser();
            String quary="SELECT * FROM Order_Plan ";
            pst=(PreparedStatement) con.prepareStatement(quary);
            rs=pst.executeQuery();
            ArrayList<Vector<Vector>> array=new ArrayList<Vector<Vector>>();
            Vector<Vector> pretable=new Vector<Vector>();
            Vector<Vector> altable=new Vector<Vector>();
            Vector<Vector> wstable=new Vector<Vector>();
            Vector<Vector> qctable=new Vector<Vector>();
            Vector<Vector> tesingtable=new Vector<Vector>();
            Vector<Vector> finaltable=new Vector<Vector>();
            Vector<Vector> packingtable=new Vector<Vector>();
            
            Date start1,start2,start3,start4,start5,start6,start7,end1,end2,end3,end4,end5,end6,end7;
            
            String myTime = "07:30";
            SimpleDateFormat df = new SimpleDateFormat("HH:mm");
            start1 = df.parse(myTime);
            while(rs.next()){
                
                String query2 = "SELECT * FROM setup_time WHERE Order_Article="+rs.getString(1);
                PreparedStatement pst1=(PreparedStatement) con.prepareStatement(query2);
                ResultSet rs1=pst1.executeQuery();
                
                
                
                String query3 = "SELECT * FROM section_wise_time WHERE Order_Article="+rs.getString(1);
                PreparedStatement pst2=(PreparedStatement) con.prepareStatement(query3);
                ResultSet rs2=pst2.executeQuery();
                rs1.next();
                rs2.next();
                
                
                //row1.addElement(rs2);
                
                Vector<Object> row1=new Vector<Object>();
                row1.addElement(rs.getString(2));
                row1.addElement(rs.getString(1));
                row1.addElement(rs.getInt(3));
                row1.addElement(rs.getInt(4));
                
                
                Calendar cal = Calendar.getInstance();
                cal.setTime(start1);
                cal.add(Calendar.MINUTE, rs1.getInt(2)+rs2.getInt(2)*rs.getInt(4));
                end1=cal.getTime();
                cal.setTime(start1);
                cal.add(Calendar.MINUTE, rs2.getInt(2));
                start2=cal.getTime();

                row1.addElement(df.format(start1));
                row1.addElement(df.format(end1));
                pretable.addElement(row1);
                start1=end1;
                
                Vector<Object> row2=new Vector<Object>();
                row2.addElement(rs.getString(2));
                row2.addElement(rs.getString(1));
                row2.addElement(rs.getInt(3));
                row2.addElement(rs.getInt(4));
                
                //start=end;
                cal.setTime(start2);
                cal.add(Calendar.MINUTE, rs1.getInt(3)+rs2.getInt(3)*rs.getInt(4));
                end2=cal.getTime();
                cal.setTime(start2);
                cal.add(Calendar.MINUTE, rs2.getInt(3));
                start3=cal.getTime();
                
                
                row2.addElement(df.format(start2));
                row2.addElement(df.format(end2));
                altable.addElement(row2);
                //System.out.println(row1);
                
                Vector<Object> row3=new Vector<Object>();
                row3.addElement(rs.getString(2));
                row3.addElement(rs.getString(1));
                row3.addElement(rs.getInt(3));
                row3.addElement(rs.getInt(4));
                
                //start=end;
                cal.setTime(start3);
                cal.add(Calendar.MINUTE, rs1.getInt(4)+rs2.getInt(4)*rs.getInt(4));
                end3=cal.getTime();
                cal.setTime(start3);
                cal.add(Calendar.MINUTE, rs2.getInt(4));
                start4=cal.getTime();
                
                row3.addElement(df.format(start3));
                row3.addElement(df.format(end3));
                wstable.addElement(row3);
                //System.out.println(row1);
                
                Vector<Object> row4=new Vector<Object>();
                row4.addElement(rs.getString(2));
                row4.addElement(rs.getString(1));
                row4.addElement(rs.getInt(3));
                row4.addElement(rs.getInt(4));
                
                //start=end;
                cal.setTime(start4);
                cal.add(Calendar.MINUTE, rs1.getInt(5)+rs2.getInt(5)*rs.getInt(4));
                end4=cal.getTime();
                cal.setTime(start4);
                cal.add(Calendar.MINUTE, rs2.getInt(5));
                start5=cal.getTime();
                
                
                row4.addElement(df.format(start4));
                row4.addElement(df.format(end4));
                qctable.addElement(row4);
                //System.out.println(row1);
                
                Vector<Object> row5=new Vector<Object>();
                row5.addElement(rs.getString(2));
                row5.addElement(rs.getString(1));
                row5.addElement(rs.getInt(3));
                row5.addElement(rs.getInt(4));
                
                //start=end;
                cal.setTime(start5);
                cal.add(Calendar.MINUTE, rs1.getInt(6)+rs2.getInt(6)*rs.getInt(4));
                end5=cal.getTime();
                cal.setTime(start5);
                cal.add(Calendar.MINUTE, rs2.getInt(6));
                start6=cal.getTime();
                
                row5.addElement(df.format(start5));
                row5.addElement(df.format(end5));
                tesingtable.addElement(row5);
                //System.out.println(row1);
                
                Vector<Object> row6=new Vector<Object>();
                row6.addElement(rs.getString(2));
                row6.addElement(rs.getString(1));
                row6.addElement(rs.getInt(3));
                row6.addElement(rs.getInt(4));
                
                //start=end;
                cal.setTime(start6);
                cal.add(Calendar.MINUTE, rs1.getInt(7)+rs2.getInt(7)*rs.getInt(4));
                end6=cal.getTime();
                cal.setTime(start6);
                cal.add(Calendar.MINUTE, rs2.getInt(7));
                start7=cal.getTime();
                
                
                row6.addElement(df.format(start6));
                row6.addElement(df.format(end6));
                finaltable.addElement(row6);
                //System.out.println(row1);

                Vector<Object> row7=new Vector<Object>();
                row7.addElement(rs.getString(2));
                row7.addElement(rs.getString(1));
                row7.addElement(rs.getInt(3));
                row7.addElement(rs.getInt(4));
                
                //start=end;
                cal.setTime(start7);
                cal.add(Calendar.MINUTE, rs1.getInt(8)+rs2.getInt(8)*rs.getInt(4));
                end7=cal.getTime();
                cal.setTime(start7);
                cal.add(Calendar.MINUTE, rs2.getInt(8));
                //start7=cal.getTime();
                
                
                row7.addElement(df.format(start7));
                row7.addElement(df.format(end7));
                packingtable.addElement(row7);

            }
            
            array.add(pretable);
            array.add(altable);
            array.add(wstable);
            array.add(qctable);
            array.add(tesingtable);
            array.add(finaltable);
            array.add(packingtable);
            
            
            return array;
            
            
            
        } catch (Exception ex) {
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
    
    public boolean InsertTimeDurationAndMechines(Section_Details D) {// insert data to the the database
        try {
            //System.out.println("p1");
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO section_details VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
            //System.out.println("p2");
            pst.setInt(1,D.getId());
            pst.setInt(2, D.getDuration());
            pst.setInt(3, D.getOpw());
            pst.setInt(4, D.getOal());
            pst.setInt(5, D.getOws());
            pst.setInt(6, D.getOqc());
            pst.setInt(7, D.getOtesting());
            pst.setInt(8, D.getOFinal());
            pst.setInt(9, D.getOpacking());
            pst.setInt(10, D.getMpw());
            pst.setInt(11, D.getMal());
            pst.setInt(12, D.getMws());
            pst.setInt(13, D.getMqc());
            pst.setInt(14, D.getMtesting());
            pst.setInt(15, D.getMFinal());
            pst.setInt(16, D.getMpacking());
           
            //pst.setArray(i, null);
            System.out.println("p3");
       
            pst.executeUpdate();
            
            System.out.println("p4");
            return true;

        } catch (Exception e) {
            System.out.println("exception --->" + e);
            return false;
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    pst.close();
                }
            } catch (Exception e) {
            }

        }
    }
    public static String getUserID() {
        return UserID;
    }
    
    public boolean updateUserProfile(User user) {
        try {
            con = DriverManager.getConnection(url, username, password);
            String quary = "UPDATE user SET User_Name='" + user.getUsername() + "',Password='" + user.getPassword() + "' WHERE User_ID='" + user.getUserID() + "'";
            pst = (PreparedStatement) con.prepareStatement(quary);
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        } finally {

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
    
    public static String getPassword() {
        return Password;
    }
    
    public boolean DeleteOrderPlan(){
        
        try {
            //System.out.println("adv");
            con=DriverManager.getConnection(url, this.username, this.password);
            String quary="DELETE FROM Order_Plan";
            pst=(PreparedStatement) con.prepareStatement(quary);
            pst.executeUpdate();
            
           
            return true;
            
            
        } catch (SQLException ex) {
            System.out.println(ex);
            
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
        return false;
       
    }
    
    
    public boolean Deletesectiondetails(){
        
        try {
            //System.out.println("adv");
            con=DriverManager.getConnection(url, this.username, this.password);
            String quary="DELETE FROM section_details";
            pst=(PreparedStatement) con.prepareStatement(quary);
            pst.executeUpdate();
            
           
            return true;
            
            
        } catch (SQLException ex) {
            System.out.println(ex);
            
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
        return false;
       
    }
    
    String[] getsectiondetails(){
        
        
         String[] Array=new String[15];
        try {
            con=DriverManager.getConnection(url, this.username, this.password);
            String quary="SELECT * FROM section_details ";
            pst=(PreparedStatement) con.prepareStatement(quary);
            rs=pst.executeQuery();
            
            if(rs.next()){
                
                
                Array[0] = rs.getString("duration");
                Array[1] = rs.getString("opw");
                Array[2] = rs.getString("oal");
                Array[3] = rs.getString("ows");
                Array[4] = rs.getString("oqc");
                Array[5] = rs.getString("otesting");
                Array[6] = rs.getString("ofinal");
                Array[7] = rs.getString("opacking");
                Array[8] = rs.getString("mpw");
                Array[9] = rs.getString("mal");
                Array[10] = rs.getString("mws");
                Array[11] = rs.getString("mqc");
                Array[12] = rs.getString("mtesting");
                Array[13] = rs.getString("mfinal");
                Array[14] = rs.getString("mpacking");
                
               
                
                
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
    
    String[] getSectionWiseTimeOrder_Article(){
        
        
         String[] Array=new String[150];
        try {
            con=DriverManager.getConnection(url, this.username, this.password);
            String quary="SELECT Order_Article FROM section_wise_time ";
            pst=(PreparedStatement) con.prepareStatement(quary);
            rs=pst.executeQuery();
            int i=0;
            while(rs.next()){
                Array[i] = rs.getString(1);
                i++;
            };
            for(String x:Array){
                System.out.println(x);
            }
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
    
    //Notification Functions
    /*
    
    public  static Vector<Vector> getTableNotification(int userID){
        try {
            Connection con1=null;
            PreparedStatement pst1=null;
            ResultSet rs1=null;
    
            con1=DriverManager.getConnection(url, username, password);
            String quary="SELECT * FROM notification WHERE userID="+userID+" AND userCheck=0";
            pst1=(PreparedStatement) con1.prepareStatement(quary);
            rs1=pst1.executeQuery();
            
            Vector<Vector> set=new Vector<Vector>();
            while(rs1.next()){
                Vector<Object> row=new Vector<Object>();
                row.addElement(rs1.getInt(1));
                if (rs1.getString(3).equals("new")){
                    row.addElement("You are mention as responsible for the ObservationID : "+rs1.getInt(2));
                }
                row.addElement(rs1.getInt(2));               
                set.addElement(row);
            } 
            return set;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
        finally {
            try {
                if (pst1 != null) {
                    pst1.close();
                }
                
                if (con1 != null) {
                    con1.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } 
    }
    
    public  static Vector<Vector> popUpNotification(int userID){
        try { 
            con1=DriverManager.getConnection(url, username, password);
            String quary="SELECT * FROM notification WHERE userID="+userID+" AND sendToUser=0";
            pst1=(PreparedStatement) con1.prepareStatement(quary);
            rs1=pst1.executeQuery();
            
            Vector<Vector> set=new Vector<Vector>();
            while(rs1.next()){
                Vector<Object> row=new Vector<Object>();
                
                if (rs1.getString(3).equals("new")){
                    row.addElement("You are mention as responsible for the ObservationID : "+rs1.getInt(2));
                }
                row.addElement(rs1.getInt(2));               
                set.addElement(row);
            } 
            return set;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
        finally {
            try {
                if (pst1 != null) {
                    pst1.close();
                }
                
                if (con1 != null) {
                    con1.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    } 
    */
}

