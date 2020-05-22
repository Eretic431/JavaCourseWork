package com.radiance.akhmedov.course.repo;

import com.radiance.akhmedov.course.model.Articles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepo extends JpaRepository<Articles, Long>  {
    Articles findByName(final String name);
}
