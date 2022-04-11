package gr.codehub.service;

import org.w3c.dom.Document;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class MyValidator {


    public static void main(String[] args) throws   ParserConfigurationException {
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
            Document doc = builder.parse("xml_files/customer-ns.xml");
        } catch (SAXException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
