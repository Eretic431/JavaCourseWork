package com.radiance.akhmedov.course.dao;

import com.radiance.akhmedov.course.model.Articles;
import com.radiance.akhmedov.course.repo.ArticleRepo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArticlesDAO {
    private final ArticleRepo articleRepo;

    public ArticlesDAO(ArticleRepo articleRepo) {
        this.articleRepo = articleRepo;
    }

    public Articles insert(final Articles article) {
        return articleRepo.save(article);
    }

    public List<Articles> getAllArticles() {
        return articleRepo.findAll();
    }

    public Articles findByName(final String name) {
        return articleRepo.findByName(name);
    }
}
