package com.back;

public class WiseSaying {
    private String author;
    private String tell;
    private final int id;

    WiseSaying(String author, String tell, int id){
        this.author=author;
        this.tell=tell;
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTell() {
        return tell;
    }

    public void setTell(String tell) {
        this.tell=tell;
    }

    public void setAuthor(String author) {
        this.author=author;
    }
}
