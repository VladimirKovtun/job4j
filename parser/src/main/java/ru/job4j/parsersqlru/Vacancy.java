package ru.job4j.parsersqlru;

import java.time.LocalDateTime;
import java.util.Objects;

public class Vacancy {
    private int id;
    private String title;
    private String message;
    private String link;
    private LocalDateTime createTime;

    public Vacancy() {

    }

    public Vacancy(String title, String message, String link, LocalDateTime createTime) {
        this.title = title;
        this.message = message;
        this.link = link;
        this.createTime = createTime;
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vacancy vacancy = (Vacancy) o;
        return id == vacancy.id
                && Objects.equals(title, vacancy.title)
                && Objects.equals(message, vacancy.message)
                && Objects.equals(link, vacancy.link)
                && Objects.equals(createTime, vacancy.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, message, link, createTime);
    }

    @Override
    public String toString() {
        return "Vacancy{"
                + "id=" + id
                + ", title='" + title + '\''
                + ", message='" + message + '\''
                + ", link='" + link + '\''
                + ", createTime=" + createTime
                + '}';
    }
}
