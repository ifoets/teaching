package com.design.analysis.advance.simple.example.j2ee.business.businessdeligate;

import java.util.Locale;

public class BusinessLookup {

     NetflixService netflixService;
     YoutubeService youtubeService;

     public MovieStreamingService getBusinessService(String movie)
     {
         if(movie.toLowerCase(Locale.ROOT).contains("die hard"))
             return netflixService;
         else return youtubeService;
     }

    public void setNetflixService(NetflixService netflixService) {
        this.netflixService = netflixService;
    }

    public void setYoutubeService(YoutubeService youtubeService) {
        this.youtubeService = youtubeService;
    }
}

