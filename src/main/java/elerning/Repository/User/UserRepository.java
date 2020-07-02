package elerning.Repository.User;


import elerning.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query("select u from User u where u.id=?1")


    User getData(int id);

    User findByLogin(String login);

    User findByName(String name);

    User findBySurname(String surname);

    User findByEmail(String email);



}
