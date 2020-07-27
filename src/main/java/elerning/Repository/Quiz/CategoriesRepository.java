package elerning.Repository.Quiz;

import elerning.Model.Quiz.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CategoriesRepository extends JpaRepository<Categories, String> {

    List<Categories> findAll();

    Categories findCategoriesByCategory(String category);

    @Query("select c from Categories c where c.category=?1")
    Categories findCategory(String name);




}
