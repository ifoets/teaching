package com.system.design.apis.scalability.distrubuted;

import com.system.design.dto.scalability.distrubuted.URLShortenerDto;
import com.system.design.service.scalability.distrubuted.URLShortenerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController("url/shortener")
public class URLShortenerApis {

    private final URLShortenerService urlShortenerService;

    public URLShortenerApis(URLShortenerService urlShortenerService) {
        this.urlShortenerService = urlShortenerService;
    }

    // Save URL reactively
    @PostMapping("/save")
    public Mono<ResponseEntity<URLShortenerDto>> saveUrl(@RequestBody URLShortenerDto record) {
        return urlShortenerService.saveReactive(record)
            .map(ResponseEntity::ok)
            .onErrorResume(ex -> Mono.just(ResponseEntity.status(500)
                .build()));
    }

    // Find by short URL reactively
    @GetMapping("/{shortUrl}")
    public Mono<ResponseEntity<URLShortenerDto>> getByShortUrl(@PathVariable String shortUrl) {
        return urlShortenerService.findByShortUrlReactive(shortUrl)
            .map(ResponseEntity::ok)
            .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
