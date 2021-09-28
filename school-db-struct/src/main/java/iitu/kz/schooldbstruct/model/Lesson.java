package iitu.kz.schooldbstruct.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "_lesson")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id", insertable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Subject subject;

    @Column(name = "startDate")
    private Timestamp startDate;

    @Column(name = "endDate")
    private Timestamp endDate;

    @Column(name = "group_id")
    private Long groupId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id", insertable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Group group;

    @Column(name = "TEACHER_ID")
    private Long teacherId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEACHER_ID", insertable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User teacher;

}
