package iitu.kz.schoolscheduleservice.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "events")
public class EventDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subjectId;

    private String subjectName;

    private Long teacherId;

    private String teacherName;

    private String group; //class

    private LocalDate startDate;

    private LocalDate endDate;

}
