package com.radiance.akhmedov.course.controller;

import com.radiance.akhmedov.course.dao.ArticleDAO;
import com.radiance.akhmedov.course.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("articles")
@RestController
public class ArticleController {
    private final ArticleDAO articleDAO;

    @Autowired
    public ArticleController(ArticleDAO articleDAO) {
        this.articleDAO = articleDAO;
    }

    @GetMapping
    public ResponseEntity<List<Article>> getArticles() {
        final List<Article> articles = articleDAO.getAllArticles();
        if (articles.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(articles);
    }

    @PostMapping
    public ResponseEntity<Article> insert(@RequestBody final Article article) {
        return ResponseEntity.ok(articleDAO.insert(article));
    }
}
