package ru.job4j.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class Maindog {
    public static void main(String[] args) throws Exception {
        final Dog dog = new Dog("Male dog", true, 2,
                new Temper("very bad"), new String[]{"Rex", "Andoo", "Jello"});
        JAXBContext context = JAXBContext.newInstance(Dog.class);
        Marshaller marshaller1 = context.createMarshaller();
        marshaller1.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller1.marshal(dog, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            Dog result = (Dog) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }
}
