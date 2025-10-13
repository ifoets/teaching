package com.system.design.service.scalability.distrubuted;

import com.system.design.core.algo.scalability.distrubuted.URLShortenerAlgo;
import com.system.design.entity.scalability.distrubuted.URLShortenerEntity;
import com.system.design.dto.scalability.distrubuted.URLShortenerDto;
import com.system.design.repository.scalability.distrubuted.URLShortenerRepository;
import com.system.design.utils.Convertor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class URLShortenerService {

    private final URLShortenerRepository urlShortenerRepository;
    private final URLShortenerAlgo urlShortenerAlgo;
    public URLShortenerService(URLShortenerRepository urlShortenerRepository, URLShortenerAlgo urlShortenerAlgo) {
        this.urlShortenerRepository = urlShortenerRepository;
        this.urlShortenerAlgo = urlShortenerAlgo;
    }

    // Save URL if it doesn't exist
    public Mono<URLShortenerDto> saveReactive(URLShortenerDto dto) {
        return Mono.fromCallable(() -> urlShortenerRepository.findByShortUrl(dto.getShortUrl()))
            .flatMap(existingEntity -> {
                if (existingEntity != null) {
                    // Record exists → map to record
                    dto.setShortUrl(urlShortenerAlgo.generateRandomShortUrl());
                }
                    // Save new entity
                    URLShortenerEntity entityToSave = Convertor.modelMapper
                        .map(dto, URLShortenerEntity.class);
                    URLShortenerEntity savedEntity = urlShortenerRepository.save(entityToSave);
                URLShortenerDto savedRecord = Convertor.modelMapper
                        .map(savedEntity, URLShortenerDto.class);
                    return Mono.just(savedRecord);

            })
            .onErrorResume(ex -> {
                // Handle exceptions reactively
                return Mono.error(new RuntimeException("Error saving URL: " + ex.getMessage()));
            });
    }

    // Find by short URL
    public Mono<URLShortenerDto> findByShortUrlReactive(String shortUrl) {
        return Mono.fromCallable(() -> urlShortenerRepository.findByShortUrl(shortUrl))
            .flatMap(entity -> {
                if (entity != null) {
                    return Mono.just(Convertor.modelMapper.map(entity, URLShortenerDto.class));
                } else {
                    return Mono.empty(); // 404 Not Found
                }
            });
    }

}
