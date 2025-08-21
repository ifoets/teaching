package interview.preparation.rxjava.records;

public record Book(
    String isbn,
    String title,
    String author,
    String genre,
    double price,
    int pages,
    boolean available
) {}