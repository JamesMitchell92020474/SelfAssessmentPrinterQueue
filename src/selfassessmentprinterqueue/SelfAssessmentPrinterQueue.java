/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selfassessmentprinterqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @title SelfAssessmentPrinterQueue.java
 * @author James Mitchell 92020474
 * @date 3/09/19
 * 
 */
public class SelfAssessmentPrinterQueue {

    public static Queue<String> printerQueue = new LinkedList();
    public static Scanner in = new Scanner(System.in);
    public static String jobAdded;
    public static int queueNumber = 0;
    
    public static void main(String[] args) {
        addPrintJobs();
        Timer timer = new Timer();
        //timed event - print a document every 10 seconds
        timer.schedule(new PrintingTask(), 0, 10000);
    }
    
    //loop telling the number of iterations
    public static void addPrintJobs(){
        for (int i=1; i<6; i++){
            printerQueue.add("document " + i);
        }
    }
    
    //inner class to describe the task of printing the documents
    public static class PrintingTask extends TimerTask{
        
        public void run() {
              
            if (printerQueue.size() == 1){
                System.out.println("Now printing " + printerQueue.poll() + ".");
                System.out.println("There are no more documents in the print queue.\n");
            }
            
            else if (printerQueue.isEmpty()){
                System.out.println("Printing complete.\n");
                System.exit(0);
            }
            
            else {
                    System.out.println("Now printing " + printerQueue.poll() + ".");
                    System.out.println("The following jobs are in the print queue: " + printerQueue.toString() + "\n");
            }
        }
    }
    
}
