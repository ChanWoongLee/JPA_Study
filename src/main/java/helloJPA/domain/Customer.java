package helloJPA.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
public class Customer  {

    @Id @GeneratedValue //auto임
    @Column(name = "MEMBER_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Order> orders = new ArrayList<>();

    @Embedded
    private Period period;

    @Embedded
    private Address address;

//    //기간 위와같이 Period 만들어 놓으면 어디서 활용하지 않을까 ??
//    private LocalDateTime startDate;
//    private LocalDateTime endDate;
//
//    // 주소
//    private String name;
//    private String city;
//    private String street;
//    private String zipCode;

}
