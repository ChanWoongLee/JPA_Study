package helloJPA;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    @Id
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
