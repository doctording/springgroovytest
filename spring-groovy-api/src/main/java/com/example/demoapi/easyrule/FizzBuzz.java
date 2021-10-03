package com.example.demoapi.easyrule;

/**
 * @Author mubi
 * @Date 2021/5/23 11:51
 */
public class FizzBuzz {
    public static void main(String[] args) {
        for (int i = 1; i <= 35; i++) {
            System.out.print(i + ":");
            if (((i % 5) == 0) && ((i % 7) == 0))
                System.out.print("fizzbuzz");
            else if ((i % 5) == 0) System.out.print("fizz");
            else if ((i % 7) == 0) System.out.print("buzz");
            else System.out.print(i);
            System.out.println();
        }
        System.out.println();
    }
}
