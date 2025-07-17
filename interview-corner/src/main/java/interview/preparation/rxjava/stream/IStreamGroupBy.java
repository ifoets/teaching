package interview.preparation.rxjava.stream;

import interview.preparation.rxjava.stream.model.Pair;
import interview.preparation.rxjava.stream.records.*;
import interview.preparation.rxjava.stream.records.enums.OrderStatus;
import interview.preparation.rxjava.stream.records.enums.TransactionStatus;
import interview.preparation.rxjava.stream.records.enums.TransactionType;
import interview.preparation.rxjava.stream.records.keys.FlightOperationKey;
import interview.preparation.rxjava.stream.records.keys.ProductStaticsKey;
import interview.preparation.rxjava.stream.records.keys.TransactionKey;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface IStreamGroupBy {
/**1. Basic Grouping**/
    /** Group List<String> by their first character.**/
    Map<Character, List<String>> groupByFirstChar(List<List<String>> ll);

    /**Group by String start with vowels and consonant*/
    Map<Boolean, List<String>> segregateByFirstCharVowels(List<List<String>> ll);

    /**Group a list of Employee by department.**/
    Map<String, List<Employee>> groupByDepartment(List<Employee> list);

    /**Group a list of Employee by name add department.having group size>1**/
    Map<String, List<Employee>> groupByNameAndDepartment(List<Employee> list);

    /**Group a list of Employee by name add department.having group size>1 and age>=25**/
    Map<String, List<Employee>> groupByNameAndDepartmentAndAgeLimit(List<Employee> list);

    /**Group integers by even/odd using groupingBy(num -> num % 2 == 0 ? "Even" : "Odd").*/
    Map<String,List<Integer>> segregateEvenOdd(List<Integer> list);

    /**Group integers by Fizz(%3),Buzz(%5),FizzBuzz(%3&&%5) or NotFizBz by*/
    Map<String,List<Integer>> segregateFizzBuzz(List<Integer> list);

    /**Group Employee name/words by their lengths.*/
    Map<Integer, List<String>> groupByLengthWords(List<Employee> list);

/**2. Grouping with Downstream Collectors**/
    /**Group Employee by department and count them:groupingBy(Employee::getDept, counting())*/
    Map<String,Long> groupByDeptCount(List<Employee> list);

    /**Group Person by city, and collect names as Set<String>.**/
    Map<String, Set<String>> groupByCityUniqueName(List<Person> list);

    /**Group Product by category and get average price.**/
    Map<String, Double> groupBYProdCatAvgPrice(List<Product> list);

    /**Group Student by class, and find the top scorer in each class.*/
    Map<String, Optional<Student>> findToScorerStudentsByClass(List<Student> list);

    /**Group orders by status and get the total price per status.**/
    Map<OrderStatus,Double> groupByOrderStatusTotalPrice(List<Order> list);

/**3. Grouping with Nested Collections**/
    /**Group Employee by location, then by department.*/
    Map<String,Map<String,List<Employee>>> groupByLocThenByDept(List<Employee> list);

    /**Group books by genre, and within each genre, group by author.*/
    Map<String,Map<String, List<String>>> groupBookByGenreWithinGroupByAuth(List<Book> list);

    /**Group Transaction by year, then month, then status.*/
    Map<Integer,Map<Integer,Map<TransactionStatus, List<TransactionType>>>> groupByYearThenMonthThenStatus(List<Transaction> list);

    /**From List<Employee>, group by managerId, and for each manager get employee names sorted by age.*/
    Map<Integer, List<String>> groupByMgrIdOrderBYAge(List<EmpMgr> list);

/** 4. Grouping with Complex Objects**/
    /** Group list of Person(name, city, age) by city and return average age.*/
    Map<String,Double> collectAverageAgeInCity(List<Person> list);

    /**Group a list of Employee by department and collect oldest employee per department.*/
    Map<String, Integer> collectOldestEmpInEachDept(List<Employee> list);

    /**Group books by title length range (short <10, medium <20, long).*/
    Map<String, List<String>> groupBookTitleLen(List<Book> list);

    /**Group by custom category using groupingBy(e -> classify(e))*/
    Map<String,List<Double>> groupByAmountClassify(List<Transaction> list);

/** 5. Grouping with Multiple Keys (Composite)**/
    /**Group Transaction Status by (year, month) composite key using toMap or custom class as key.**/
    Map<TransactionKey,List<TransactionStatus>> groupByCompositeKeyYearMonth(List<Transaction> list);

    /**Group flights by (origin, destination) and count total flights.*/
    Map<FlightOperationKey, Long> groupNoOfFlightSrcBtnDestination(List<Flight> flights);

    /**group flight name and amount between src and destination**/
    Map<String, List<String>> groupSrcDestination(List<Flight> flights);

    /**Group employees by (department + location) and sum salaries.**/
    Map<String,Map<String,Double>> collectSalAtOrigenDept(List<Employee> list);

    /**Group data into a Map<Pair<String, Integer>, List<Obj>>.**/
    Map<Pair<String,String>,List<Person>> pairPersonByCityName(List<Person> list);

/**6. Aggregations After Grouping*/
    /**Group and then find max, min, or sum using reducing or collectingAndThen.**/
    Map<String, Double> findAggregateInGroup(List<Employee> list);
    Map<String, Optional<Employee>> findMaxInGroup(List<Employee> list);

    /**Group by region and get top 3 highest-revenue customers per region.*/
    Map<String,List<Double>> findTopRevenueInEveryReason(List<Customer> list);

    /**Group sales by region and get the product with max quantity per region.*/
    Map<String,Optional<Sale>> getProductMaxQualityInRegion(List<Sale> list);

    /**For each product category, calculate total sales, average price, min price.*/
    Map<String, ProductStaticsKey> getProductStatics(List<Product> list);

/** 7. Grouping with Custom Collector / Immutable Map**/
    /**Group and collect to unmodifiable map:
     Collectors.collectingAndThen(groupingBy(...), Collections::unmodifiableMap)*/
    Map<String,List<Student>> groupByUnmodifiableMap(List<Student> list);

    /**Group and use a TreeMap to keep keys sorted:
     Collectors.groupingBy(..., TreeMap::new, downstream)*/
    Map<String, List<String>> keepKeySortedGroup(List<Student> list);

    /**Designing, Build your own custom collector to group into a map with reverse insertion order.*/

/** 8. Partitioning (a specialized grouping case)*/
    /**Partition students by passing/failing grades.*/
    Map<Boolean,List<String>> groupByFailPassStud(List<Student> list);

    /**Partition numbers by prime vs non-prime.*/
    Map<Boolean, List<Integer>> segregatePrimeNonPrimePredicate(List<Integer> list);

    /**Partition strings by palindrome or not.**/
    Map<Boolean, List<String>> segregatePalindrome(List<List<String>> list);

    /**Partition employees by age > 40, and then count per group.**/
    Map<Boolean,Long> empOldYoungCount(List<Employee> list);

/**9. Real-World Business Scenarios*/
    /**Group orders by customer and calculate total order value per customer.*/
    Map<String,Long> totalOrderByPerCustomer(List<Order> list);

    /**Group flights by airline and find the flight with max distance/amount.**/
    Map<String,Map<String,Integer>> groupByAirlineFlightMaxDistance(List<Flight> list);

}
