package sprint.spring.report.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sprint.spring.report.entity.User;
import sprint.spring.report.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity<String> addUser(User user) {
        userRepository.save(user);
        return new ResponseEntity<>("User is saved", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> userList = userRepository.findAll();
        return new ResponseEntity<>(userList,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> getUserById(Integer userId) {
        for(User u: userRepository.findAll()){
            if(u.getId().equals(userId)){
                return new ResponseEntity<>(userRepository.getOne(userId),HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("User with id " + userId + " does not exist",HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<String> updateUser(User user) {
        for(User u: userRepository.findAll()){
            if(u.getId().equals(user.getId())){
                u.setFio(user.getFio());
                u.setLogin(user.getLogin());
                u.setPassword(user.getPassword());
                u.setEmail(user.getEmail());
                userRepository.save(u);
                return new ResponseEntity<>("User is updated",HttpStatus.OK);
            }
        }
        return  new ResponseEntity<>("User with id " + user.getId() + " does not exist", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<String> deleteUser(Integer userId) {
        for(User u: userRepository.findAll()){
            if(u.getId().equals(userId)){
                userRepository.delete(u);
                return new ResponseEntity<>("User is removed",HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("User with id " + userId + " does not exist",HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<List<User>> getUserByFio(String fio) {
        List<User> userList = userRepository.getUserByFio(fio.toLowerCase());
        return new ResponseEntity<>(userList,HttpStatus.OK);
    }

}
