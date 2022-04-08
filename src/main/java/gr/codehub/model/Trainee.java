package gr.codehub.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.*;

import java.util.Arrays;

//@XmlRootElement(name = "ekpaideomenos")
//@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(propOrder={"age", "name"})
@XmlRootElement
@Data@AllArgsConstructor
@RequiredArgsConstructor
public class Trainee {
    
    @XmlElement
    @NonNull
    private String name;
    
//    @XmlAttribute
    @XmlElement
    @NonNull
    private int age;
    
    @XmlElementWrapper(name="hobbies")
    @XmlElement(name="hobby")

    private String[] hobbies = {"books", "movies"};



}


