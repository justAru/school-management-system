package iitu.kz.schooladministrationservice.service.impl;

import iitu.kz.schooladministrationservice.model.UserDTO;
import iitu.kz.schooladministrationservice.repository.GroupRepository;
import iitu.kz.schooladministrationservice.repository.UserRepository;
import iitu.kz.schooladministrationservice.service.UserService;
import iitu.kz.schooldbstruct.model.Group;
import iitu.kz.schooldbstruct.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Inject
    private UserRepository userRepository;
    @Autowired
    private GroupRepository groupRepository;

    @Override
    public List<User> getAllUsers() {
        List<User> userList = userRepository.findAll();
        return userList;
    }

    @Override
    public User getUserById(Long id) {
        User user = userRepository.getById(id);
        return user;
    }

    @Override
    public void addUser(UserDTO userDTO) {
        Group group = groupRepository.getById(userDTO.getGroupId());

        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setAddress(userDTO.getAddress());
        user.setEmail(user.getEmail());
        user.setPassword(user.getPassword());
        user.setGroup(group);

        userRepository.save(user);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }
}
