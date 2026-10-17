package com.back;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("== 명언 앱 ==");
        Scanner scan = new Scanner(System.in);
        String author;
        String tell;
        int index=1;
        while(true) {
            System.out.print("명령) ");
            String word = scan.nextLine().trim();
            if(word.equals("종료")) break;
            else if(word.equals("등록")){
                System.out.print("명언 : ");
                author = scan.nextLine().trim();
                System.out.print("작가 : ");
                tell = scan.nextLine().trim();
                System.out.printf("%d번 명언이 등록되었습니다.\n",index);
                index++;
            }
        }
    }
}
