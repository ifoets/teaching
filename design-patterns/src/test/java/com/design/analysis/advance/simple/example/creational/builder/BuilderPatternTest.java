package com.design.analysis.advance.simple.example.creational.builder;

import com.design.analysis.advance.simple.example.creational.builder.User;
import com.design.analysis.advance.simple.example.creational.builder.UserBuilder;
import org.junit.Before;
import org.junit.Test;

public class BuilderPatternTest {

    UserBuilder userBuilder;
    @Before
    public void init()
    {
        userBuilder = new UserBuilder("abhimanyu","kumar");
    }

    @Test
    public void builderPatternTest()
    {
        User user1 = new UserBuilder("Lokesh", "Gupta")
                .age(30)
                .phone("1234567")
                .address("Fake address 1234")
                .build();

        System.out.println(user1);

        User user2 = new UserBuilder("Jack", "Reacher")
                .age(40)
                .phone("5655")
                //no address
                .build();

        System.out.println(user2);

        User user3 = new UserBuilder("Super", "Man")
                //No age
                //No phone
                //no address
                .build();

        System.out.println(user3);
    }
}
