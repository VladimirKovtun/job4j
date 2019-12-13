package ru.job4j;

import java.time.LocalDateTime;

public class Vacancy {
    private int id;
    private String title;
    private String message;
    private String link;
    private LocalDateTime createTime;

    public Vacancy() {

    }

    public Vacancy(int id, String title, String message, String link, LocalDateTime createTime) {
        this.id = id;
        this.title = title;
        this.message = message;
        this.link = link;
        this.createTime = createTime;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Vacancy{"
                + "id='" + id + '\''
                + "title='" + title + '\''
                + ", message='" + message + '\''
                + ", link='" + link + '\''
                + ", createTime='" + createTime + '\''
                + '}';
    }
}
