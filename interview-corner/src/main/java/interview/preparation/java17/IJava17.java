package interview.preparation.java17;

import interview.preparation.java17.record.RecordUtils;
import interview.preparation.java17.sealedclass.Rectangle;
import interview.preparation.java17.sealedclass.Square;
import interview.preparation.java17.sealedclass.Triangle;
import interview.preparation.java17.switchexpr.Position;

public interface IJava17 {

    /*Pattern Matching – instanceOf Feature*/
    public String instanceOfPatternMatching(Object ob) throws RuntimeException;

    /*Records in Java*/
    public RecordUtils.Footballer recordX(String name, int age, String team);
    public RecordUtils.Engineer recordY(String name, int age);

    /*Sealed class, interfaces*/
    public Square getSquare(int edge1,  int edge2);
    public Rectangle getRectangle(int base, int height);
    public Triangle getTriangle(int base, int edge1, int edge2, int height);

    /*Switch Expressions*/
    public void newSwitchExpression(Position randomPosition);
    public void newSwitchExpressionWithAssignment(Position randomPosition);

    /*Text Blocks*/
    public void textBlocks();
    /**
     * We can make the same text one-liner with the "\" character. Let's see the example below.
     */
    public void textBlocksNoLineBreaks();
    /**
     * We can insert variables into a text block by using the static method String::format or with the String::formatted.
     */
    public void textBlocksInsertingVariables();
}
