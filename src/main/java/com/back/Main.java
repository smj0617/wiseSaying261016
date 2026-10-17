package com.back;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("== 명언 앱 ==");
        Scanner scan = new Scanner(System.in);
        while(true) {
            System.out.print("명령) ");
            String word = scan.nextLine().trim();
            if(word.equals("종료")) break;
        }
    }
}
