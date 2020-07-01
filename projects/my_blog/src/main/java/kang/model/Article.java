package kang.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Article {
    private Long id;

    private Long userId;

    private String coverImage;

    private Integer categoryId;

    private Byte status;

    private String title;

    private String content;

    private Long viewCount;

    private Date createdAt;

    private Date updatedAt;

    /**
     * 页面需要的属性，需自行添加
     */
    private User author;

    private Integer commentCount;   //评论数

    private List<Comment> commentList;
}