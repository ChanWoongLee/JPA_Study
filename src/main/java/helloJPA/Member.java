package helloJPA;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@SequenceGenerator(name  = "sequence", sequenceName = "memSeq",initialValue =1, allocationSize = 1)
// 이런식을 시퀀스를 만들고 sequence 전략에서 선택할수 있다.
public class Member {
    // 기본키 맵핑
    // 집적할당 @Id
    // 간접할당 @GeneratedValue : strategy = Generation.Identity(데이터베이스에 위임),Auto,Sequence(오라클 시퀀스느낌),Table (키생성 전용 테이블 시퀀스 흉내)
    @Id @GeneratedValue()
    private Long id;

    @Column(name = "name") // db 에는 name으로 써진다!
    private String userName;

    private Integer age;

    @Enumerated(EnumType.STRING) // 기본 ordinal은 숫자가 들어가니까 사용하지말자
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP) // localdate, locladateTime 은 자동으로 해준다.
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob
    private String description;

    @Transient // db에 저장하지 않겠다.
    private int temp;

}
