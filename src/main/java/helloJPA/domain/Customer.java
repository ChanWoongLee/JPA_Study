package helloJPA.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
public class Customer  {

    @Id @GeneratedValue //auto임
    @Column(name = "MEMBER_ID")
    private Long id;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders = new ArrayList<>();

    private String name;

    private String city;

    private String street;

    private String zipCode;

}
