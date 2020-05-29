package com.radiance.akhmedov.course.dao;

import com.radiance.akhmedov.course.model.Article;
import com.radiance.akhmedov.course.model.Balance;
import com.radiance.akhmedov.course.model.Operation;
import com.radiance.akhmedov.course.model.dto.OperationDTO;
import com.radiance.akhmedov.course.repo.BalanceRepo;
import com.radiance.akhmedov.course.repo.OperationRepo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OperationDAO {
    private final OperationRepo operationRepo;
    private final ArticleDAO articleDAO;
    private final BalanceRepo balanceRepo;

    public OperationDAO(
            final OperationRepo operationRepo,
            final ArticleDAO articleDAO,
            final BalanceRepo balanceRepo) {
        this.operationRepo = operationRepo;
        this.articleDAO = articleDAO;
        this.balanceRepo = balanceRepo;
    }

    public Operation insert(final OperationDTO operation) {
        Article article = articleDAO.findByName(operation.getName());
        if (article == null) {
            article = articleDAO.insert(new Article(operation.getName()));
        }
        Balance balance = balanceRepo.findById(operation.getBalanceId()).orElseThrow(
                () -> new IllegalArgumentException("No balance with such id"));

        balance.setDebit(balance.getDebit() + operation.getDebit());
        balance.setCredit(balance.getCredit() + operation.getCredit());
        balance.setAmount(balance.getDebit() - balance.getCredit());
        balanceRepo.save(balance);

        return operationRepo.save(new Operation(
                article,
                operation.getDebit(),
                operation.getCredit(),
                balance));
    }

    public List<Operation> getOperationsByBalanceId(final Long balanceId) {
        return operationRepo.findAllByBalanceId(balanceId);
    }

    public List<Operation> getOperationsByArticleId(final Long articleId) {
        return operationRepo.findAllByArticleId(articleId);
    }

    public List<Operation> getAllOperations() {
        return operationRepo.findAll();
    }
}
