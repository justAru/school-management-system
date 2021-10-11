package iitu.kz.schoolreportservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Report {

    private String effectiveDate;

    private Long userId;

    private String userFullName;

    private String groupName;

    private Long subjectId;

    private String subjectName;

    private Double grade;
}
