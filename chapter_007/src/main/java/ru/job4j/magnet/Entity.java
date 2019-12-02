package ru.job4j.magnet;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Entity {
    private int field;

    public Entity() {

    }

    public Entity(int field) {
        this.field = field;
    }

    public int getField() {
        return field;
    }

    @XmlElement(name = "field")
    public void setField(int field) {
        this.field = field;
    }
}
