package com.radiance.akhmedov.course.dao;

import com.radiance.akhmedov.course.model.Balance;
import com.radiance.akhmedov.course.model.dto.BalanceDTO;
import com.radiance.akhmedov.course.repo.BalanceRepo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BalanceDAO {
    private final BalanceRepo balanceRepo;

    public BalanceDAO(final BalanceRepo balanceRepo) {
        this.balanceRepo = balanceRepo;
    }

    public Balance insert(final BalanceDTO balance) {
        return balanceRepo.save(new Balance(balance.getName()));
    }

    public List<Balance> getAllBalances() {
        return balanceRepo.findAll();
    }
}
