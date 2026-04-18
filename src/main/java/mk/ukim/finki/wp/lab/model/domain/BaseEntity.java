package mk.ukim.finki.wp.lab.model.domain;

import jakarta.persistence.*;
import lombok.Getter;


@MappedSuperclass
@Getter
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
