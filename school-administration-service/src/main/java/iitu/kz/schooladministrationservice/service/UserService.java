package iitu.kz.schooladministrationservice.service;

import iitu.kz.schooladministrationservice.model.UserDTO;
import iitu.kz.schooldbstruct.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(Long id);

    void addUser(UserDTO userDTO);

    void deleteUser(User user);

}
