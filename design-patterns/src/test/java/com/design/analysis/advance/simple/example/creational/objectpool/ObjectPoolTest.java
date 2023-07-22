package com.design.analysis.advance.simple.example.creational.objectpool;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.sql.Connection;

public class ObjectPoolTest {
    JdbcConnectionPool pool;

    @Before
    public void init()
    {
        pool = new JdbcConnectionPool( "org.hsqldb.jdbcDriver", "jdbc:hsqldb: //localhost/mydb",
                "sa", "password");
    }

    @Ignore
    @Test
    public  void objectPoolTest()
    {
        // Get a connection:
        Connection con = pool.takeOut();
        // Return the connection:
        pool.takeIn(con);
    }
}
