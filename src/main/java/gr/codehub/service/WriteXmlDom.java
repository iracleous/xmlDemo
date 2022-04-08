package gr.codehub.service;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteXmlDom {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // root elements
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("company");
            doc.appendChild(rootElement);

            Element staffElement = doc.createElement("staff");
            rootElement.appendChild(staffElement);

            Element nameElement = doc.createElement("name");
            nameElement.setTextContent("Alexis");
            nameElement.setAttribute("code","45");
            staffElement.appendChild(nameElement);

            Element element2 = doc.createElement("staff");
            rootElement.appendChild(element2);

            //...create XML elements, and others...

            // write dom document to a file
            try (FileOutputStream output =  new FileOutputStream("xml_files/staff-dom.xml")) {
                writeXml(doc, output);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {

        }
    }

    // write doc to output stream
    private static void writeXml(Document doc,  OutputStream output)
            throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        // pretty print
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(output);
        transformer.transform(source, result);
    }
}