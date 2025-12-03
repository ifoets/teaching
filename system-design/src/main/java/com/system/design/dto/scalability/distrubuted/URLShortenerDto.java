package com.system.design.dto.scalability.distrubuted;

import lombok.Data;

@Data
public class URLShortenerDto {
    private  Long id;
    private  Long userId;
    private  String shortUrl;
    private  String originalUrl;
    private  String createdAt;
    private  String updatedAt;
}
