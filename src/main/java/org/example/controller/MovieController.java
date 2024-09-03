package org.example.controller;

import org.example.Main;
import org.example.pojo.Movie;
import org.example.pojo.ResObj;
import org.example.service.CountPerYr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.example.service.CountPerYrImpl;

import java.util.Arrays;

@RestController
@RequestMapping(value = "movie")
public class MovieController{

    private final RestTemplate restTemplate;
    private final CountPerYr countPerYr;
    @Autowired
    MovieController(RestTemplate restTemplate, CountPerYr countPerYr){
        this.restTemplate = restTemplate;
        this.countPerYr = countPerYr;
    }

    @GetMapping(params = "page")
    public ResObj getMovie(@RequestParam(name = "page") int page){
        String uri = "https://jsonmock.hackerrank.com/api/movies?page=" +  page;
        ResObj res = restTemplate.getForObject(uri, ResObj.class);
        System.out.println("ans");

        return res;
    }
    @GetMapping(params = {"page", "year"})
    public int getCountPerYr(@RequestParam(name = "year") int yr){
//        int ans = CountPerYrImpl;


        return yr;
    }

    @GetMapping(params = {"year"})
    public int getMoviesFromYr(@RequestParam(name = "year") int yr){
        int ans = countPerYr.count(yr);
        System.out.println(ans);
        return ans;
    }

}
