package interview.preparation.java21;

import interview.preparation.newjava.java21.model.*;

import java.util.List;

public class RecordsUtils {

    public static List<Object> getRecords()
    {
        return
            List.of(
                new Circle(10d),
                new Line(new Point(1,2), new Point(10,20)),
                new Rectangle(10,20),
                new Point(1,2),

                new Circle(20d),
                new Line(new Point(10,20), new Point(100,200)),
                new Rectangle(100,200),
                new Point(10,20),

                new ColoredCircle(20d,"red"),
                new ColoredLine(new Point(10,20), new Point(100,200),"Green"),
                new ColoredRectangle(100,200,"Blue"),
                new ColoredPoint(10,20,"Yellow")
            );
    }
}
