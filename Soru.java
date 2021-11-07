/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soru;

import java.util.ArrayList;
import java.util.Arrays;


public class Soru {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
    }
   
    
    public static int solve(int[] array) {
        int max_water = 0;
       
        int secondMaxLength = -1;
        int secondMaxIndex = -1;
        int firstLength = array[0];
        int firstIndex = 0;
        int temp = -1;
        
        A :while(true) {
            
            if(secondMaxIndex == array.length - 1 || firstIndex == array.length - 1)  {
                break A;
            }
            
            for(int i = 1; i < array.length; i++) {
                if(secondMaxLength < array[i]){
                    secondMaxLength = array[i];
                    secondMaxIndex = i;
                }
            }
            max_water += Math.min(firstLength, secondMaxLength) * (secondMaxIndex - firstIndex-1);
            int tempNum = 0;
            for(int i = firstIndex+1; i < secondMaxIndex ; i++) {
                tempNum += array[i];
            }
            max_water -= tempNum;
            firstLength = secondMaxLength;
            firstIndex = secondMaxIndex;
            secondMaxIndex = -1;
            secondMaxLength = -1;
            
            
            B :while(secondMaxIndex != array.length -1) {
                for(int i = firstIndex; i < array.length; i++) {
                if(-1 < array[i]){
                    secondMaxLength = array[i];
                    secondMaxIndex = i;
                }
            }
            max_water += Math.min(firstLength, secondMaxLength) * (secondMaxIndex - firstIndex-1);
            int tempNum1 = 0;
            for(int i = firstIndex+1; i < secondMaxIndex ; i++) {
                tempNum1 += array[i];
            }
            max_water -= tempNum1;
            firstLength = secondMaxLength;
            firstIndex = secondMaxIndex;
            secondMaxIndex = -1;
            secondMaxLength = -1;
            
                if(firstIndex == array.length - 1) {
                    break B;
                }
            }
            
            
            
        }
        
        
        return max_water;
    }
    
}
