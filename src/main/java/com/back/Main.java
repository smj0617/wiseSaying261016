package com.back;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("== 명언 앱 ==");
        int lastIndex =0;
        Scanner word = new Scanner(System.in);
        WiseSaying[] a = new WiseSaying[100];
        while (true) {
            System.out.print("명령) ");
            String text = word.nextLine().trim();
            if(text.equals("종료")) break;
            else if (text.equals("등록")){
                a[lastIndex] = new WiseSaying();
                a[lastIndex].num = lastIndex+1;
                System.out.print("명언 : ");
                a[lastIndex].message = word.nextLine().trim();
                System.out.print("작가 : ");
                a[lastIndex].author = word.nextLine().trim();
                lastIndex++;

            }
            else if(text.equals("목록")){
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                for (int i =lastIndex-1 ; i>=0;i--){
                    System.out.printf("%d / %s / %s\n",a[i].num,a[i].author,a[i].message);
                }
            }
        }
    }
}
