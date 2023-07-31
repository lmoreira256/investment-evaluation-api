package com.devlucasmoreira.investmentevaluation.server.service.earning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class EarningCleanCacheService {

    @Autowired
    private CacheManager cacheManager;

    public void execute() {
        Objects.requireNonNull(cacheManager.getCache("earningList")).clear();
        Objects.requireNonNull(cacheManager.getCache("earningSummaryActive")).clear();
        Objects.requireNonNull(cacheManager.getCache("earningSummaryMonth")).clear();
        Objects.requireNonNull(cacheManager.getCache("earningSummaryTotal")).clear();
        Objects.requireNonNull(cacheManager.getCache("earningSummaryComplete")).clear();
    }

}
