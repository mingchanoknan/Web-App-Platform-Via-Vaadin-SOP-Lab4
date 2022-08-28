package com.example.lab04.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class MathAPI {

    @GetMapping("/plus/{n1}/{n2}")
    public double myPlus(@PathVariable double n1, @PathVariable double n2){
        return n1+n2;
    }
    @GetMapping("/minus/{n1}/{n2}")
    public double myMinus(@PathVariable double n1, @PathVariable double n2){
        return n1-n2;
    }
    @GetMapping("/divide/{n1}/{n2}")
    public double myDivide(@PathVariable double n1, @PathVariable double n2){
        return n1/n2;
    }
    @GetMapping("/multi/{n1}/{n2}")
    public double myMulti(@PathVariable double n1, @PathVariable double n2){
        return n1*n2;
    }
    @GetMapping("/mod/{n1}/{n2}")
    public double myMod(@PathVariable double n1, @PathVariable double n2){
        return n1%n2;
    }
    @PostMapping("/max")
    public double myMax(@RequestParam double n1, @RequestParam double n2){
        return Math.max(n1,n2);
    }
}
