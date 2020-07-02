package kang.service;

import kang.mapper.CategoryMapper;
import kang.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;


    public List<Category> queryCategoriesByUserId(Long id) {
        return categoryMapper.queryCategoriesByUserId(id);
    }

    public int insert(Category category) {
        return categoryMapper.insert(category);
    }

    public Category selectByPrimaryKey(Long id) {
        return categoryMapper.selectByPrimaryKey(id);
    }
}
