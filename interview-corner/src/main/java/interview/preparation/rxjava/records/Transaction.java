package interview.preparation.rxjava.records;

import interview.preparation.rxjava.records.enums.TransactionStatus;
import interview.preparation.rxjava.records.enums.TransactionType;

import java.time.LocalDate;

public record Transaction(
    double amount ,
    TransactionType transactionType,
    TransactionStatus transactionStatus,
    LocalDate date)
{}
