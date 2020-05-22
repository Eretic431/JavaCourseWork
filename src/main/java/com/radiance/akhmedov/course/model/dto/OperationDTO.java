package com.radiance.akhmedov.course.model.dto;

public class OperationDTO {
    private String name;
    private int debit;
    private int credit;
    private Long balanceId;

    public String getName() {
        return name;
    }

    public int getDebit() {
        return debit;
    }

    public int getCredit() {
        return credit;
    }

    public Long getBalanceId() {
        return balanceId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDebit(int debit) {
        this.debit = debit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public void setBalanceId(Long balanceId) {
        this.balanceId = balanceId;
    }
}
