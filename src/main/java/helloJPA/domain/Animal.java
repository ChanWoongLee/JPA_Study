package helloJPA.domain;

import lombok.Setter;

import javax.persistence.*;

@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
public abstract class Animal {
    @Id @GeneratedValue
    @Column(name = "ANIMAL_ID")
    private Long id;
    private int age;
    private String name;

}
