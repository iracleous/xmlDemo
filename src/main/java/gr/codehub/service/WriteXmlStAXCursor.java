package gr.codehub.service;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteXmlStAXCursor {

    public static void main(String[] args) throws XMLStreamException {
        // send the output to a xml file
        try(FileOutputStream out = new FileOutputStream("xml_files/test.xml")){
            writeXml(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // send the output to System.out
        // writeXml(System.out);
    }

    // StAX Cursor API
    private static void writeXml(OutputStream out) throws XMLStreamException {
        XMLOutputFactory output = XMLOutputFactory.newInstance();
        XMLStreamWriter writer = output.createXMLStreamWriter(out);

        writer.writeStartDocument("utf-8", "1.0");

        writer.writeCharacters("\n\t");
        // <company>
        writer.writeStartElement("company");

        // <staff>
        int staffId = 100;


        // add XML comment
        writer.writeComment("This is Staff " + staffId);
        writer.writeCharacters("\n\t\t");
        writer.writeStartElement("staff");
        writer.writeAttribute("id", staffId+"");
        writer.writeCharacters("\n\t\t");
        writer.writeStartElement("name");
        writer.writeCharacters("Dimitris");
        writer.writeEndElement();
        writer.writeCharacters("\n\t\t");
        writer.writeStartElement("salary");
        writer.writeAttribute("currency", "USD");
        writer.writeCharacters("5000");
        writer.writeEndElement();
        writer.writeCharacters("\n\t\t");
        writer.writeStartElement("bio");
        writer.writeCData("HTML tag <code>testing</code>");
        writer.writeCharacters("\n\t\t");
        writer.writeEndElement();
        writer.writeCharacters("\n\t\t");
        writer.writeEndElement();
        // </staff>

        // <staff>
        writer.writeCharacters("\n\t\t");
        writer.writeStartElement("staff");
        writer.writeAttribute("id", "1002");

        writer.writeCharacters("\n\t\t");
        writer.writeStartElement("name");
        writer.writeCharacters("Nickos");
        writer.writeEndElement();

        writer.writeCharacters("\n\t\t");
        writer.writeStartElement("salary");
        writer.writeAttribute("currency", "EUR");
        writer.writeCharacters("8000");
        writer.writeEndElement();

        writer.writeCharacters("\n\t\t");
        writer.writeStartElement("bio");
        writer.writeCData("a & b");
        writer.writeEndElement();

        writer.writeCharacters("\n\t\t");
        writer.writeEndElement();
        // </staff>

        writer.writeCharacters("\n");

        writer.writeEndDocument();
        // </company>

        writer.flush();
        writer.close();
    }
}