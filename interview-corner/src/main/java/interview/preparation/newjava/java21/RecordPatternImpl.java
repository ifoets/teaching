package interview.preparation.newjava.java21;

import interview.preparation.newjava.java21.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecordPatternImpl implements IRecordPattern{

    /** use instance of**/
    @Override
   public List<Point> collectLineInstanceOf(List<Object> objects){
        return objects.stream().filter(o-> o instanceof Point(int x, int y))
            .map(p-> (Point)p)
            .toList();
    }

    /** use switch collect different record*/
    public Map<String, Object> collectColoredRecords(List<Object> objects){
        Map<String, Object> map = new HashMap<>();

        for(Object shape: objects)
        {
            switch (shape)
            {
                case ColoredPoint(int x, int y, String color) -> map.put(((ColoredPoint)shape).color(), shape);
                case ColoredCircle(_,_) -> map.put(((ColoredCircle)shape).color(),shape);
                case ColoredLine(_,_,_) -> map.put(((ColoredLine)shape).color(),shape);
                case ColoredRectangle(_,_,_) -> map.put(((ColoredRectangle)shape).color(),shape);
                default -> System.out.print("");
            }
        }
        return map;
    }
}
