package interview.preparation.newjava.java8;
/*How It Works Internally
    Uses Fork/Join Framework
    Breaks data into subtasks
    Each task runs in a separate ForkJoinPool worker thread
    Results are combined (joined) at the end
*/
import java.util.List;
import java.util.Map;

public interface IParallelStream {

    /**1. Order Loss**/
    List<String> orderLoss(List<Integer> list);

    /** Performance Tip, 2-8 times faster depends up on the cores4-32*/
    Map<Long,List<Integer>> checkPerformance(List<Integer> list);

    /**2. Thread-Safety, You must not modify shared data inside a parallel stream unless it’s thread-safe.**/
    List<Integer> addTwoListOnIndexes(List<Integer> list1, List<Integer> list2);

    /**get sum of large nos keep performance in mind**/;
    Integer getSum(int[] a);

    /**find max or min keep performance in mind*/
    Integer getMaxOrMin(int[] a, boolean maxOrMin);
}
