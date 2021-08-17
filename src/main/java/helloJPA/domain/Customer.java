package helloJPA.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Customer  {
    @Id @GeneratedValue //auto임
    private Long id;
    private String name;
    private String city;
    private String street;
    private String zipCode;
}
