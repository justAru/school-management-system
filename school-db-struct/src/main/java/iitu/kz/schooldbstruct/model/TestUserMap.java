package iitu.kz.schooldbstruct.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "_test_user_map")
public class TestUserMap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long studentId;

    @Column
    private Long testId;

    @Column
    private Double score;
}
