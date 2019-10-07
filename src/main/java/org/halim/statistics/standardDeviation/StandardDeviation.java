/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.halim.statistics.standardDeviation;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author ABDELHALIM
 */
public class StandardDeviation {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine().trim());
        String[] lineValues = scanner.nextLine().split(" ");
        int[] numbers = convertStringIntoInteger(size, lineValues);
        
        double mean = calculateMean(size, numbers);
        System.out.println(calculateStandardDeviation(size, mean, numbers));
    }

    private static int[] convertStringIntoInteger(int size, String[] array) {
        int[] temp = new int[size];
        for (int i = 0; i < size; i++) {
            temp[i] = Integer.parseInt(array[i]);
        }
        return temp;
    }

    private static double calculateMean(int size, int[] numbers) {
        double summation = 0.0;
        for (int number : numbers) {
            summation += number;
        }
        return summation / size;
    }
    
    private static double calculateStandardDeviation(int size, double mean, int[] numbers){
        double standardDeviation =0.0;
        DecimalFormat df = new DecimalFormat(".#");
        for(int number : numbers){
            standardDeviation += Math.pow((number - mean), 2);
        }
        standardDeviation /= size;
        
        return Double.parseDouble(df.format(Math.sqrt(standardDeviation)));
    }
}
