package ecomProject;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type 1 for men's clothing and type 2 women's clothing: ");
        Integer gender = sc.nextInt();


        System.out.println("""
                Welcome to our Clothing Company👔
                Please Enter a Number
                1- Add a Clothes
                2-Display Clothes
                3-Update Clothes
                4-Remove Clothes 
                5-Exit 
                """);


    }
}
