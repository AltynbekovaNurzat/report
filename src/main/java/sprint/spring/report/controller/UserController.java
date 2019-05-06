package sprint.spring.report.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import sprint.spring.report.entity.User;
//import sprint.spring.report.factory.Factory;
import sprint.spring.report.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/sprint/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("registration")
    public ResponseEntity<String> addUser(@RequestBody User user, UriComponentsBuilder builder){
        User u = userService.addUser(user);
        System.out.println(u.getId());
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/sprint/user/{id}").buildAndExpand(u.getId()).toUri());
        return new ResponseEntity<>("new User is saved",headers, HttpStatus.OK);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Object> getUserById(@PathVariable Integer userId){
        return  userService.getUserById(userId);
    }

    @PutMapping
    public ResponseEntity<String> updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer userId){
        return userService.deleteUser(userId);
    }

    @GetMapping("/search")
    ResponseEntity<List<User>> getUserByFio(@RequestHeader(required = false) String fio){
        if (fio!=null){
            return userService.getUserByFio(fio);
        }
        return userService.getAllUsers();
    }
}
