package helloJPA.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Period {
    //기간 Period 만들어 놓으면 어디서 활용하지 않을까 ??
    private LocalDateTime startDate;

    private LocalDateTime endDate;


}
