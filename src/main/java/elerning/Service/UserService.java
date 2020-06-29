package elerning.Service;

import elerning.Model.User;
import elerning.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public interface UserService {

    public User findByLogin(String login);

    public User findByName(String name);

    public void saveUser(User user);
}
