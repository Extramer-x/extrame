package top.extrame.service;

import org.springframework.stereotype.Service;
import top.extrame.test.User;

/**
 * The type UserService.
 *
 * @author Jx-zou
 */
@Service
public class UserService {

    public User getUser() {
        User user = new User();
        user.setAge(10);
        user.setName("123");
        return user;
    }
}
