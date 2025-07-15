package interview.preparation.newjava.java21;

import interview.preparation.newjava.java21.model.Point;

import java.util.List;
import java.util.Map;

public interface IRecordPattern {

/** use instance of**/
List<Point> collectLineInstanceOf(List<Object> objects);

/** use switch collect different record*/
Map<String, Object> collectColoredRecords(List<Object> objects);
}
