package rx.design.analysis.rx;

import rx.design.analysis.rx.record.EmpOrder;
import rx.design.analysis.rx.record.Order;

import java.util.Arrays;
import java.util.List;

public class RxJavaDataUtils {

    public static List<List<String>> getListOfString()
    {
        return Arrays.asList(
            Arrays.asList("A", "B"),
            Arrays.asList("C", "D"),
            List.of("E")
        );
    }

    public static List<String> getStrings()
    {
        return
            List.of(
                "abhi","kumar","abhimanyu","suman","kumar abhi","abhikumar","abkumar"
            );
    }
public static List<EmpOrder> getEmpOrders()
{
    return
        List.of(
            new EmpOrder("user1", "o1", 100),
            new EmpOrder("user2", "o2", 200),
            new EmpOrder("user1", "o3", 150),
            new EmpOrder("user2", "o4", 50),
            new EmpOrder("user3", "o5", 300)
        );
}

}
