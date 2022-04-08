package gr.codehub.service;

import java.io.File;
import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;

public class ValidateXSD {
    public static void main(String[] args) {
         
        File xsdFile = new File("xml_files/customers.xsd");
        File xmlFile = new File("xml_files/customers.xml");
              
        System.out.println("Validation Results: " + validateXMLSchema(xsdFile, xmlFile));  
        System.out.println("Validation Results: " + validateXMLSchema(new File("xml_files/customers_orders.xsd"), new File("xml_files/customers_orders.xml")));
    }

    public static boolean validateXMLSchema(File xsdFile, File xmlFile) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(xsdFile);
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xmlFile));
        } catch (IOException | IllegalArgumentException | SAXException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
