package com.back;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private static Scanner sc= new Scanner(System.in);
    private int lastId=0;
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
                actionDelete(word);
            }
            else if (word.equals("수정")){
                actionModify(word);
            }
                    
        }
        
    }

    private void actionModify(String id) {
    }

    private void actionDelete(String id) {

    }

    private void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        List <WiseSaying> findForWiseSayings= findForList();
        for(WiseSaying WiseSaying : findForWiseSayings){
            System.out.printf("%d / %s / %s\n",WiseSaying.getId(),WiseSaying.getAuthor(),WiseSaying.getTell());
        }
    }

    private List<WiseSaying> findForList() {
        return a.reversed();
    }

    private void actionWrite() {
        System.out.print("명언 : ");
        String tell = sc.nextLine().trim();
        System.out.print("작가 : ");
        String author = sc.nextLine().trim();
        WiseSaying b = write(tell, author);
        System.out.printf("%d번 명언이 등록되었습니다.\n",b.getId());


    }
    private WiseSaying write(String tell,String author){
       WiseSaying wiseSaying = new WiseSaying(tell,author,++lastId);
       a.add(wiseSaying);
       return wiseSaying;
    }
}
