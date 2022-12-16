package gr.codehub.service;

import gr.codehub.model.Book;
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
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WriteToXml {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException {


    //    Book[] books = { new Book (1,"RRRR"), new Book(2, "EEEE"), new Book(3, "FFFFF")};



       List<Book> books = readBooks("xml_files//books.txt");


        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        // root elements
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("books");
        doc.appendChild(rootElement);
        for(Book book : books){

            Element bookElement = doc.createElement("book");
            bookElement.setAttribute("id", book.getId()+"" );
            bookElement.setAttribute("name", book.getName() );

            Element idElement = doc.createElement("id");
            idElement.setTextContent(book.getId()+"");
            Element nameElement = doc.createElement("name");
            nameElement.setTextContent(book.getName());
            bookElement.appendChild(idElement);  bookElement.appendChild(nameElement);
            rootElement.appendChild(bookElement);
        }

        try (FileOutputStream output =  new FileOutputStream("xml_files/books.xml")) {
            writeXml(doc, output);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

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


    private static List<Book> readBooks(String filename){
            try ( Scanner fi = new Scanner(new File(filename))){
                List<Book> books = new ArrayList<>();
                while(fi.hasNext()){
                    String line = fi.nextLine();
                    String[]words = line.split(",");
                    Book book = new Book();
                    book.setId(   Integer.parseInt( words[0]));
                    book.setName( words[1]);
                    books.add(book);
                }
                return books;
             }
        catch(Exception e){

            return null;
        }
    }


}
