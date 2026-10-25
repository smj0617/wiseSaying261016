package com.back;

public class WiseSaying {
    private String author;
    private String tell;
    private int num;
    public WiseSaying(String tell, String author, int id) {
        this.tell =tell;
        this.author=author;
        num=id;
    }

    public int getId() {
        return num;
    }

    public String getAuthor() {
        return author;
    }

    public String getTell() {
        return tell;
    }
}
