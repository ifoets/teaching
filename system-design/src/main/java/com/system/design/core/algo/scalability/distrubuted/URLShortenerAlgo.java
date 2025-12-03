package com.system.design.core.algo.scalability.distrubuted;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Random;

@Service
public class URLShortenerAlgo {

    private static final String BASE_URL="http://tiny.url/";
    private static final int NUM_CHARS_SHORT_LINK = 7;
    private static final String ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static int COUNTER=1000000000;
    private final Random random = new Random();

    HashMap<String, Integer> ltos;
    HashMap<Integer, String> stol;
    URLShortenerAlgo() {
        ltos = new HashMap<>();
        stol = new HashMap<>();
        COUNTER = 1000000000;
        }
    /**Technique 1 —Short url from random numbers:*/
    public String generateRandomShortUrl() {
        char[] result = new char[NUM_CHARS_SHORT_LINK];
            for (int i = 0; i < NUM_CHARS_SHORT_LINK; i++) {
                int randomIndex = random.nextInt(ALPHABET.length() - 1);
                result[i] = ALPHABET.charAt(randomIndex);
            }
            return BASE_URL+new String(result);
    }

    /**Technique 2 — Short urls from base conversion:**/
    public String longToShort(String url) {
        String shortUrl = base10ToBase62(COUNTER);
        ltos.put(url, COUNTER);
        stol.put(COUNTER, url);
        COUNTER++;
        return BASE_URL + shortUrl;
    }
    public String shortToLong(String url) {
        url = url.substring(BASE_URL.length());
        int n = base62ToBase10(url);
        return stol.get(n);
    }

    public int base62ToBase10(String s) {
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            n = n * 62 + convert(s.charAt(i));
        }
        return n;

    }

    public String base10ToBase62(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.insert(0, ALPHABET.charAt(n % 62));
            n /= 62;
        }
        while (sb.length() != 7) {
            sb.insert(0, '0');
        }
        return sb.toString();
    }

    public int convert(char c) {
        if (c >= '0' && c <= '9')
            return c - '0';
        if (c >= 'a' && c <= 'z') {
            return c - 'a' + 10;
        }
        if (c >= 'A' && c <= 'Z') {
            return c - 'A' + 36;
        }
        return -1;
    }
}
