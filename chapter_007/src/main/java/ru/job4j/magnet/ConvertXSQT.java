package ru.job4j.magnet;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ConvertXSQT {
    private File source;
    private File dest;
    private File scheme;

    public ConvertXSQT(File source, File dest, File scheme) {
        this.source = source;
        this.dest = dest;
        this.scheme = scheme;
    }

    public void convert() {
        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer(new StreamSource(new FileInputStream(scheme)));
            transformer.transform(new StreamSource(new FileInputStream(source)), new StreamResult(new FileOutputStream(dest)));

        } catch (Exception exc) {
            throw new RuntimeException(exc);
        }
    }
}
