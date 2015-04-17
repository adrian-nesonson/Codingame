// Read inputs from System.in, Write outputs to System.out.
// Your class name has to be Solution

import java.util.*;
import java.io.*;
import java.math.*;

class Solution {

	// convert String to binary String
	public static String toBinary(String in) {
		byte[] bytes = in.getBytes();
        StringBuilder binary = new StringBuilder();
        for (byte b : bytes)
        {
             int val = b;
             boolean firstOne = false;
             for (int i = 0; i < 8; i++)
             {
                if( (val & 128) == 0 ) {
                    if( firstOne ) {
                        binary.append(0);
                    }
                } else {                    
                    binary.append(1);
                }
                if( !firstOne ) {
                        firstOne = true;
                }
                val <<= 1;
             }
        }
		return binary.toString();
	}

	// convert binary String to unary String
	public static String toUnary(String in) {		
		int tempIndex;
		int charNb = 0;
		int currentValue;
		String res = "";
    	for (int i = 0; i < in.length(); i++) {    	    
        	currentValue = (int)in.charAt(i);
            tempIndex = i+1;
            charNb = 1;
            while ((tempIndex < in.length()) && ((int)in.charAt(tempIndex) == currentValue )){
                charNb++;
                tempIndex++;
            }    		
    		if(in.charAt(i)=='0'){
    		    res += "00 ";
    		}else{
    		    res += "0 ";
    		}    		
    		for(int j=0;j<charNb;j++){
    		    res += "0";
    		    if(j>0){
    		        i++;
    		    }
    		}
    		res += " ";
    	}
		return res.substring(0,res.length()-1);
	}
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		System.out.println(toUnary(toBinary(in.nextLine())));
	}
}