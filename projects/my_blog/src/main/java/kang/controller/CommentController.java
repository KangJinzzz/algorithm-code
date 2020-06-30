package kang.controller;

import kang.model.Comment;
import kang.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    //添加评论
    @RequestMapping(value = "/a/{id}/comments", method = RequestMethod.POST)
    public String addComment(@PathVariable("id") Long id, String content) {
        Comment comment = new Comment();
        //添加评论的信息，user_id 需要将 article_id 与 user表进行联合查询获得
        comment.setArticleId(id);
        comment.setContent(content);
        comment.setCreatedAt(new Date());
        int num = commentService.insert(comment);
        //评论插入成功，返回评论页面
        return "redirect:/a/" + id;
    }
}
