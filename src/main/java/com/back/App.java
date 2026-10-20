package com.back;

import java.util.Scanner;

public class App {
    WiseSaying[] a = new WiseSaying[100];
    Scanner sc = new Scanner(System.in);
    int index=1;
    void run() {
        System.out.println("== 명언 앱 ==");

        while(true){
            System.out.print("명령) ");
            String word = sc.nextLine().trim();
            if(word.equals("등록")){
                 writeList();
            } else if(word.equals("목록")){
                getList();
            } else if(word.equals("종료")) break;

        }
    }

    void writeList() {
         WiseSaying b = new WiseSaying();
         b.num=index;
         System.out.print("명언: ");
         b.tell = sc.nextLine().trim();
         System.out.print("작가: ");
         b.author = sc.nextLine().trim();
         System.out.printf("%d번 명언이 등록되었습니다.\n",index);
         a[index-1]=b;
         index++;
    }
    void getList(){
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        for(int i=index-1;i>0;i--){
            System.out.printf("%d / %s / %s\n",a[i-1].num,a[i-1].author,a[i-1].tell);
        }
    }
}
