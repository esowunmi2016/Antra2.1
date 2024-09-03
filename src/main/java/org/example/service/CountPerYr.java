package org.example.service;

import org.example.pojo.ResObj;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public interface CountPerYr {
    int count(int yr);
}
