package helloJPA.domain;

import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Setter
@Entity
@DiscriminatorValue("ANIMAL_BIRD")
public class Bird extends Animal{
    private int wings;
    private String home;
}
