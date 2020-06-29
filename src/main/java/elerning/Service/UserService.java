package elerning.Service;

import elerning.Model.User;
import elerning.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    public User findByLogin(String login);

    public User findByName(String name);

    boolean registerNewUser(User user);
}
