package com.example.study.Service;

import com.example.study.entity.User;
import com.example.study.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public String createUser(@RequestBody User user) {
        userRepository.save(user);
        return String.format("사용자 %s 저장 완료!", user.getName());
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("해당 ID의 사용자가 없습니다."));
    }

    public String updateUser(@RequestParam Long id, @RequestBody User user) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            existingUser.setName(user.getName());
            existingUser.setAge(user.getAge());
            userRepository.save(existingUser);
            return "사용자 정보가 수정되었습니다.";
        } else {
            throw new IllegalArgumentException("해당 ID의 사용자가 없습니다.");
        }
    }

    public String deleteUser(@PathVariable Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            userRepository.deleteById(id);
            return "사용자가 삭제되었습니다.";
        } else {
            throw new IllegalArgumentException("해당 ID의 사용자가 없습니다.");
        }
    }
}
