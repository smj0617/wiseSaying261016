package com.back;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("== 명언 앱 ==");
        Scanner scan = new Scanner(System.in);
        WiseSaying[] a = new WiseSaying[100]; //배열 100개
        int index=1;
        while(true) {
            System.out.print("명령) ");
            String word = scan.nextLine().trim();
            if(word.equals("종료")) break;
            else if(word.equals("등록")){
                WiseSaying b = new WiseSaying();
                b.num=index;
                System.out.print("명언 : ");
                b.tell = scan.nextLine().trim();
                System.out.print("작가 : ");
                b.author = scan.nextLine().trim();
                System.out.printf("%d번 명언이 등록되었습니다.\n",index);
                a[index-1]=b;
                index++;
            } else if (word.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                for (int i=index-1; i>0; i-- ){
                    System.out.printf("%d / %s / %s\n", a[i-1].num,a[i-1].author,a[i-1].tell);
                }
            }
        }
    }
}
