package iitu.kz.schoolreportservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "report")
public class ReportDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String effectiveDate;

    private Long userId;

    private String userFullName;

    private String groupName;

    private Long subjectId;

    private String subjectName;

    private Double grade;
}
