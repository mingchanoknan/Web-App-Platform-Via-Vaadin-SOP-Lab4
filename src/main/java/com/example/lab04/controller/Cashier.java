package com.example.lab04.controller;

import com.example.lab04.model.Change;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Cashier {

    @GetMapping("/getchange/{change}")
    public Change getChange(@PathVariable int change) {
        int keep = change;
        int b1000 = (int) Math.floor(keep / 1000);
        keep = keep % 1000;
        int b500 = (int) Math.floor(keep / 500);
        keep = keep % 500;
        int b100 = (int) Math.floor(keep / 100);
        keep = keep % 100;
        int b20 = (int) Math.floor(keep / 20);
        keep = keep % 20;
        int b10 = (int) Math.floor(keep / 10);
        keep = keep % 10;
        int b5 = (int) Math.floor(keep / 5);
        int b1 = keep % 5;
        Change result = new Change(b1000, b500, b100, b20, b10, b5, b1);
        return result;
    }
}
