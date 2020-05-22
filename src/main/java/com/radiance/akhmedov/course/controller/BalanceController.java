package com.radiance.akhmedov.course.controller;

import com.radiance.akhmedov.course.dao.BalanceDAO;
import com.radiance.akhmedov.course.model.Balance;
import com.radiance.akhmedov.course.model.dto.BalanceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("balance")
@RestController
public class BalanceController {
    private final BalanceDAO balanceDAO;

    @Autowired
    public BalanceController(@RequestBody final BalanceDAO balanceDAO) {
        this.balanceDAO = balanceDAO;
    }

    @GetMapping
    public ResponseEntity<List<Balance>> getBalances() {
        final List<Balance> balances = balanceDAO.getAllBalances();
        if (balances.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(balances);
    }

    @PostMapping
    public ResponseEntity<Balance> insert(@RequestBody final BalanceDTO balance) {
        return ResponseEntity.ok(balanceDAO.insert(balance));
    }
}
