package interview.preparation.rxjava.stream.records;

public record Book(
    String isbn,
    String title,
    String author,
    String genre,
    double price,
    int pages,
    boolean available
) {}