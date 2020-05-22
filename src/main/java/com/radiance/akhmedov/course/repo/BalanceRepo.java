package com.radiance.akhmedov.course.repo;

import com.radiance.akhmedov.course.model.Balance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceRepo extends JpaRepository<Balance, Long> {
}
