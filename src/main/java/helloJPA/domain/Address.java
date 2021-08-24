package helloJPA.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Getter
@AllArgsConstructor // 필수 !!
@NoArgsConstructor
@Embeddable
public class Address {
    // 주소
    private String name;
    private String city;
    private String street;
    private String zipCode;
}
