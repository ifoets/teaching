package interview.preparation.rxjava.records;

import interview.preparation.rxjava.records.enums.OrderStatus;

public record Order(
    String id,
    String customerName,
    double amount,
    OrderStatus status
) {}
