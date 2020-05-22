package com.radiance.akhmedov.course.controller;

import com.radiance.akhmedov.course.dao.OperationsDAO;
import com.radiance.akhmedov.course.model.Operations;
import com.radiance.akhmedov.course.model.dto.OperationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("operation")
@RestController
public class OperationController {
    private final OperationsDAO operationsDAO;

    @Autowired
    public OperationController(OperationsDAO operationsDAO) {
        this.operationsDAO = operationsDAO;
    }

    @PostMapping
    public ResponseEntity<Operations> insert(@RequestBody final OperationDTO operation) {
        try {
            final Operations tmp = operationsDAO.insert(operation);
            return ResponseEntity.ok(tmp);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("balance")
    public ResponseEntity<List<Operations>> getOperationsByBalanceId(@RequestParam Long id) {
        final List<Operations> operations = operationsDAO.getOperationsByBalanceId(id);
        if (operations.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(operations);
    }

    @GetMapping("article")
    public ResponseEntity<List<Operations>> getOperationsByArticleId(@RequestParam Long id) {
        final List<Operations> operations = operationsDAO.getOperationsByArticleId(id);
        if (operations.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(operations);
    }
}
