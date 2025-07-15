package interview.preparation.newjava.java17;

import interview.preparation.newjava.java17.record.RecordUtils;
import interview.preparation.newjava.java17.sealedclass.Rectangle;
import interview.preparation.newjava.java17.sealedclass.Square;
import interview.preparation.newjava.java17.sealedclass.Triangle;
import interview.preparation.newjava.java17.switchexpr.Position;

import java.util.Locale;

public class Java17Impl implements IJava17{

    /*Pattern Matching – instanceOf Feature*/
    @Override
    public String instanceOfPatternMatching(Object obj) throws  RuntimeException
    {
       if(obj instanceof String str)
           return str.toUpperCase();
       else if(obj instanceof String str && !str.isEmpty()) {
           return str.toUpperCase(Locale.ROOT);
       }
       throw new RuntimeException("Please provide String");
    }

    /*Records in Java*/
    @Override
    public RecordUtils.Footballer recordX(String name, int age, String team){
        RecordUtils.Footballer footballer = new RecordUtils.Footballer(name, age, team);
        return  footballer;
    }
    public RecordUtils.Engineer recordY(String name, int age){
        RecordUtils.Engineer engineer = new RecordUtils.Engineer(name, age);
        return engineer;
    }

    public Square getSquare(int edge1, int edge2){
        return new Square(edge1,edge2);
    }
    public Rectangle getRectangle(int base, int height){
        return new Rectangle(base,height);
    }

    public Triangle getTriangle(int base, int edge1, int edge2, int height){
        return new Triangle(base,edge1,edge2,height);
    }
    /*Switch Expressions*/
    @Override
    public void newSwitchExpression(Position randomPosition) {
        switch (randomPosition) {
            case GOALKEEPER -> System.out.println("Goal Keeper: Buffon");
            case DEFENCE -> System.out.println("Defence: Ramos");
            case MIDFIELDER -> System.out.println("Midfielder: Messi");
            case STRIKER -> System.out.println("Striker: Zlatan");
            default -> System.out.println("Please select a footballer from the BENCH!");
        }
    }
    public void newSwitchExpressionWithAssignment(Position randomPosition) {
        String footballer = switch (randomPosition) {
            case GOALKEEPER, DEFENCE -> {
                System.out.println("Defensive Footballer Selection!");
                yield "Defence: Ramos";
            }
            case MIDFIELDER, STRIKER -> {
                System.out.println("Offensive Footballer Selection!");
                yield "Midfielder: Messi";
            }
            default -> "Please select a footballer from the BENCH!";
        };
        System.out.println(footballer);
    }

    /**
     * A text block can be declared by starting with three double quotes """ which should be followed by a line break and
     * closed by three double quotes again.
     */
   @Override
    public void textBlocks() {
        String textBlockFootballers = """
        Footballers
          with double space indentation
            and "SW TEST ACADEMY TEAM" Rocks!
        """;
        System.out.println(textBlockFootballers);
    }
    /**
     * We can make the same text one-liner with the "\" character. Let's see the example below.
     */
    @Override
    public void textBlocksNoLineBreaks() {
        String textBlockFootballers = """
        Footballers \
        with double space indentation \
        and "SW TEST ACADEMY TEAM" Rocks! \
        """;
        System.out.println(textBlockFootballers);
    }

    /**
     * We can insert variables into a text block by using the static method String::format or with the String::formatted.
     */
    @Override
    public void textBlocksInsertingVariables() {
        String textBlockFootballers = """
        Footballers
          with double space indentation
            and "%s" Rocks!
        """.formatted("SW TEST ACADEMY TEAM");
        System.out.println(textBlockFootballers);
    }
}
