package org.example.pojo;

import org.springframework.stereotype.Component;

import java.util.Arrays;
@Component
public class ResObj {
    private int page, per_page, total, total_pages;
    private Movie[] data;

    public int getPage() {
        return page;
    }

    public int getPer_page() {
        return per_page;
    }

    public int getTotal() {
        return total;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public Movie[] getData() {
        return data;
    }

//    @Override
//    public String toString(){
//        return "Response [data:"+ Arrays.toString(this.getData()) + "]"
//    }
}
