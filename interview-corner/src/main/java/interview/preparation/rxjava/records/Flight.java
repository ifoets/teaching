package interview.preparation.rxjava.records;

public record Flight(double amount, String flight,String src, String destination, int distance, String flightNo) {

    public String getOperational()
    {
        return src+"->"+destination;
    }

    public String getFlightAmount()
    {
        return getOperational()+"::"+amount;
    }
}
