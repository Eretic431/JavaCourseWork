package com.radiance.akhmedov.course.model;

import org.springframework.lang.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "balance")
public class Balance {
    public Balance() {
    }

    public Balance(String name) {
        this.name = name;
        this.createDate = new Timestamp(System.currentTimeMillis());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "create_date")
    private Timestamp createDate;

    @Column(name = "debit")
    private int debit;

    @Column(name = "credit")
    private int credit;

    @Column(name = "amount")
    private int amount;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public void setDebit(int debit) {
        this.debit = debit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public int getDebit() {
        return debit;
    }

    public int getCredit() {
        return credit;
    }

    public int getAmount() {
        return amount;
    }
}
