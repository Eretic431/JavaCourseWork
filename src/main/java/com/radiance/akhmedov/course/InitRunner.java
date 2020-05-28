package com.radiance.akhmedov.course;

import com.radiance.akhmedov.course.dao.ArticlesDAO;
import com.radiance.akhmedov.course.model.Articles;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class InitRunner implements CommandLineRunner {

    private final ArticlesDAO articlesDAO;

    public InitRunner(ArticlesDAO articlesDAO) {
        this.articlesDAO = articlesDAO;
    }

    @Override
    public void run(String... args) throws Exception {
        Arrays.stream(new String[]{"Школа", "Быт", "Комуналка", "Развлечения", "Машина"})
                .forEach(article -> {
                    articlesDAO.insert(new Articles(article));
                });
    }
}
