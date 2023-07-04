package com.devlucasmoreira.investmentevaluation.server.service.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class StockCleanCacheService {

    @Autowired
    private CacheManager cacheManager;

    public void execute() {
        Objects.requireNonNull(cacheManager.getCache("activeList")).clear();
        Objects.requireNonNull(cacheManager.getCache("realEstateFundList")).clear();
        Objects.requireNonNull(cacheManager.getCache("stockList")).clear();
        Objects.requireNonNull(cacheManager.getCache("generalSummary")).clear();
        Objects.requireNonNull(cacheManager.getCache("stockSummary")).clear();
        Objects.requireNonNull(cacheManager.getCache("realEstateFundSummary")).clear();
    }

}
