package ru.job4j.magnet;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.List;

public class StoreXml {
    private final File target;

    public StoreXml(File target) {
        this.target = target;
    }

    public void save(List<Entity> list) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Entities.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(new Entities(list), target);
        } catch (Exception exc) {
            throw new RuntimeException(exc);
        }
    }
}
