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

    public List<Category> queryByUserId(Long userId) {
        return categoryMapper.queryByUserId(userId);
    }

    public int insert(Category category) {
        return categoryMapper.insert(category);
    }
}
