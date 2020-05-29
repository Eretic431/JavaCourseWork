package com.radiance.akhmedov.course.repo;

import com.radiance.akhmedov.course.model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OperationRepo extends JpaRepository<Operation, Long> {
    List<Operation> findAllByBalanceId(final Long balanceId);
    List<Operation> findAllByArticleId(final Long articleId);
}
