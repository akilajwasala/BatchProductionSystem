/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batchprosys;

/**
 *
 * @author prathibha
 */


import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class UserDetailsSL extends AbstractTableModel{
   
    public static final String[] COLUMN_NAME={"Production Manager Name","User_ID","Section"};
    public static ArrayList<User> list;
    
    UserDetailsSL(ArrayList<User> userList){
        list=userList;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAME.length;
    }
    
    public String getColumnName(int columnIndex){
        return COLUMN_NAME[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return list.get(rowIndex).getUserID();
            case 1:
                return list.get(rowIndex).getUsername();
            case 2:
                return list.get(rowIndex).getSection();
            default:
                return "Error";
        }
    }    
}

