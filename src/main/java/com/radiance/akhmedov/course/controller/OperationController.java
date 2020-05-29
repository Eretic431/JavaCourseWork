package com.radiance.akhmedov.course.controller;

import com.radiance.akhmedov.course.dao.OperationDAO;
import com.radiance.akhmedov.course.model.Operation;
import com.radiance.akhmedov.course.model.dto.OperationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("operation")
@RestController
public class OperationController {
    private final OperationDAO operationDAO;

    @Autowired
    public OperationController(OperationDAO operationDAO) {
        this.operationDAO = operationDAO;
    }

    @PostMapping
    public ResponseEntity<Operation> insert(@RequestBody final OperationDTO operation) {
        try {
            final Operation tmp = operationDAO.insert(operation);
            return ResponseEntity.ok(tmp);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("all")
    public ResponseEntity<List<Operation>> getOperations() {
        final List<Operation> operations = operationDAO.getAllOperations();
        if (operations.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(operations);
    }


    @GetMapping("balance")
    public ResponseEntity<List<Operation>> getOperationsByBalanceId(@RequestParam Long id) {
        final List<Operation> operations = operationDAO.getOperationsByBalanceId(id);
        if (operations.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(operations);
    }

    @GetMapping("article")
    public ResponseEntity<List<Operation>> getOperationsByArticleId(@RequestParam Long id) {
        final List<Operation> operations = operationDAO.getOperationsByArticleId(id);
        if (operations.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(operations);
    }
}
