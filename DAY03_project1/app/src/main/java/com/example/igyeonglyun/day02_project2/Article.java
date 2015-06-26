package com.example.igyeonglyun.day02_project2;

/**
 * Created by igyeonglyun on 2015. 6. 26..
 */
public class Article {
    int articleNumber;
    String title;
    String writer;
    String id;
    String content;
    String writeDate;
    String imgName;

    public Article(int articleNumber, String title, String writer, String id, String content, String writeDate, String imgName) {
        this.articleNumber = articleNumber;
        this.content = content;
        this.id = id;
        this.imgName = imgName;
        this.title = title;
        this.writeDate = writeDate;
        this.writer = writer;
    }

    public int getArticleNumber() {
        return articleNumber;
    }

    public String getContent() {
        return content;
    }

    public String getId() {
        return id;
    }

    public String getImgName() {
        return imgName;
    }

    public String getTitle() {
        return title;
    }

    public String getWriteDate() {
        return writeDate;
    }

    public String getWriter() {
        return writer;
    }
}
