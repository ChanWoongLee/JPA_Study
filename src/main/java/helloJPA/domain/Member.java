package helloJPA.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Member {
    @Id @GeneratedValue
    @Column(name = "USERNAME")
    private Long id;
    
    //외래키 매핑을 통한 연관간계 매핑
    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    private String userName;
}
