package interview.preparation.rxjava.stream.records;

import interview.preparation.rxjava.stream.records.enums.OrderStatus;

public record Order(
    String id,
    String customerName,
    double amount,
    OrderStatus status
) {}
