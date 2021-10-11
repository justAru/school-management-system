package iitu.kz.schooladministrationservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import iitu.kz.schooldbstruct.model.Group;
import lombok.Data;

import javax.persistence.*;

@Data
public class UserDTO {

    private String firstName;
    private String lastName;
    private String password;
    private String address;
    private String roles;
    private String email;
    private Long groupId;
}
