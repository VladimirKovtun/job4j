package ru.job4j.magnet;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Entities {
    private List<Entity> list;

    public Entities() {

    }

    public Entities(List<Entity> list) {
        this.list = list;
    }

    public List<Entity> getList() {
        return list;
    }

    public void setList(List<Entity> list) {
        this.list = list;
    }
}
