package com.design.analysis.advance.simple.example.j2ee.presentation.frontcontroller;

import static java.lang.System.*;

@FunctionalInterface
public interface View {
    public void show();
}
 class HomeView implements View {
     @Override
     public void show() {
         System.out.println("Displaying Home Page");
     }
 }

 class StudentView {
    public void show() {
        out.println("Displaying Student Page");
    }
}

 class ErrorView {
    public void show() {
        out.println("Displaying Error Page");
    }
}

 class DashboardView {
    public void show() {
        out.println("Displaying Dashboard Page");
    }
}
