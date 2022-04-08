package ab;
import java.util.*;
public class ab {
    public static void main(String[] args) 
    { 
        char[] arr = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
        //System.out.println(arr);
        boolean breakit = false;
        String a ="ab10";
        char[] pw = new char[4];
        for (int i=0;i<36;i++){
        	if (breakit)
        		break;
        	pw[0]=arr[i];
        	for (int j=0;j<36;j++){
        		if(breakit)
        			break;
        		pw[1]=arr[j];
        		for (int k=0;k<36;k++){
        			if(breakit)
        				break;
        			pw[2]=arr[k];
        			for (int l=0;l<36;l++){
        				pw[3]=arr[l];
        				String x = String.copyValueOf(pw);
        				if(a.equals(x)){
        					System.out.println("Matched");
        					System.out.println(x);
        					breakit=true;
        					break;
        				}
        			}
        		}
        	}
        }
    } 
} 

	
	

