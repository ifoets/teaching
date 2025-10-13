package interview.preparation.rxjava.records.keys;

public record FlightOperationKey(String src, String destination) {
    @Override
    public String toString() {
        return src+"->"+destination;
    }
}
