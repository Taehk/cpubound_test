package com.playdata.cpubouindapp.controller;

import jakarta.xml.bind.DatatypeConverter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@RestController
//@RequestMapping("apps")
public class AppController {
    @RequestMapping("/hash/{input}")
    public String getDigest(@PathVariable("input") String input) throws NoSuchAlgorithmException {
        for(int i = 0; i < 100_000; i++) {
            input = getMD5Digest(input);
        }
        int n2 = 123;
        int price = 12_000_210;
        return input;
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello ci/cd test rolling deploy test";
    }

    private String getMD5Digest(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(input.getBytes());
        byte[] digest = md.digest();

        return DatatypeConverter
                .printHexBinary(digest).toUpperCase();
    }
}
