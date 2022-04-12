package gr.codehub.service;

import org.w3c.dom.Document;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class MyValidator {


    public static void main(String[] args)  {

        String filename = "xml_files/customer-ns.xml";
          System.out.println(validateWithDtd("xml_files/customer-dtd.xml"));

       System.out.println(validate("xml_files/customer-ns.xml","xml_files/customer-ns.xsd"));

    }


    public static boolean validateWithDtd(String filename)    {
        try {
            DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
            domFactory.setValidating(true);
            DocumentBuilder builder = domFactory.newDocumentBuilder();
            builder.setErrorHandler(new ErrorHandler() {
                @Override
                public void error(SAXParseException exception) throws SAXException {
                    // do something more useful in each of these handlers
                    System.out.println(exception);
                }

                @Override
                public void fatalError(SAXParseException exception) throws SAXException {
                    System.out.println(exception);
                }

                @Override
                public void warning(SAXParseException exception) throws SAXException {
                    System.out.println(exception);
                }
            });
            try {
                Document doc = builder.parse(filename);
            } catch (SAXException e) {
                System.out.println(e);
                return false;
            } catch (IOException e) {
                System.out.println(e);
                return false;
            }
        }
        catch(ParserConfigurationException b){
            return false;
        }
        return true;
    }



    private static boolean validate(String xmlFile, String schemaFile) {
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            Schema schema = schemaFactory.newSchema(new File( schemaFile));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File( xmlFile)));
            return true;
        } catch (SAXException | IOException e) {
            e.printStackTrace();
            return false;
        }
    }











}
