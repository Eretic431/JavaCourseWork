package com.radiance.akhmedov.course.controller;

import com.radiance.akhmedov.course.dao.ArticlesDAO;
import com.radiance.akhmedov.course.model.Articles;
import com.radiance.akhmedov.course.model.Balance;
import com.radiance.akhmedov.course.model.dto.BalanceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("articles")
@RestController
public class ArticleController {
    private final ArticlesDAO articlesDAO;

    @Autowired
    public ArticleController(ArticlesDAO articlesDAO) {
        this.articlesDAO = articlesDAO;
    }

    @GetMapping
    public ResponseEntity<List<Articles>> getArticles() {
        final List<Articles> articles = articlesDAO.getAllArticles();
        if (articles.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(articles);
    }

    @PostMapping
    public ResponseEntity<Articles> insert(@RequestBody final Articles articles) {
        return ResponseEntity.ok(articlesDAO.insert(articles));
    }
}
