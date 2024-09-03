package org.example.service;

import org.example.pojo.Movie;
import org.example.pojo.ResObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class CountPerYrImpl implements CountPerYr {
    private final RestTemplate restTemplate;



    @Autowired
    CountPerYrImpl(ResObj res, RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }


    public int count(int yr){
        int ans = 0;
        ResObj r = restTemplate.getForObject("https://jsonmock.hackerrank.com/api/movies?page=1", ResObj.class);

        for(int i=1; i<r.getTotal_pages()+1; i++){
            ans += countPerPage(restTemplate.getForObject("https://jsonmock.hackerrank.com/api/movies?page="+i, ResObj.class).getData(), yr);
        }
//        return countPerPage(r.getData(), 1995);
        return ans;
    }


    int countPerPage(Movie[] data, int yr){
        return (int) Arrays.stream(data).filter(x -> x.getYear() == yr).count();
    }
}
