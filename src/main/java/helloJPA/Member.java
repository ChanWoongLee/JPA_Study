package helloJPA;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Member {
    @Id
    private Long id;
    private String name;
}
