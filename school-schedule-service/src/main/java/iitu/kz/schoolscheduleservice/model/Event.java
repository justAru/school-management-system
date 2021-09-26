package iitu.kz.schoolscheduleservice.model;

import lombok.*;

import java.time.LocalDate;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Event {

    private Long subjectId;

    private String subjectName;

    private Long teacherId;

    private String teacherName;

    private String group; //class

    private LocalDate startDate;

    private LocalDate endDate;

}
