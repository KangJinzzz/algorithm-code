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
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.Date;
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
        Article article = articleService.selectByPrimaryKey(id);
        List<Comment> comments = commentService.queryComments(id);
        article.setCommentList(comments);
        model.addAttribute("article", article);
        //发回文章详情页面
        return "info";
    }

    /**
     *
     * @param session
     * @param activeCid 当从首页进入 writer 页面时，此时没有从 writer 获取 activeCid，传入分类列表的第一个对象的 id 即可(其他的也可以)，
     *                  当在 writer 页面时，需要在其他分类中对文章修改或新增，此时可以点击该分类，之后会重定向到 /write 并加入点击的分类的
     *                  id 这个参数：a href="/writer?activeCid=${category.id}"，这时可以用传入的 activeCid在 重定向 /writer 时把传入
     *                  的 activeCid 设置到重定向任务的 activeCid，这样此时对文章的操作都是基于当前点击的分类的 id 进行操作的
     * @param model
     * @return
     */
    //发布文章页面，需要提供文章列表：articleList，分类列表：categoryList，文章的分类id：activeCid
    @RequestMapping("/writer")
    public String writer(HttpSession session, Long activeCid, Model model) {
        User user = (User) session.getAttribute("user");
        List<Article> articles = articleService.queryArticlesByUserId(user.getId());
        model.addAttribute("articleList", articles);
        List<Category> categories = categoryService.queryCategoriesByUserId(user.getId());
        model.addAttribute("categoryList",categories);
        //activeCid 为空，说明是从首页进入到的 writer，不为空，则是在 writer 页面点击某个分类进入到 writer 页面
        model.addAttribute("activeCid", activeCid == null ? categories.get(0).getId() : activeCid);
        return "writer";
    }


    /**
     * 进入编辑页面
     * @param type  type 为 1：新增文章  type 为 2：修改文章
     * @param id    type 为 1 时，id为分类id：categoryId   type为2时，id为文章id：articleId
     * @param model     type 两种情况都需要添加，activeCid 在 type 为1时需要添加
     * @return
     */
    @RequestMapping("/writer/forward/{type}/{id}/editor")
    public String editor(@PathVariable("type") Integer type, @PathVariable("id") Long id, Model model) {
        Category category = null;
        if (type == 1) {    //新增文章,需要查找到当前分类
            model.addAttribute("activeCid", id);
            category = categoryService.selectByPrimaryKey(id);
        } else {    //修改文章，需要查找当前的文章和分类
            Article article = articleService.selectByPrimaryKey(id);
            category = categoryService.selectByPrimaryKey(article.getCategoryId().longValue());
            model.addAttribute("article", article);
        }
        model.addAttribute("type", type);
        model.addAttribute("category", category);
        return "editor";
    }

    /**
     *
     * @param type  type 为1：新增文章  type 为2：修改文章
     * @param id    type 为1时，id为分类id：categoryId   type为2时，id为文章id：articleId
     * @param article   点击发布按钮时，前端已经将article的 title 和 content 设置到 article
     * @return  返回修改/新增文章的修改页面
     */
    @RequestMapping(value = "/writer/article/{type}/{id}", method = RequestMethod.POST)
    public String submit(@PathVariable("type") Integer type, @PathVariable("id") Long id, Article article, HttpSession session) {
        article.setUpdatedAt(new Date());
        if (type == 1) {    //新增文章，
            User user = (User) session.getAttribute("user");
            article.setUserId(user.getId());
            article.setCoverImage("https://picsum.photos/id/1/400/300");
            article.setCategoryId(id.intValue());
            article.setStatus((byte) 0);
            article.setViewCount((long) 0);
            article.setCreatedAt(new Date());
            int num = articleService.insert(article);
            id = article.getId();
        } else {    //修改文章，此时通过 id 查询到对应的文章，将其他不用变的属性设置如 article
            int num = articleService.updateByCondition(article);
        }
        return String.format("redirect:/writer/forward/2/%s/editor", id);
    }

}
