package com.design.analysis.advance.simple.example.structural.adapter;

public class ExchangeAdapterPattern
{
    public ExchangeAdaptor adaptor;

    public double internationalExchange(double rupee, String type)
    {
        adaptor = new ExchangeAdaptor(type);
        return adaptor.convert(rupee);
    }
}
interface IRupee {
    double convert(Double money);
}
interface Exchange
{
    public double exchange(Double money, String type) throws RuntimeException;
}
class Dollar implements Exchange
{
    @Override
    public double exchange(Double money, String type) throws RuntimeException {
       if(type.equals("USD"))
        return (double) 80*money ;
       else throw new RuntimeException("Unable to convert");
    }
}
class Euro implements Exchange
{
    @Override
    public double exchange(Double money, String type) throws RuntimeException {
        if(type.equals("EUR"))
            return (double) 95*money ;
        else throw new RuntimeException("Unable to convert");
    }
}

class ExchangeAdaptor implements  IRupee
{
    Exchange exchange;
    String type;
    public ExchangeAdaptor(String type)
    {
        this.type = type;
        if(type.equals("USD"))
            exchange = new Dollar();
        else if(type.equals("EUR"))
            exchange = new Euro();
    }
    @Override
    public double convert(Double money) {
        return exchange.exchange(money,type);
    }
}

