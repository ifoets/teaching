package com.design.analysis.advance.simple.example.j2ee.presentation.interceptingpattern;

public class AuthenticationFilter implements Filter{
    @Override
    public void execute(String str) {
        System.out.println("Authenticating :"+str);
    }
}
