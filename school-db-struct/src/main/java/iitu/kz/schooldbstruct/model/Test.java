package iitu.kz.schooldbstruct.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "_test")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "examiner_id")
    private Long examinerId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "examiner_id", insertable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User examiner;

    @Column(name = "subject_id")
    private Long subjectId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id", insertable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Subject subject;
}
