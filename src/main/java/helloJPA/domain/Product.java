package helloJPA.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Setter
@Getter
public class Product {
    @Id
    @Column(name = "PRODUCT_ID")
    private Long id;
    private String names;
    private int price;
    private int stockQuantity;
}
