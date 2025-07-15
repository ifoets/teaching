package interview.preparation.java11;
/*New Features in Java 11*/
import interview.preparation.newjava.java11.IJava11;
import interview.preparation.newjava.java11.Java11Impl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

public class IJava11Test {
    IJava11 ij;

    @Before
    public void init()
    {
        ij = new Java11Impl();
    }

    /* new methods to the String class: isBlank, lines, strip, stripLeading, stripTrailing, and repeat.*/
    @Test
    public void strOperationTest() {
        String str ="Baeldung helps \n \n developers \n explore Java.";
       Assert.assertTrue(ij.strOperation(str).containsAll(List.of("Baeldung helps", "developersdevelopers", "explore Java.")));
    }

    @Test
    public void readFilesStrTest() throws IOException {
        Assert.assertTrue(ij.readFilesStr("src/common/","Sample text").equals("Sample text"));
    }
    /*Collection to an Array*/
    @Test
    public void collectionToArrayTest()
    {
       System.out.println(Arrays.toString(ij.collectionToArray(List.of("Java", "Kotlin"))));
    }
    /*The Not Predicate Method*/
    @Test
    public void notPredicateTest()
    {
        Assert.assertTrue(ij.notPredicate(Arrays.asList("Java", "\n \n", "Kotlin", " ")).containsAll(List.of("Java","Kotlin")));
    }
    /* Local-Variable Syntax for Lambda*/
    @Test
    public void localVarialeTest()
    {
        Assert.assertTrue(ij.localVariable(Arrays.asList("Java", "\n \n", "Kotlin", " ")).containsAll(List.of("JAVA","KOTLIN")));
    }
    /* HTTP Client*/
    @Ignore
    @Test
    public void getHttpResponseTest() throws IOException, InterruptedException{
          HttpResponse httpResponse = ij.getHttpResponse("https://www.google.com");
          System.out.println(httpResponse.headers().allValues("content-type").get(0));
    }
    /* Nest Based Access Control*/
    @Test
    public void getNestedClassNameTest()
    {
       System.out.println(ij.getNestedClassName());
    }
}
