package interview.preparation.java17;

import interview.preparation.newjava.java17.IJava17;
import interview.preparation.newjava.java17.Java17Impl;
import interview.preparation.newjava.java17.record.RecordUtils;
import interview.preparation.newjava.java17.sealedclass.Rectangle;
import interview.preparation.newjava.java17.sealedclass.Square;
import interview.preparation.newjava.java17.sealedclass.Triangle;
import interview.preparation.newjava.java17.switchexpr.Position;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IJava17Test {

    IJava17 ij;

    @Before
    public void init()
    {
        ij = new Java17Impl();
    }
    /*Pattern Matching – instanceOf Feature*/
    @Test
    public void instanceOfPatternMatchingTest()
    {
        Object o = "I am a string as an object";
        Assert.assertTrue(ij.instanceOfPatternMatching(o).equalsIgnoreCase((String) o));
       try
       {
           ij.instanceOfPatternMatching(123);
       }catch (RuntimeException e)
       {
           Assert.assertTrue(e.getMessage().equals("Please provide String"));
       }
    }
    @Test
    public void recordXTest() {
        RecordUtils.Footballer footballer = ij.recordX("Ronaldo", 36, "Manchester United");
        //Getters without get prefix
        System.out.println("Footballer's name: " + footballer.getName());
        System.out.println("Footballer's age: " + footballer.getAge());
        record Basketballer(String name, int age) { }
        // equals
        boolean isFootballer1 = footballer.equals(ij.recordX("Ozil", 32, "Fenerbahce")); // false
        System.out.println("Is first one footballer? " + isFootballer1);
        boolean isFootballer2 = footballer.equals(new Basketballer("Lebron", 36)); // false
        System.out.println("Is second one footballer? " + isFootballer2);
        boolean isFootballer3 = footballer.equals(ij.recordX("Ronaldo", 36, "Manchester United")); // true
        System.out.println("Is third one footballer? " + isFootballer3);
        //hashcode
        int hashCode = footballer.hashCode(); // depends on values of x and y
        System.out.println("Hash Code of Record: " + hashCode);
        //toString
        String toStringOfRecord = footballer.toString();
        System.out.println("ToString of Record: " + toStringOfRecord);
    }
    @Test
    public void recordYTest() {
        RecordUtils.Engineer engineer1 = ij.recordY("Onur", 39);
        System.out.println(engineer1);
        Assert.assertEquals("ONUR", engineer1.name());
        try
        {
            ij.recordY("Alex", 0);
        }catch (RuntimeException e)
        {
            Assert.assertTrue(e.getMessage().equals("Age less than 1 is not allowed!"));
        }
    }

    @Test
    public void shapeTest() {
        /**
         * Permitted classes RECTANGLE and SQUARE
         */
        //Rectangle Declaration and tests
        Rectangle rectangle = ij.getRectangle(3, 5);
        Assert.assertEquals(16, rectangle.getPerimeter());
        Assert.assertEquals(15, rectangle.getArea(3, 5));
        //Square Declaration and tests
        Square square = ij.getSquare(3, 3);
        Assert.assertEquals(12, square.getPerimeter());
        Assert.assertEquals(9, square.getArea(3, 3));
        /**
         * Unpermitted Class TRIANGLE
         */
        Triangle triangle = ij.getTriangle(6, 5, 5, 4);
        Assert.assertEquals(16, triangle.getPerimeter());
        Assert.assertEquals(12, triangle.getArea());
    }
    /*Switch Expressions*/
    @Test
    public void newSwitchExpressionTest(){
        ij.newSwitchExpression(Position.GOALKEEPER);
        ij.newSwitchExpression(Position.MIDFIELDER);
        ij.newSwitchExpression(Position.BENCH);
    }
    @Test
    public void newSwitchExpressionWithAssignmentTest()
    {
        ij.newSwitchExpressionWithAssignment(Position.GOALKEEPER);
        ij.newSwitchExpressionWithAssignment(Position.STRIKER);
        ij.newSwitchExpressionWithAssignment(Position.BENCH);
    }
    /*Text Blocks*/
    @Test
    public void textBlocksTest()
    {
     ij.textBlocks();
    }
    /**
     * We can make the same text one-liner with the "\" character. Let's see the example below.
     */
    @Test
    public void textBlocksNoLineBreaksTest()
    {
     ij.textBlocksNoLineBreaks();
    }
    /* We can insert variables into a text block by using the static method String::format or with the String::formatted.
     */
    @Test
    public void textBlocksInsertingVariablesTest()
    {
     ij.textBlocksInsertingVariables();
    }
}
