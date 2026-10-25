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
            else if (word.startsWith("삭제")){
                actionDelete(word);
            }
            else if (word.startsWith("수정")){
                actionModify(word);
            }
                    
        }
        
    }

    private void actionModify(String word) {
        String[] temps=word.split("=",2);
        if(temps.length !=2 || temps[1].isBlank()){
            System.out.println("id를 입력해주세요.");
            return;
        }
        int id= Integer.parseInt(temps[1]);
        int ModfyIndex=modify(id);
        if(ModfyIndex==-1){
            System.out.printf("%d번 명언은 존재하지 않습니다.\n",id);
            return;
        }
        System.out.printf("%d번 명언이 삭제되었습니다.\n",id);
    }

    private int modify(int id) {
       int ModifyIndex= findForListById(id);
       if(ModifyIndex==-1) return ModifyIndex;
       WiseSaying selectedWiseSaying = a.get(ModifyIndex);
       System.out.printf("명언(기존) : %s\n명언 :",selectedWiseSaying.getTell());
       selectedWiseSaying.setTell(sc.nextLine().trim());
       System.out.printf("작가(기존) : %s\n작가 :",selectedWiseSaying.getAuthor());
       selectedWiseSaying.setAuthor(sc.nextLine().trim());
       return ModifyIndex;
    }

    private void actionDelete(String word) {
        String[] temps=word.split("=",2);
        if(temps.length !=2 || temps[1].isBlank()){
            System.out.println("id를 입력해주세요.");
            return;
        }
        int id= Integer.parseInt(temps[1]);
        int deleteIndex=delete(id);
        if(deleteIndex==-1){
            System.out.printf("%d번 명언은 존재하지 않습니다.\n",id);
            return;
        }
        System.out.printf("%d번 명언이 삭제되었습니다.\n",id);
    }

    private int delete(int id) {
        int deleteIndex= findForListById(id);
        if (deleteIndex==-1) return -1;
        a.remove(deleteIndex);
        return deleteIndex;
    }

    private int findForListById(int id) {
        for(int i=0; i< a.size(); i++) {
            if(a.get(i).getId()==id) return i;
        }
        return -1;

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
