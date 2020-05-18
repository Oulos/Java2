package ru.hw2;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static String[][] stringToArray (String s)  {

        Scanner sc1 = new Scanner(s);
        String arr1[] = new String[4];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = sc1.nextLine();
        }
        sc1.close();
        String arr2[][] = new String[4][4];
        for (int i = 0; i < arr1.length; i++) {
            Scanner sc2 = new Scanner(arr1[i]);
            for (int j = 0; j < arr1.length; j++) {
                arr2[i][j] = sc2.next();
            }
        }
        return arr2;
    }

    private static int[][] arrayOfStringToArrayOfInteger (String[][] a) throws NumberFormatException {
        int[][] arr = new int[4][4];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                arr[i][j] = Integer.parseInt(a[i][j]);
            }
        }

        return arr;
    }

    private static int calculation (int[][] arr) throws ArrayStoreException {

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                sum = sum + arr[i][j];
            }
        }
        return sum / 2;

    }

    
    public static void main(String[] args) {
        String s = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";

        try {
            String[][] arrString = stringToArray(s);
            int[][] arrInteger = arrayOfStringToArrayOfInteger(arrString);
            System.out.println(calculation(arrInteger));
        } catch (NumberFormatException | ArrayStoreException e) {
            e.printStackTrace();
        }

    }




}
    

