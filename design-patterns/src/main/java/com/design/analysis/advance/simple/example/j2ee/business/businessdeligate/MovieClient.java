package com.design.analysis.advance.simple.example.j2ee.business.businessdeligate;

public class MovieClient {

    private BusinessDelegate delegate;

    public MovieClient(BusinessDelegate delegate)
    {
        this.delegate = delegate;
    }
    public void playbackMovie(String movie)
    {
        delegate.playBackMove(movie);
    }
}
