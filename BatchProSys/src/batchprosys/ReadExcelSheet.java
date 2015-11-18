/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batchprosys;
import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import java.io.File; 
import java.io.IOException; 
import java.util.Vector;
import jxl.Cell; 
import jxl.CellType; 
import jxl.Sheet; 
import jxl.Workbook;
import jxl.read.biff.BiffException; 

public class ReadExcelSheet {
    private String inputFile;

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    Vector<Vector> read() throws IOException {
        File inputWorkbook = new File(inputFile);
        Workbook w;
        try {
            w = Workbook.getWorkbook(inputWorkbook);
            // Get the first sheet 
            Sheet sheet = w.getSheet(0);
            // Loop over first 10 column and lines 
            String[][] x = new String[sheet.getRows()][sheet.getColumns()];
            System.out.println("R-" + sheet.getRows() + "C-" + sheet.getColumns());
            Vector<Vector> table = new Vector<Vector>();

            //Vector<Object> row = new Vector<Object>();
            for (int j = 0; j < sheet.getRows(); j++) {
                Vector<Object> row = new Vector<Object>();
                for (int i = 0; i < sheet.getColumns(); i++) {

                    Cell cell1 = sheet.getCell(i, j);
                    row.addElement(cell1.getContents());

                }
                table.add(row);

                /*
                 if (type == CellType.LABEL) { 
                 System.out.println("I got a label " 
                 + cell.getContents()); 
                 } 

                 if (type == CellType.NUMBER) { 
                 System.out.println("I got a number " 
                 + cell.getContents()); 
                 } */
            }
            //System.out.println(row.size());
            return table;

        } catch (BiffException e) {
            e.printStackTrace();
        }
        return null;
    }
}
