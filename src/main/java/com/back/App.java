package com.back;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private static Scanner sc= new Scanner(System.in);
    private int id;
    private List<WiseSaying> a = new ArrayList<>();
    public void run() {
        System.out.println("== 명언 앱 ==");
        while(true){
            System.out.print("명령) ");
            String word = sc.nextLine().trim();
            if (word.equals("종료")) break;
            else if (word.equals("등록")){
                actionWrite();
            }
            else if (word.equals("목록")){
                actionList();
            }
            else if (word.equals("삭제")){
                actionDelete(id);
            }
            else if (word.equals("수정")){
                actionModify(id);
            }
                    
        }
        
    }

    private void actionModify(int id) {
    }

    private void actionDelete(int id) {

    }

    private void actionList() {
        
    }

    private void actionWrite() {
        System.out.print("명언 : ");
        String tell = sc.nextLine().trim();
        System.out.print("작가 : ");
        String author = sc.nextLine().trim();
        WiseSaying b = new WiseSaying(tell, author);
        a.add(b);

    }
}
