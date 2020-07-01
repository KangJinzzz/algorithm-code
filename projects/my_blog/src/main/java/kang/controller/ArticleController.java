package kang.controller;


import kang.model.Article;
import kang.model.Category;
import kang.model.Comment;
import kang.model.User;
import kang.service.ArticleService;
import kang.service.CategoryService;
import kang.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/")
    public String index(Model model) {
        List<Article> articles = articleService.queryArticles();
        model.addAttribute("articleList", articles);
        return "index";
    }

    //该页面需要用到文章的评论列表和作者，所以要写联合查询的 sql 语句
    @RequestMapping("/a/{id}")
    public String detail(@PathVariable("id") Long id, Model model) {
        Article article = articleService.queryArticle(id);
        List<Comment> comments = commentService.queryComments(id);
        article.setCommentList(comments);
        model.addAttribute("article", article);
        //发回文章详情页面
        return "info";
    }

    //发布文章页面，需要提供文章列表：articleList，分类列表：categoryList，文章的分类id：activeCid
    @RequestMapping("/writer")
    public String writer(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        List<Article> articles = articleService.queryArticlesByUserId(user.getId());
        model.addAttribute("articleList", articles);
        List<Category> categories = categoryService.queryByUserId(user.getId());
        model.addAttribute("categoryList",categories);
        if (categories.size() == 0) {
            model.addAttribute("activeCid", null);
        } else {
            model.addAttribute("activeCid", categories.get(0).getId());
        }
        return "writer";
    }

    @RequestMapping("/writer/forward/{type}/{id}/editor")
    public String

}
