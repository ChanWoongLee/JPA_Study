package helloJPA.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class MemberDTO {
    private String userName;
    private int age;
}
