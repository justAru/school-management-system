package iitu.kz.schooladministrationservice.controller;

import com.netflix.discovery.converters.Auto;
import iitu.kz.schooladministrationservice.model.UserDTO;
import iitu.kz.schooladministrationservice.repository.UserRepository;
import iitu.kz.schooladministrationservice.service.ProducerService;
import iitu.kz.schooladministrationservice.service.UserService;
import iitu.kz.schooldbstruct.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/admin/user")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProducerService producerService;

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> userList = userService.getAllUsers();
        return ResponseEntity.ok(userList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/addUser")
    public String addUser(@RequestBody UserDTO userDTO) {
        try {
            userService.addUser(userDTO);
            return "success";
        } catch (Exception e) {
            return "error : " + e;
        }
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user == null) {
            return "User not Found!";
        }
        userService.deleteUser(user);
        return "success";
    }

    @PostMapping("/sendNotification")
    public String sendNotification(@PathVariable Long id) {
        producerService.sendMessage(id);
        return "success";
    }

    }

