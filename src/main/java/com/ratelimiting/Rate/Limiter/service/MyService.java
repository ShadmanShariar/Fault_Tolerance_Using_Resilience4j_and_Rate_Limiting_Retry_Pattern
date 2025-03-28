package com.ratelimiting.Rate.Limiter.service;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.stereotype.Service;

@Service
public class MyService {
    @RateLimiter(name = "myRateLimiter", fallbackMethod = "rateLimitFallback")
    public String processRequest() {
        return "Request processed successfully!";
    }

    public String rateLimitFallback(Throwable throwable) {
        return "Rate limit exceeded. Please try again later.";
    }
    @Retry(name = "myRetry", fallbackMethod = "retryFallback")
    public String processRequest2() {
        return "Request processed successfully!";
    }

    public String retryFallback(Throwable throwable) {
        return "Please try again later.";
    }
}
