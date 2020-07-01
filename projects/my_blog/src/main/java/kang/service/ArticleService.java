package kang.service;


import kang.mapper.ArticleMapper;
import kang.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    public List<Article> queryArticles() {
        return articleMapper.selectAll();
    }

    public Article queryArticle(Long id) {
        return articleMapper.selectByPrimaryKey(id);
    }


    public List<Article> queryArticlesByUserId(Long id) {
        return articleMapper.queryArticlesByUserId(id);
    }

    public Article selectByPrimaryKet(Integer id) {
        return articleMapper.selectByPrimaryKey(id.longValue());
    }

    public int updateByCondition(Article article) {
        return articleMapper.updateByCondition(article);
    }

    public int insert(Article article) {
        return articleMapper.insert(article);
    }
}
