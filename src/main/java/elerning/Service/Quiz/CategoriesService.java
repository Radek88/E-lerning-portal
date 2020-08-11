package elerning.Service.Quiz;

import elerning.Model.Categories;
import java.util.List;

public interface CategoriesService {

    List<Categories> findAll();

    void addCategories(Categories categories);

    void deleteCategories(Categories categories);

    Categories findByCategoryName(String category_name);



}
