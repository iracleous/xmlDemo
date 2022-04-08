package gr.codehub.service;

import java.io.StringWriter;

import gr.codehub.model.Trainee;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import java.io.File;

public class Marshalling {

    public static void main(String[] args) throws JAXBException {

        marshalling();
        unmarshalling();
    }

    public static void marshalling() throws JAXBException {
        // the environment - JAXB entry point
        JAXBContext context = JAXBContext.newInstance(Trainee.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); //pretty print XML

        // to screen
        marshaller.marshal(new Trainee("Nik", 20), System.out);

        // to string
        StringWriter traineeXml = new StringWriter();
        marshaller.marshal(new Trainee("Nik", 20), traineeXml);
        System.out.println(traineeXml);
        
        // to file
        marshaller.marshal(new Trainee("Maria", 20), new File("traineeXml.xml"));
        
    }

    private static void unmarshalling() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Trainee.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Trainee trainee = (Trainee)unmarshaller.unmarshal(new File("traineeXml.xml"));
        System.out.println(trainee); 
    }
}
