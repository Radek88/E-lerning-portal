package elerning.Service.User;

import elerning.Model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    public User findByLogin(String login);

    public User findByName(String name);

    boolean registerNewUser(User user);
}
