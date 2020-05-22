package com.radiance.akhmedov.course.repo;

import com.radiance.akhmedov.course.model.Operations;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OperationRepo extends JpaRepository<Operations, Long> {
    List<Operations> findAllByBalanceId(final Long balanceId);
    List<Operations> findAllByArticleId(final Long articleId);
}
