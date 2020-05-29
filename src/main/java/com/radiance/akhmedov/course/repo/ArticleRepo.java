package com.radiance.akhmedov.course.repo;

import com.radiance.akhmedov.course.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepo extends JpaRepository<Article, Long>  {
    Article findByName(final String name);
}
