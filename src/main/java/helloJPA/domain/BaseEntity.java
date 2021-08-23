package helloJPA.domain;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

// 공통적으로 쓰이는 속성들에 대해서는 아래와 같은 메소드 추가해서 엔티티에 사용ㄱ능
@MappedSuperclass
public abstract class BaseEntity {
    public String createdBy;
    public LocalDateTime createdDate;
}
