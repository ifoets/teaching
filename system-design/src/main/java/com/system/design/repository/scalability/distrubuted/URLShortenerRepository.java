package com.system.design.repository.scalability.distrubuted;

import com.system.design.entity.scalability.distrubuted.URLShortenerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  URLShortenerRepository extends JpaRepository<URLShortenerEntity,Long> {

    URLShortenerEntity findByShortUrl(String shortUrl);

    URLShortenerEntity save(URLShortenerEntity entity);
}
