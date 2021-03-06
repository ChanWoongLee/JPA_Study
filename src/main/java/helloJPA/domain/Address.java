package helloJPA.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Getter
@AllArgsConstructor // νμ !!
@NoArgsConstructor
@Embeddable
public class Address {
    // μ£Όμ
    private String name;
    private String city;
    private String street;
    private String zipCode;
}
