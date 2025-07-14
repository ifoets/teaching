package interview.preparation.rxjava.records;

public record Product(
    String id,
    String name,
    String category,
    double price,
    boolean inStock
) {}
