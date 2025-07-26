package interview.preparation.rxjava.stream.records;

import interview.preparation.rxjava.stream.records.enums.TransactionStatus;
import interview.preparation.rxjava.stream.records.enums.TransactionType;

import java.time.LocalDate;

public record Transaction(
    double amount ,
    TransactionType transactionType,
    TransactionStatus transactionStatus,
    LocalDate date)
{}
