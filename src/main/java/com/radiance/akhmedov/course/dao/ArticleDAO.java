package com.radiance.akhmedov.course.dao;

import com.radiance.akhmedov.course.model.Article;
import com.radiance.akhmedov.course.repo.ArticleRepo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArticleDAO {
    private final ArticleRepo articleRepo;

    public ArticleDAO(ArticleRepo articleRepo) {
        this.articleRepo = articleRepo;
    }

    public Article insert(final Article article) {
        final Article articleFoundByName = findByName(article.getName());
        if (articleFoundByName != null) {
            return articleFoundByName;
        }
        return articleRepo.save(article);
    }

    public List<Article> getAllArticles() {
        return articleRepo.findAll();
    }

    public Article findByName(final String name) {
        return articleRepo.findByName(name);
    }
}
