package interview.preparation.rxjava.stream.records.keys;

public record FlightOperationKey(String src, String destination) {
    @Override
    public String toString() {
        return src+"->"+destination;
    }
}
