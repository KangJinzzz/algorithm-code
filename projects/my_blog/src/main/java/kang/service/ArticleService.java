package kang.service;


import kang.mapper.ArticleMapper;
import kang.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

//    @Autowired
//    private ArticleMapper articleMapper;
//
//    public List<Article> queryArticles() {
//        return articleMapper.selectAll();
//    }
//
//    public Article selectByPrimaryKey(Long id) {
//        return articleMapper.selectByPrimaryKey(id);
//    }

    @Autowired
    private ArticleMapper articleMapper;

    public List<Article> queryArticles() {
        return articleMapper.selectAll();
    }

    public Article queryArticle(Long id) {
        return articleMapper.selectByPrimaryKey(id);
    }
}
