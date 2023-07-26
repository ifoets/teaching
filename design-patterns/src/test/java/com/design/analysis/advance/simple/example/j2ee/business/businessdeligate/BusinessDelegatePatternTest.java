package com.design.analysis.advance.simple.example.j2ee.business.businessdeligate;

import org.junit.Before;
import org.junit.Test;

public class BusinessDelegatePatternTest {

    MovieClient client;

    @Before
    public void inti()
    {
        BusinessDelegate delegate = new BusinessDelegate();
        BusinessLookup lookup = new BusinessLookup();
        lookup.setNetflixService(new NetflixService());
        lookup.setYoutubeService(new YoutubeService());
        delegate.setLookup(lookup);
        client = new MovieClient(delegate);
    }

    @Test
    public void businessDelegatePatternTest()
    {
        client.playbackMovie("Die Hard 2");
        client.playbackMovie("Maradona: The Greatest Ever");
    }
}
