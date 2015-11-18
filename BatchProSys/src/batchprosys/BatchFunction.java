/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batchprosys;

import javax.swing.JOptionPane;

/**
 *
 * @author prathibha
 */
public class BatchFunction {

    DBoperationsFunction DBOF = new DBoperationsFunction();

    int AvailableTime(int min, int opPlusemchin) {
        return min * opPlusemchin;
    }

    //int AvailableTime= 700*15;

    double rai(int orderArticle, int availabletime) {
        int qunatity = DBOF.getOrderQunatity(orderArticle);
        return qunatity / availabletime;

    }

    double setupTime(int orderArticle) {
        return DBOF.getsetuptime(orderArticle);

    }

    double avarageSetupTime(int[] orderArticleArray) {
        double sum = 0;
        for (int i = 0; i < orderArticleArray.length; i++) {
            sum += setupTime(orderArticleArray[i]);
            System.out.println("sum--"+sum);

        }
        return sum/orderArticleArray.length;
    }

    double L(double aveargrSetupTime, double allraisiti) {
        double L = ((allraisiti / 0.2) + aveargrSetupTime);
        return L;
    }

    int[] batchQuantity(double L, int[] orderArticleArray) {
        //int quantity = 0;
        int array[]=new int[orderArticleArray.length];
        for (int i = 0; i < orderArticleArray.length; i++) {
            if (DBOF.batchQuantity(L, orderArticleArray[i])>0){
                array[i]= DBOF.batchQuantity(L, orderArticleArray[i]);
            }
            else{
                array[i]= 1;
            }

        }
        return array;
    }
    
    
    int[] noofbatches(int[] orderq,int[] batchq){
        int NOB[]=new int[orderq.length];
        for(int i=0;i<orderq.length;i++){
            if(batchq[i]>0){
                NOB[i]=orderq[i]/batchq[i];
            }
            else{
                NOB[i]=1;
            }
            
        }
        return NOB;
    }
    
    int[] FinalFunction(int[] orderArticleArray,int ATmin,int opPLUSmchine){
        int AT=AvailableTime(ATmin,opPLUSmchine);
        System.out.println("1");
        double GAraisiti=DBOF.getAllraisiti(orderArticleArray, AT);
        System.out.println("2-raisiti-"+GAraisiti);
        double AST=avarageSetupTime(orderArticleArray);
        System.out.println("3-ast-"+AST);
        double L=L(AST, GAraisiti);
        System.out.println("4-"+L);
        int[] BQ=batchQuantity(L, orderArticleArray);
        System.out.println("5");
        return BQ;
    
    }
    
}
