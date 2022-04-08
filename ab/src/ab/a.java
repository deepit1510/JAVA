package ab;
import java.io.File;
import java.io.IOException;
import java.security.Key;
import javax.crypto.*;
import java.util.Scanner;
import com.lowagie.text.pdf.PdfReader;

public class a {
    public static void main(String[] args) 
    { 
    	PdfReader pdfreader = null;
    	int pages=0;
       //System.out.println(arr);
    	char[] arr = null;
        boolean breakit = false;
        //System.out.println("Please enter the password(length 4)");
        Scanner input = new Scanner(System.in);
       // String a =input.next();
        long strtTime = System.currentTimeMillis();
     
    	  arr = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*".toCharArray();
    	  System.out.println("alphanumric and special characters");
      
        char[] pw = new char[4];
        for (int i=0;i<arr.length;i++){
        	if (breakit)
        		break;
        	pw[0]=arr[i];
        	for (int j=0;j<arr.length;j++){
        		if(breakit)
        			break;
        		pw[1]=arr[j];
        		for (int k=0;k<arr.length;k++){
        			if(breakit)
        				break;
        			pw[2]=arr[k];
        			for (int l=0;l<arr.length;l++){
        				pw[3]=arr[l];
        				
        				String x = String.copyValueOf(pw);
        				File file = new File("C:/Users/deepi/Downloads/F15H_2021020365_1278715_3.pdf");
        				//new PdfReader;
        				
        				if(pages>0){
        					System.out.println("Matched");
        					System.out.println(x);
        					breakit=true;
        					long endTime = System.currentTimeMillis();
        					System.out.println("TimeSpent = " + (endTime-strtTime) + " ms");
        					break;
        				}
        				//pdf = PDF.open("C:/Users/deepi/Downloads/F15H_2021020365_1278715_3.pdf", x.getBytes());
        				/*if(a.equals(x)){
        					System.out.println("Matched");
        					System.out.println(x);
        					breakit=true;
        					long endTime = System.currentTimeMillis();
        					System.out.println("TimeSpent = " + (endTime-strtTime) + " ms");
        					break;
        				}*/
        			}
        		}
        	}
        }
    } 
    } 

	
	

