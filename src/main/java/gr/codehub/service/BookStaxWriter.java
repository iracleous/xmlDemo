package gr.codehub.service;

import gr.codehub.model.Book;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

public class BookStaxWriter {
    public static void main(String[] args) {
        String xmlFileOutput = "xml_files/book2.xml";
        String  textInputFile =  "xml_files/books.txt";

        try (FileOutputStream outXML = new FileOutputStream(xmlFileOutput))  {
            Scanner inputfile = new Scanner(new File(textInputFile));
            convertToXml(inputfile, outXML);
        }
        catch(Exception e){
        }
    }

    private static void  convertToXml(Scanner inputfile, FileOutputStream outXML) throws XMLStreamException {
        XMLOutputFactory output = XMLOutputFactory.newInstance();
        XMLStreamWriter writer = output.createXMLStreamWriter(outXML);
        writer.writeStartDocument("utf-8", "1.0");
        writer.writeCharacters("\n");
        // <books>
        writer.writeStartElement("books");
        // <book>
        while (inputfile.hasNext()){
            String line = inputfile.nextLine();
            Book book = getBook(line);
            writer.writeCharacters("\n\t");
            writer.writeStartElement("book");
            writer.writeCharacters("\n\t\t");
            writer.writeStartElement("id");
            writer.writeCharacters(book.getId()+"");
            writer.writeEndElement();
            writer.writeCharacters("\n\t\t");
            writer.writeStartElement("name");
            writer.writeCharacters(book.getName()+"");
            writer.writeEndElement();
            writer.writeCharacters("\n\t");
            writer.writeEndElement();
        }
        writer.writeCharacters("\n");
        writer.writeEndElement();
        writer.writeEndDocument();
    }

    private static Book getBook(String line){
        String[]words = line.split(",");
        Book book = new Book();
        book.setId(   Integer.parseInt( words[0]));
        book.setName( words[1]);
        return book;
    }



}
