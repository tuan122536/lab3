package lab3.anhtuan.services;

import lab3.anhtuan.entity.Category;
import lab3.anhtuan.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServices {
    @Autowired
    private ICategoryRepository categoryRepository;

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id){
        return categoryRepository.findById(id).orElse(null);
    }
    public Category saveCategory(Category category){
        return categoryRepository.save(category);
    }
    public void addCategory(Category category){
        categoryRepository.save(category);
    }

    public void updateCategory(Category category){
        categoryRepository.save(category);
    }
    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }
}
