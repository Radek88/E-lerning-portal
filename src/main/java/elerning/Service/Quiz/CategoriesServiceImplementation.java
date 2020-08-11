package elerning.Service.Quiz;

import elerning.Model.Categories;
import elerning.Repository.Quiz.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoriesServiceImplementation implements CategoriesService {

    @Autowired
    CategoriesRepository categoriesRepository;


    @Override
    public List<Categories> findAll() {
        return categoriesRepository.findAll();
    }

    @Override
    public void addCategories(Categories categories) {
        categoriesRepository.saveAndFlush(categories);
    }

    @Override
    public void deleteCategories(Categories categories) {
            categoriesRepository.delete(categories);
    }

    @Override
    public Categories findByCategoryName(String category_name) {
        return categoriesRepository.findCategoriesByCategory(category_name);

    }


}
