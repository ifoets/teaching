package interview.preparation.rxjava.stream;

import interview.preparation.rxjava.stream.model.Pair;
import interview.preparation.rxjava.stream.records.*;
import interview.preparation.rxjava.stream.records.enums.OrderStatus;
import interview.preparation.rxjava.stream.records.enums.TransactionStatus;
import interview.preparation.rxjava.stream.records.enums.TransactionType;
import interview.preparation.rxjava.stream.records.keys.FlightOperationKey;
import interview.preparation.rxjava.stream.records.keys.ProductStaticsKey;
import interview.preparation.rxjava.stream.records.keys.TransactionKey;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamGroupByImpl implements IStreamGroupBy {
/**1. Basic Grouping**/
    /** Group List<String> by their first character.**/
    @Override
    public Map<Character, List<String>> groupByFirstChar(List<List<String>> ll){
        return
        ll.stream().flatMap(Collection::stream).collect(
            Collectors.groupingBy(
                s-> s.toCharArray()[0],
                 Collectors.toList()
            )
        );
         /* or ll.stream().<String>mapMulti( (list, consumer) ->
                {
                    for(String str:list)
                        consumer.accept(str);
                }
            ).collect(Collectors.groupingBy(
               e->e.toCharArray()[0],
               Collectors.toList()
            ));*/
    }
    @Override
    public Map<Boolean, List<String>> segregateByFirstCharVowels(List<List<String>> ll){
        Set<Character> set = Set.of('a','e','i','o','u');
        Predicate<String> predicateFirstChar = e -> set.contains(e.charAt(0));
        return ll.stream().flatMap(Collection::stream)
            .collect(
                Collectors.partitioningBy(predicateFirstChar)
            );
    }
    @Override
    /**Group a list of Employee by department.**/
    public Map<String, List<Employee>> groupByDepartment(List<Employee> list){
        return list.stream()
            .collect(
              Collectors.groupingBy(
                  Employee::department,
                  Collectors.toList()
              )
            );
    }

    /**Group a list of Employee by name add department collect where group size>1**/
    @Override
    public Map<String, List<Employee>> groupByNameAndDepartment(List<Employee> list){
        return
            list.stream()
                .collect(
                    Collectors.groupingBy(
                        Employee::getDepartmentAndName,
                        Collectors.toList()
                    )
                )
                .entrySet()
                .stream()
                .filter( e-> e.getValue().size()>1)
                .collect(Collectors.toMap(
                   Map.Entry::getKey,
                    Map.Entry::getValue,
                    (e1,e2)->e1,
                    LinkedHashMap::new
                ));
    }

    /**Group a list of Employee by name add department and age>=5 having group size>1 and **/
    @Override
    public Map<String, List<Employee>> groupByNameAndDepartmentAndAgeLimit(List<Employee> list){
     return
     list.stream()
         .collect(
             Collectors.groupingBy(
                 Employee::getDepartmentAndName,
                 Collectors.filtering(e->e.age()>=5,Collectors.toList())
             )
         )
         .entrySet()
         .stream()
         .filter( e-> e.getValue().size()>1)
         .collect(
             Collectors.toMap(
                 Map.Entry::getKey,
                 Map.Entry::getValue,
                 (e1,e2)->e1,
                 LinkedHashMap::new
             )
         );
    }
    /**Group integers by even/odd using groupingBy(num -> num % 2 == 0 ? "Even" : "Odd").*/
    @Override
    public Map<String,List<Integer>> segregateEvenOdd(List<Integer> list){
        return
            list.stream()
                .collect(Collectors.groupingBy(
                    num -> num % 2 == 0 ? "Even" : "Odd",
                    Collectors.toList()
                ));
    }

    /**Group integers by Fizz(%3),Buzz(%5),FizzBuzz(%3&&%5) or NotFizzBzz by*/
    @Override
    public Map<String,List<Integer>> segregateFizzBuzz(List<Integer> list){
        return
            list.stream()
                .collect(
                    Collectors.groupingBy(
                        i-> i%3==0 && i%5 ==0 ? "FizzBuzz" : i%3==0 ? "Fizz" : i%5==0 ? "Buzz" : "NotFizzBzz",
                        Collectors.toList()
                    )
                );
    }

    /**Group Employee name/words by their lengths.*/
    @Override
    public Map<Integer, List<String>> groupByLengthWords(List<Employee> list){
        return
            list.stream().map(Employee::name)
                .collect(
                    Collectors.groupingBy(
                        String::length,
                        Collectors.toList()
                    )
                );
    }

/**2. Grouping with Downstream Collectors**/
    /**Group Employee by department and count them:groupingBy(Employee::getDept, counting())*/
    @Override
    public Map<String,Long> groupByDeptCount(List<Employee> list){
        return
            list.stream()
                .collect(
                    Collectors.groupingBy(
                        Employee::department,
                        Collectors.counting()
                    )
                );
    }
    /**Group Person by city, and collect names as Set<String>.**/
    @Override
    public Map<String, Set<String>> groupByCityUniqueName(List<Person> list){
       return
           list.stream()
               .collect(
                   Collectors.groupingBy(
                       Person::city,
                       Collectors.mapping(Person::name, Collectors.toSet())
                   )
               );
    }

    /**Group Product by sorted category and get average price **/
    @Override
    public Map<String, Double> groupBYProdCatAvgPrice(List<Product> list){
        return
            list.stream()
                .collect(
                    Collectors.groupingBy(
                        Product::category,
                        TreeMap::new,
                        Collectors.averagingDouble(Product::price)
                    )
                );
    }

    /**Group Student by class, and find the top scorer in each class.*/
    @Override
    public Map<String,Optional<Student>> findToScorerStudentsByClass(List<Student> list){
        return
            list.stream()
                .collect(
                    Collectors.groupingBy(
                        Student::subject,
                        Collectors.maxBy(Comparator.comparing(Student::marks))
                        )
                    );
    }

    /**Group orders by status and get the total price per status.**/
    @Override
    public Map<OrderStatus,Double> groupByOrderStatusTotalPrice(List<Order> list){
        return
            list.stream()
                .collect(Collectors.groupingBy(
                    Order::status,
                    Collectors.summingDouble(Order::amount)
                ));

    }

/**3. Grouping with Nested Collections**/
    /**Group Employee by location, then by department.*/
    @Override
    public Map<String,Map<String,List<Employee>>> groupByLocThenByDept(List<Employee> list){
        return
            list.stream()
                .collect(
                    Collectors.groupingBy(
                        Employee::location,
                        Collectors.groupingBy(
                            Employee::department,
                            Collectors.toList()
                        )
                    )
                );
    }
    /**Group books by genre, and within each genre, group by author.*/
    @Override
    public Map<String,Map<String, List<String>>> groupBookByGenreWithinGroupByAuth(List<Book> list){
        return
            list.stream()
                .collect(
                    Collectors.groupingBy(
                        Book::genre,
                        Collectors.groupingBy(
                            Book::author,
                            Collectors.mapping(Book::title, Collectors.toList())
                        )
                    )
                );
    }

    /**Group Transaction by year, then month, then status.*/
    @Override
    public Map<Integer,Map<Integer,Map<TransactionStatus, List<TransactionType>>>> groupByYearThenMonthThenStatus(List<Transaction> list){
        return
            list.stream()
                .collect(Collectors.groupingBy(
                    (e)-> e.date().getYear(),
                    Collectors.groupingBy(
                        e->e.date().getDayOfMonth(),
                        Collectors.groupingBy(
                            Transaction::transactionStatus,
                            Collectors.mapping(Transaction::transactionType, Collectors.toList())
                        )
                    )
                ));
    }

    /**From List<Employee>, group by managerId(order by), and for each manager get employee names sorted by age.*/
    @Override
    public Map<Integer, List<String>> groupByMgrIdOrderBYAge(List<EmpMgr> list){
        return
            list.stream()
                .collect(Collectors.groupingBy(
                    EmpMgr::mgrId,
                    TreeMap::new,
                    Collectors.collectingAndThen(
                        Collectors.toList(),
                        listNew -> listNew.stream().sorted(Comparator.comparing(EmpMgr::age))
                            .map(EmpMgr::empName).toList()
                    )
                    )
                );
    }
/** 4. Grouping with Complex Objects**/
    /** Group list of Person(name, city, age) by city and return average age.*/
    @Override
    public Map<String,Double> collectAverageAgeInCity(List<Person> list){
        return
            list.stream()
                .collect(
                  Collectors.groupingBy(
                      Person::city,
                      Collectors.averagingDouble(Person::age)
                  )
                );
    }

    /**Group a list of Employee by department and collect oldest employee per department.*/
    @Override
    public Map<String, Integer> collectOldestEmpInEachDept(List<Employee> list){
        return
            list.stream()
                .collect(Collectors.groupingBy(
                    Employee::department,
                    Collectors.collectingAndThen(
                        Collectors.toList(),
                        ll -> ll.stream().sorted(
                            Comparator.comparing(
                                Employee::age).reversed())
                            .map(Employee::age).findFirst().orElseThrow()
                    ))
                );
    }

    /**Group books by title length range (short <10, medium <20, long).*/
    @Override
    public Map<String, List<String>> groupBookTitleLen(List<Book> list){
       return
           list.stream()
               .collect(
                   Collectors.groupingBy(
                       e-> e.title().length()<10 ? "Short-Title" : e.title().length()<20 ? "Medium-Title"
                           :"Long-Title",
                       Collectors.mapping(Book::title, Collectors.toList())
                   )
               );
    }

    /**Group by custom category using groupingBy(e -> classify(e))*/
    @Override
    public Map<String,List<Double>> groupByAmountClassify(List<Transaction> list){

        return
            list.stream()
                .collect(Collectors.groupingBy(
                    this::classifyAmount,
                    Collectors.mapping(Transaction::amount, Collectors.toList())
                ));
    }
    public String classifyAmount(Transaction tx)
    {
        double amount = tx.amount();
        if(amount<500) return "SMALL";
        else if(amount<1000) return "MEDIUM";
        return "LARGE";
    }

    /** 5. Grouping with Multiple Keys (Composite)**/
    /**Group Transaction Status by (year, month) composite key using toMap or custom class as key.**/
    @Override
    public Map<TransactionKey,List<TransactionStatus>> groupByCompositeKeyYearMonth(List<Transaction> list){
        return
            list.stream()
                .collect(Collectors.groupingBy(
                    tx-> new TransactionKey(tx.date().getYear(),tx.date().getMonthValue()),
                    Collectors.mapping(Transaction::transactionStatus, Collectors.toList())
                ));
    }

    /**Group flights by (origin, destination) and count total flights.*/
    @Override
    public Map<FlightOperationKey, Long> groupNoOfFlightSrcBtnDestination(List<Flight> flights){
        return
            flights.stream()
                .collect(Collectors.groupingBy(
                    flight -> new FlightOperationKey(flight.src(),flight.destination()),
                    Collectors.counting()
                ));
    }

    /**group flight name and amount between src and destination**/
    @Override
    public Map<String, List<String>> groupSrcDestination(List<Flight> flights){
        return
            flights.stream()
                .collect(Collectors.groupingBy(
                    Flight::getOperational,
                    Collectors.mapping(Flight::getFlightAmount, Collectors.toList())
                ));
    }

    /**Group employees by (department + location) and sum salaries.**/
    @Override
    public Map<String,Map<String,Double>> collectSalAtOrigenDept(List<Employee> list){
        return
            list.stream()
                .collect(Collectors.groupingBy(
                    Employee::location,
                    Collectors.groupingBy(
                        Employee::department,
                        Collectors.summingDouble(Employee::sal)
                    )
                ));
    }

    /**Group data into a Map<Pair<String, Integer>, List<Obj>>.**/
    @Override
    public Map<Pair<String,String>,List<Person>> pairPersonByCityName(List<Person> list){
        return
            list.stream()
                .collect(
                    Collectors.groupingBy(
                        p -> new Pair<>(p.city(),p.name()),
                        Collectors.toList()
                    )
                );

    }

/**6. Aggregations After Grouping*/
    /**Group and then find max, min, or sum, avg using reducing or collectingAndThen.**/
    @Override
    public Map<String, Double> findAggregateInGroup(List<Employee> list){
        return
            list.stream()
                .collect(Collectors.groupingBy(
                    Employee::department,
                    Collectors.averagingDouble(Employee::sal)
                ));
    }
    @Override
    public Map<String, Optional<Employee>> findMaxInGroup(List<Employee> list){
        return
            list.stream()
                .collect(Collectors.groupingBy(
                    Employee::department,
                    Collectors.maxBy(Comparator.comparing(Employee::sal))
                ));

    }

    /**Group by region and get top 3 highest-revenue customers per region.*/
    @Override
    public Map<String,List<Double>> findTopRevenueInEveryReason(List<Customer> list){
        return
            list.stream()
                .collect(Collectors.groupingBy(
                    Customer::region,
                    Collectors.collectingAndThen(
                        Collectors.<Customer>toList(),
                        lt ->
                        {
                            List<Double> revneueList = lt.stream().sorted(Comparator.comparing(Customer::revenue).reversed()).map(Customer::revenue).toList();
                            return revneueList.size()<=3 ? revneueList : revneueList.subList(0,3);
                        }
                    )
                ));
    }

    /**Group sales by region and get the product with max quantity per region.*/
    @Override
    public Map<String,Optional<Sale>> getProductMaxQualityInRegion(List<Sale> list){
        return
            list.stream()
                .collect(
                    Collectors.groupingBy(
                        Sale::region,
                        Collectors.maxBy(Comparator.comparing(Sale::quantity))
                    )
                );
    }

    /**For each product category, calculate total sales, average price, min price.*/
    @Override
    public Map<String, ProductStaticsKey> getProductStatics(List<Product> list) {
        return
            list.stream()
                .collect(Collectors.groupingBy(
                    Product::name,
                    Collectors.collectingAndThen(
                        Collectors.toList(),
                        products ->
                        {
                            double total = products.stream().map(Product::price).reduce(0.0, Double::sum);
                            double average = products.stream().collect(Collectors.averagingDouble(Product::price));
                            double min = products.stream().min(Comparator.comparingDouble(Product::price)).orElseThrow().price();
                            double max = products.stream().max(Comparator.comparing(Product::price)).orElseThrow().price();
                            return new ProductStaticsKey(total, average, min, max);
                        }
                    )
                ));
    }
/** 7. Grouping with Custom Collector / Immutable Map**/
    /**Group and collect to unmodifiable map:
     Collectors.collectingAndThen(groupingBy(...), Collections::unmodifiableMap)*/
    @Override
    public Map<String,List<Student>> groupByUnmodifiableMap(List<Student> list){
        return
            list.stream()
                .collect(
                    Collectors.collectingAndThen(
                        Collectors.groupingBy(Student::subject),
                        Collections::unmodifiableMap
                    )
                );
        }

    /**Group and use a TreeMap to keep keys sorted:
    Collectors.groupingBy(..., TreeMap::new, downstream)*/
    @Override
    public Map<String, List<String>> keepKeySortedGroup(List<Student> list){
    return
    list.stream()
        .collect(Collectors.groupingBy(
            Student::subject,
            TreeMap::new,
            Collectors.mapping(Student::name, Collectors.collectingAndThen(
                Collectors.toList(),
                ll -> ll.stream().sorted().toList()
                )
            )
        ));
    }
/** 8. Partitioning (a specialized grouping case)*/
    /**Partition students by passing/failing grades.*/
    @Override
    public Map<Boolean,List<String>> groupByFailPassStud(List<Student> list){
        return
            list.stream()
                .collect(Collectors.groupingBy(
                    e-> e.marks()>=90,
                    Collectors.mapping(Student::name, Collectors.toList())
                ));
    }
    /**Partition numbers by prime vs non-prime.*/
    @Override
    public  Map<Boolean, List<Integer>> segregatePrimeNonPrimePredicate(List<Integer> list){
        Predicate<Integer> primePredicate = num -> IntStream.rangeClosed(1,num).filter( i-> num%i==0).count()>2;
        return list.stream()
            .collect(
                Collectors.partitioningBy(primePredicate)
            );
    }

    /**Partition strings by palindrome or not.**/
    @Override
    public Map<Boolean, List<String>> segregatePalindrome(List<List<String>> list){
        Predicate<String> palindromePredicate = str -> str.contentEquals(new StringBuilder(str).reverse());
        return
            list.stream().flatMap(Collection::stream)
                .collect(
                    Collectors.partitioningBy(palindromePredicate)
                );
    }

    /**Partition employees by age > 40, and then count per group.**/
    public Map<Boolean,Long> empOldYoungCount(List<Employee> list){
        Predicate<Employee> employeePredicate = e-> e.age()>=30;
        return
            list.stream()
                .collect(Collectors.partitioningBy(employeePredicate,
                    Collectors.counting()));
    }

/**9. Real-World Business Scenarios*/
    /**Group orders by customer and calculate total order value per customer.*/
    public Map<String,Long> totalOrderByPerCustomer(List<Order> list){
        return
            list.stream()
                .collect(
                    Collectors.groupingBy(
                        Order::customerName,
                        Collectors.counting()
                    )
                );
    }
    /**Group flights by airline and find the flight with max distance/amount.**/
    @Override
    public Map<String,Map<String,Integer>> groupByAirlineFlightMaxDistance(List<Flight> list){
        return
            list.stream()
                .collect(
                    Collectors.groupingBy(
                        Flight::flight,
                        Collectors.collectingAndThen(
                            Collectors.toList(),
                            flights -> flights.stream().max(Comparator.comparing(Flight::distance)).stream().collect(Collectors.toMap(
                                Flight::flightNo,
                                Flight::distance,
                                (e1,e2)->e1,
                                LinkedHashMap::new
                            ))
                        )
                    )
                );
    }

}
