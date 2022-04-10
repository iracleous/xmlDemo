package gr.codehub.service;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UtilXmlProperties {


    public static void main(String[] args) {
        UtilXmlProperties util=  new UtilXmlProperties();
        System.out.println(util.xml2PropertiesFile("xml_files/staff-dom.xml", "xml_files/staff.properties"));
    }


    public boolean xml2PropertiesFile(String xmlFile, String propertiesFile) {

        Document doc;
        Properties prop = new Properties();
        try (FileInputStream input = new FileInputStream(xmlFile)) {
            // convert XML file to Document
            doc = parse(input);
        }
        catch (Exception e) {
            return false;
        }
        NodeList list = doc.getElementsByTagName("staff");

        for (int temp = 0; temp < list.getLength(); temp++) {
            Node node = list.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE) {

                Element element = (Element) node;
                // get staff's id
                String id = element.getAttribute("id");
                // get text

                String name="";
                if ( element.getElementsByTagName("name")
                        .item(0)!= null  )
                    name= element.getElementsByTagName("name")
                        .item(0).getTextContent();

                // write value to properties
                // prop does not guarantee on the order
                prop.setProperty("company.staff" + temp + ".id", id);
                prop.setProperty("company.staff" + temp + ".name", name);

            }

        }
        try (FileOutputStream output =
                     new FileOutputStream(propertiesFile)) {
            prop.store(output, "");
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    // get document
    private static Document parse(InputStream input)
            throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(input);
        return doc;
    }
}


