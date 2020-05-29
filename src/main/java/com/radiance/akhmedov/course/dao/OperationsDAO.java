package com.radiance.akhmedov.course.dao;

import com.radiance.akhmedov.course.model.Articles;
import com.radiance.akhmedov.course.model.Balance;
import com.radiance.akhmedov.course.model.Operations;
import com.radiance.akhmedov.course.model.dto.OperationDTO;
import com.radiance.akhmedov.course.repo.BalanceRepo;
import com.radiance.akhmedov.course.repo.OperationRepo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OperationsDAO {
    private final OperationRepo operationRepo;
    private final ArticlesDAO articleDAO;
    private final BalanceRepo balanceRepo;

    public OperationsDAO(
            final OperationRepo operationRepo,
            final ArticlesDAO articleDAO,
            final BalanceRepo balanceRepo) {
        this.operationRepo = operationRepo;
        this.articleDAO = articleDAO;
        this.balanceRepo = balanceRepo;
    }

    public Operations insert(final OperationDTO operation) {
        Articles article = articleDAO.findByName(operation.getName());
        if (article == null) {
            article = articleDAO.insert(new Articles(operation.getName()));
        }
        Balance balance = balanceRepo.findById(operation.getBalanceId()).orElseThrow(
                () -> new IllegalArgumentException("No balance with such id"));

        balance.setDebit(balance.getDebit() + operation.getDebit());
        balance.setCredit(balance.getCredit() + operation.getCredit());
        balance.setAmount(balance.getDebit() - balance.getCredit());
        balanceRepo.save(balance);

        return operationRepo.save(new Operations(
                article,
                operation.getDebit(),
                operation.getCredit(),
                balance));
    }

    public List<Operations> getOperationsByBalanceId(final Long balanceId) {
        return operationRepo.findAllByBalanceId(balanceId);
    }

    public List<Operations> getOperationsByArticleId(final Long articleId) {
        return operationRepo.findAllByArticleId(articleId);
    }

    public List<Operations> getAllOperations() {
        return operationRepo.findAll();
    }
}
