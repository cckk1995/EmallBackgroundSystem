package com.emall.service;

import com.emall.error.BusinessException;

import java.util.Map;

public interface StatisticService {
    Map<String, float[]> getStatistics() throws BusinessException;
}
