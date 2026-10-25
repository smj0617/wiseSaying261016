package com.back;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private Scanner sc= new Scanner(System.in);
    private int id=0;
    private List<WiseSaying> WiseSayings= new ArrayList<>();

    public void run() {
        System.out.println("== 명언 앱 ==");
        while(true){
            System.out.print("명령) ");
            String word=sc.nextLine().trim();
            if(word.equals("종료")) break;
            else if(word.equals("등록")){
                actionWrite();
            }
            else if(word.equals("목록")){
                actionList();
            }
            else if(word.startsWith("삭제")){
                actionDelete(word);
            }
            else if(word.startsWith("수정")){
                actionModify(word);
            }
        }
    }

    private void actionModify(String word) {
        String[] temps= word.split("=",2);
        if(temps.length !=2 || temps[1].isBlank()) {
            System.out.println("id를 입력해주세요");
            return;
        }
        int id= Integer.parseInt(temps[1]);
        WiseSaying wiseSaying = findById(id);
        if (wiseSaying==null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n",id);
            return;
        }
        System.out.printf("명언(기존) : %s\n명언 :",wiseSaying.getTell());
        String tell = sc.nextLine().trim();
        System.out.printf("작가(기존) : %s\n작가",wiseSaying.getAuthor());
        String author = sc.nextLine().trim();

        modify(wiseSaying,author,tell);
    }

    private void modify(WiseSaying wiseSaying, String author, String tell) {
        wiseSaying.setAuthor(author);
        wiseSaying.setTell(tell);
    }

    private WiseSaying findById(int id) {
        int index = findForIndexById(id);
        if( index ==-1)return null;
        return WiseSayings.get(index);
    }


    private void actionDelete(String word) {
        String[] temps= word.split("=",2);
        if(temps.length !=2 || temps[1].isBlank()) {
            System.out.println("id를 입력해주세요.");
            return;
        }
        int id= Integer.parseInt(temps[1]);
        int deleteIndex = delete(id);
        if (deleteIndex==-1) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n",id);
            return;
        }

        System.out.printf("%d번 명언이 삭제 되었습니다.\n",id);


    }

    private int delete(int id) {
        int deleteIndex = findForIndexById(id);
        if (deleteIndex == -1) return -1;
        WiseSayings.remove(deleteIndex);
        return deleteIndex;
    }

    private int findForIndexById(int id) {
        for(int i=0;i<WiseSayings.size();i++){
            if(WiseSayings.get(i).getId()==id) return i;
        }
        return -1;
    }

    private void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        List<WiseSaying> list = findForList();
        for(int i=0; i<list.size();i++){
            System.out.printf("%d / %s / %s\n",list.get(i).getId(),list.get(i).getAuthor(),list.get(i).getTell());
        }
    }

    private List<WiseSaying> findForList() {
        return WiseSayings.reversed();
    }

    private void actionWrite() {
        System.out.print("명언 : ");
        String tell= sc.nextLine().trim();
        System.out.print("작가 : ");
        String author= sc.nextLine().trim();
        WiseSaying writingWiseSaying = write(author,tell);
        WiseSayings.add(writingWiseSaying);
    }

    private WiseSaying write(String author, String tell) {
        WiseSaying newWise = new WiseSaying(author,tell,++id);
        return newWise;
    }
}
