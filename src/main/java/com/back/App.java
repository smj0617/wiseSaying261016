package com.back;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class App {

    private static List<WiseSaying> wiseSayings = new ArrayList<>();
    private static Scanner sc= new Scanner(System.in);
    private int id=0;

    public void run() {
        System.out.println("== 명언 앱 ==");
        while(true){
            System.out.println("명령) ");
            String order = sc.nextLine().trim();
            if(order.equals("종료")) break;
            else if(order.equals("등록")){
                actionWrite();
            }
            else if(order.equals("목록")){
                actionList();
            }
            else if(order.startsWith("삭제")){
                actionDelete(order);
            }
            else if(order.startsWith("수정")){
                actionModify(order);
            }
        }
    }

    private void actionModify(String order) {
        String[] temps= order.split("=",2);
        if(temps.length != 2 || temps[1].isBlank()){
            System.out.println("id를 입력하십시오.");
            return;
        }
        int id= Integer.parseInt(temps[1]);
        WiseSaying modifySaying= findById(id);
        if (modifySaying ==null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.",id);
            return;
        }
        System.out.printf("명언(기존) : %s\n 명언 : ",modifySaying.getSentence());
        String sentence = sc.nextLine().trim();
        System.out.printf("작가(기존) : %s\n 작가 : ",modifySaying.getAuthor());
        String author = sc.nextLine().trim();
        modify(modifySaying,sentence,author);
    }

    private void modify(WiseSaying modifySaying, String sentence, String author) {
        modifySaying.setStence(sentence);
        modifySaying.setAuthor(author);
    }

    private WiseSaying findById(int id) {
        return wiseSayings
                .stream()
                .filter( e-> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    private void actionDelete(String order) {
        String[] temps =order.split("=",2);
        if( temps.length != 2 || temps[1].isBlank()) {
            System.out.println("id를 입력하십시오.");
            return;
        }
        int id= Integer.parseInt(temps[1]);
        int deleteIndex= delete(id);
        if (deleteIndex == -1) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n",id);
            return;
        }
        System.out.printf("%d번 명언이 삭제되었습니다.\n",id);

    }

    private int delete(int id) {
        int deleteIndex=findForIndexById(id);
        if(deleteIndex== -1) return -1;
        wiseSayings.remove(deleteIndex);
        return deleteIndex;
    }

    private int findForIndexById(int id) {
        return IntStream.range(0,wiseSayings.size())
                .filter(e-> wiseSayings.get(e).getId() == id)
                .findFirst()
                .orElse(-1);

    }

    private void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        List<WiseSaying> sayingList = findForList();
        for(int i=0; i<sayingList.size(); i++){
            System.out.printf("%d / %s / %s\n",sayingList.get(i).getId(),sayingList.get(i).getAuthor(),sayingList.get(i).getSentence());
        }
    }

    private List<WiseSaying> findForList() {
        return wiseSayings.reversed();
    }

    private void actionWrite() {
        System.out.print("명언 : ");
        String sentence = sc.nextLine().trim();
        System.out.print("작가 : ");
        String author = sc.nextLine().trim();

        WiseSaying wiseSaying = write(sentence,author);
        System.out.printf("%d번 명언이 등록되었습니다.\n",wiseSaying.getId());
    }

    private WiseSaying write(String sentence, String author) {
        WiseSaying wiseSaying = new WiseSaying(++id,sentence,author);
        wiseSayings.add(wiseSaying);
        return wiseSaying;
    }
}
