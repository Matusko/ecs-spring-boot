package sk.matusko.ecs.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InvalidState {

    LocalDateTime time = LocalDateTime.now();
    private String message;
    private String uid;
    private BigInteger code;

}
