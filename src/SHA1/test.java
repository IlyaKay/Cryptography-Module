/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SHA1;

import java.util.*;
import java.security.*;
public class test
{  
    public static void main(String[] args) {
  	int i = 2;
        System.out.println(sqrtMod11(i));
        
    }
    
    public static int sqrtMod11(int x) { 
            switch(x) {
                case 1:
                    return 1;
                case 3:
                    return 5;
                case 4:
                    return 2;
                case 5:
                    return 4;
                case 9:
                    return 3;
            }
            return -1;
        }
}