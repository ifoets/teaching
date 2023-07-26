package com.design.analysis.advance.simple.example.j2ee.business.businessdeligate;

public interface MovieStreamingService {
     void doProcessing();
}

class NetflixService implements MovieStreamingService
{
    @Override
    public void doProcessing(){
     System.out.println("NetflixService is now processing");
    }
}
class YoutubeService implements  MovieStreamingService
{
    @Override
    public void doProcessing(){
        System.out.println("YoutubeService is now processing");
    }
}
