package interview.preparation.rxjava.stream;

import interview.preparation.rxjava.stream.model.Pair;
import interview.preparation.rxjava.stream.records.Employee;
import interview.preparation.rxjava.stream.records.Person;
import interview.preparation.rxjava.stream.records.Sale;
import interview.preparation.rxjava.stream.records.Student;
import interview.preparation.rxjava.stream.records.enums.OrderStatus;
import interview.preparation.rxjava.stream.records.enums.TransactionStatus;
import interview.preparation.rxjava.stream.records.enums.TransactionType;
import interview.preparation.rxjava.stream.records.keys.FlightOperationKey;
import interview.preparation.rxjava.stream.records.keys.ProductStaticsKey;
import interview.preparation.rxjava.stream.records.keys.TransactionKey;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class IStreamGroupByTest {

    public IStreamGroupBy irg;

    @Before
    public void init()
    {
        irg = new StreamGroupByImpl();
    }

 /**1. Basic Grouping**/
    @Test
    public void groupByFirstCharTest()
    {

        Map<Character,List<String>> map = irg.groupByFirstChar(RxDataUtils.getListOfListStr());
        System.out.println(map);
        Assert.assertEquals(4,map.get('a').size());
        Assert.assertEquals(2,map.get('2').size());
        Assert.assertEquals(2,map.get('k').size());
    }

    @Test
    public void segregateByFirstCharVowelsTest()
    {
        Map<Boolean,List<String>> map = irg.segregateByFirstCharVowels(RxDataUtils.getStrigList());
        System.out.println(map);
        Assert.assertEquals(7,map.get(true).size());
        Assert.assertEquals(3,map.get(false).size());
    }

    /**Group a list of Employee by department.**/
    @Test
    public void groupByDepartmentTest()
    {
        Map<String, List<Employee>> map = irg.groupByDepartment(RxDataUtils.getEmpList());
        System.out.println(map);
        Assert.assertEquals(2,map.get("CS").size());
        Assert.assertEquals(2,map.get("IT").size());
        Assert.assertEquals(3,map.get("ECE").size());
    }

    @Test
    public void groupByNameAndDepartmentTest()
    {
        Map<String,List<Employee>> map = irg.groupByNameAndDepartment(RxDataUtils.getEmpList());
        System.out.println(map);
        Assert.assertEquals(1,map.size());
        Assert.assertEquals(2,map.get("CS:kumar").size());
    }

    @Test
    public void groupByNameAndDepartmentAndAgeLimitTest()
    {
        Map<String,List<Employee>> map = irg.groupByNameAndDepartmentAndAgeLimit(RxDataUtils.getEmpList());
        System.out.println(map);
        Assert.assertEquals(1,map.size());
        Assert.assertEquals(2,map.get("CS:kumar").size());
    }

    /**Group integers by even/odd using groupingBy(num -> num % 2 == 0 ? "Even" : "Odd").*/
    @Test
    public void segregateEvenOddTest()
    {
        Map<String,List<Integer>> map = irg.segregateEvenOdd(List.of(1,2,3,4,5,6,7,8,9,10,11));
        System.out.println(map);
        Assert.assertEquals(2,map.size());
        Assert.assertEquals(6,map.get("Odd").size());
        Assert.assertEquals(5,map.get("Even").size());
    }


    /**Group integers by Fizz(%3),Buzz(%5),FizzBuzz(%3&&%5) or NotFizzBzz by*/
    @Test
    public void segregateFizzBuzzTest()
    {
        Map<String,List<Integer>> map = irg.segregateFizzBuzz(List.of(10,20,30,40,50,16,17,18,19,110,111));
        System.out.println(map);
        Assert.assertEquals(4,map.size());
        Assert.assertEquals(1,map.get("FizzBuzz").size());
        Assert.assertEquals(2,map.get("Fizz").size());
        Assert.assertEquals(3,map.get("NotFizzBzz").size());
        Assert.assertEquals(5,map.get("Buzz").size());
    }


    /**Group Employee name/words by their lengths.*/
    @Test
    public void groupByLengthWordsTest()
    {
        Map<Integer, List<String>> map = irg.groupByLengthWords(RxDataUtils.getEmpList());
        System.out.println(map);
        Assert.assertEquals(3,map.size());
        Assert.assertEquals(2,map.get(3).size());
        Assert.assertEquals(2,map.get(4).size());
        Assert.assertEquals(4,map.get(5).size());
    }

/**2. Grouping with Downstream Collectors**/
    /**Group Employee by department and count them:groupingBy(Employee::getDept, counting())*/
    @Test
    public void groupByDeptCountTest()
    {
        Map<String, Long> map = irg.groupByDeptCount(RxDataUtils.getEmpList());
        System.out.println(map);
        Assert.assertEquals(4,map.size());
        Assert.assertEquals(2,map.get("CS").intValue());
        Assert.assertEquals(3,map.get("ECE").intValue());
    }
    /**Group Person by city, and collect names as Set<String>.**/
    @Test
    public void groupByCityUniqueNameTest()
    {
        Map<String,Set<String>> map = irg.groupByCityUniqueName(RxDataUtils.getPersons());
        System.out.println(map);
        Assert.assertEquals(5,map.size());
        Assert.assertEquals(3,map.get("DEL").size());
        Assert.assertEquals(2,map.get("PAT").size());
    }
    /**Group Product by sorted category and get average price **/
    @Test
    public void groupBYProdCatAvgPriceTest()
    {
        Map<String,Double> map = irg.groupBYProdCatAvgPrice(RxDataUtils.getProducts());
        System.out.println(map);
        Assert.assertEquals(3,map.size());
        Assert.assertEquals(2000,map.get("LAP").intValue());
        Assert.assertEquals(7500,map.get("TV").intValue());
    }
    /**Group Student by class, and find the top scorer in each class.*/
    @Test
    public void findToScorerStudentsByClassTest()
    {
        Map<String, Optional<Student>> map = irg.findToScorerStudentsByClass(RxDataUtils.getStudents());
        System.out.println(map);
        Assert.assertEquals(3,map.size());
        Assert.assertEquals(100,map.get("PHY").orElseThrow().marks());
        Assert.assertEquals(90,map.get("CHE").orElseThrow().marks());
        Assert.assertEquals(90,map.get("MATH").orElseThrow().marks());
    }

    /**Group orders by status and get the total price per status.**/
    @Test
    public void groupByOrderStatusTotalPriceTest()
    {
        Map<OrderStatus, Double> map = irg.groupByOrderStatusTotalPrice(RxDataUtils.getOrders());
        System.out.println(map);
        Assert.assertEquals(3,map.size());
        Assert.assertEquals(900,map.get(OrderStatus.CONFIRMED).intValue());
        Assert.assertEquals(500,map.get(OrderStatus.CANCELLED).intValue());
        Assert.assertEquals(3000,map.get(OrderStatus.DELIVERED).intValue());
    }


/**3. Grouping with Nested Collections**/
    /**Group Employee by location, then by department.*/
    @Test
    public void groupByLocThenByDeptTest()
    {
       Map<String,Map<String, List<Employee>>> map = irg.groupByLocThenByDept(RxDataUtils.getEmpList());
        System.out.println(map);
        Assert.assertEquals(4,map.size());
        Assert.assertEquals(1,map.get("PAT").get("ECE").size());
        Assert.assertEquals(1,map.get("MUM").get("IT").size());

        Assert.assertEquals(3,map.get("DEL").size());
        Assert.assertEquals(2,map.get("BAN").size());
    }

    /**Group books by genre, and within each genre, group by author.*/
    @Test
    public void groupBookByGenreWithinGroupByAuthTest()
    {
       Map<String,Map<String,List<String>>> map  = irg.groupBookByGenreWithinGroupByAuth(RxDataUtils.getBooks());
        System.out.println(map);
        Assert.assertEquals(3,map.size());
        Assert.assertEquals(2,map.get("Thriller").get("abhi").size());
        Assert.assertEquals(2,map.get("Mystery").size());
        Assert.assertEquals(1,map.get("Mystery").get("kumar").size());
    }

    /**Group Transaction by year, then month, then status.*/
    @Test
    public void groupByYearThenMonthThenStatus()
    {
        Map<Integer,Map<Integer,Map<TransactionStatus, List<TransactionType>>>> map = irg.groupByYearThenMonthThenStatus(RxDataUtils.getTransactions());
        System.out.println(map);
        Assert.assertEquals("DEBIT",map.get(2021).get(1).get(TransactionStatus.FAILED).getFirst().name());
        Assert.assertEquals(2,map.get(2022).get(2).get(TransactionStatus.COMPLETED).size());
    }

    /**From List<Employee>, group by managerId, and for each manager get employee names sorted by age.*/
    @Test
    public void groupByMgrIdOrderBYAgeTest()
    {
        Map<Integer, List<String>> map = irg.groupByMgrIdOrderBYAge(RxDataUtils.getEmpMgrs());
        System.out.println(map);
        Assert.assertEquals(4,map.size());
        Assert.assertEquals("DDD",map.get(10).get(2));
        Assert.assertEquals(4,map.get(30).size());

    }

    /** 4. Grouping with Complex Objects**/
    /** Group list of Person(name, city, age) by city and return average age.*/
    @Test
    public void collectAverageAgeInCityTest()
    {
        Map<String,Double> map = irg.collectAverageAgeInCity(RxDataUtils.getPersons());
        System.out.println(map);
        Assert.assertEquals(5,map.size());
        Assert.assertEquals(30,map.get("PAT").intValue());
        Assert.assertEquals(31,map.get("KOL").intValue());
        Assert.assertEquals(26,map.get("BAN").intValue());
    }
    /**Group a list of Employee by department and collect oldest employee per department.*/
    @Test
    public void collectOldestEmpInDeptTest()
    {
        Map<String, Integer> map = irg.collectOldestEmpInEachDept(RxDataUtils.getEmpList());
        System.out.println(map);
        Assert.assertEquals(4,map.size());
        Assert.assertEquals(25,map.get("CS").intValue());
        Assert.assertEquals(30,map.get("ECE").intValue());
        Assert.assertEquals(40,map.get("IT").intValue());
        Assert.assertEquals(45,map.get("MECH").intValue());
    }

    /**Group books by title length range (short <10, medium <20, long).*/
    @Test
    public void groupBookTitleLenTest()
    {
        Map<String, List<String>> map = irg.groupBookTitleLen(RxDataUtils.getBooks());
        System.out.println(map);
        Assert.assertEquals(3,map.size());
        Assert.assertEquals(3,map.get("Medium-Title").size());
        Assert.assertEquals(1,map.get("Short-Title").size());
        Assert.assertEquals(2,map.get("Long-Title").size());
    }

    /**Group by custom category using groupingBy(e -> classify(e))*/
    @Test
    public void groupByAmountClassifyTest()
    {
        Map<String,List<Double>> map = irg.groupByAmountClassify(RxDataUtils.getTransactions());
        System.out.println(map);
        Assert.assertEquals(3,map.size());
        Assert.assertEquals(4,map.get("SMALL").size());
        Assert.assertEquals(5,map.get("MEDIUM").size());
        Assert.assertEquals(1,map.get("LARGE").size());

    }

 /** 5. Grouping with Multiple Keys (Composite)**/
    /**Group Transaction Status by (year, month) composite key using toMap or custom class as key.**/
    @Test
    public void groupByCompositeKeyYearMonthTest()
    {
        Map<TransactionKey,List<TransactionStatus>> map = irg.groupByCompositeKeyYearMonth(RxDataUtils.getTransactions());
        System.out.println(map);
        Assert.assertEquals(4,map.size());
        Assert.assertEquals(2,map.get(new TransactionKey(2021,1)).size());
        Assert.assertEquals(4,map.get(new TransactionKey(2022,2)).size());

    }

    /**Group flights by (origin, destination) and count total flights.*/
    @Test
    public void groupNoOfFlightSrcBtnDestinationTest()
    {
        Map<FlightOperationKey, Long> map = irg.groupNoOfFlightSrcBtnDestination(RxDataUtils.getFlights());
        System.out.println(map);
        Assert.assertEquals(6,map.size());
        Assert.assertEquals(2,map.get(new FlightOperationKey("DEL","BAN")).intValue());
        Assert.assertEquals(1,map.get(new FlightOperationKey("PAT","BAN")).intValue());
        Assert.assertEquals(3,map.get(new FlightOperationKey("PAT","DEL")).intValue());

    }

    /**group flight name and amount between src and destination**/
    @Test
    public void groupSrcDestinationTest()
    {
        Map<String, List<String>> map = irg.groupSrcDestination(RxDataUtils.getFlights());
        System.out.println(map);
        Assert.assertEquals(6,map.size());
        Assert.assertEquals(2,map.get("DEL->BAN").size());
        Assert.assertEquals(1,map.get("PAT->BAN").size());
        Assert.assertEquals(3,map.get("PAT->DEL").size());
    }

    /**Group employees by (department + location) and sum salaries.**/
    @Test
    public void collectSalAtOrigenDeptTest()
    {
        Map<String,Map<String,Double>> map = irg.collectSalAtOrigenDept(RxDataUtils.getEmpList());
        System.out.println(map);
        Assert.assertEquals(4,map.size());
        Assert.assertEquals(1,map.get("PAT").size());
        Assert.assertEquals(2,map.get("MUM").size());
        Assert.assertEquals(3,map.get("DEL").size());
        Assert.assertEquals(2,map.get("BAN").size());
    }

    /**Group data into a Map<Pair<String, Integer>, List<Obj>>.**/
    @Test
    public void pairPersonByCityNameTest()
    {
        Map<Pair<String,String>,List<Person>> map = irg.pairPersonByCityName(RxDataUtils.getPersons());
        System.out.println(map);
        Assert.assertEquals(8,map.size());
        Assert.assertEquals(2,map.get(new Pair<>("DEL","kumar")).size());
    }

/**6. Aggregations After Grouping*/
    /**Group and then find max, min, or sum using reducing or collectingAndThen.**/
    @Test
    public void findAggregateInGroupTest()
    {
        Map<String, Double> map = irg.findAggregateInGroup(RxDataUtils.getEmpList());
        System.out.println(map);
        Assert.assertEquals(4,map.size());
        Assert.assertEquals(295000,map.get("CS").intValue());
        Assert.assertEquals(70000,map.get("ECE").intValue());
        Assert.assertEquals(50000,map.get("IT").intValue());
    }
    @Test
    public void findMaxInGroupTest()
    {
        Map<String, Optional<Employee>> map = irg.findMaxInGroup(RxDataUtils.getEmpList());
        System.out.println(map);
        Assert.assertEquals(4,map.size());
        Assert.assertEquals(25,map.get("CS").orElseThrow().age());
        Assert.assertEquals("MUM",map.get("ECE").orElseThrow().location());
        Assert.assertEquals("abhi",map.get("IT").orElseThrow().name());
        Assert.assertEquals(70000,map.get("MECH").orElseThrow().sal(), 0.0001);
    }

    /**Group by region and get top 3 highest-revenue customers per region.*/
    @Test
    public void findTopRevenueInEveryReasonTest()
    {
        Map<String,List<Double>> map = irg.findTopRevenueInEveryReason(RxDataUtils.getCustomers());
        System.out.println(map);
        Assert.assertEquals(5, map.size());
        Assert.assertEquals(3,map.get("PAT").size());
        Assert.assertEquals(2,map.get("DEL").size());
        Assert.assertEquals(1,map.get("KOL").size());
    }

    /**Group sales by region and get the product with max quantity per region.*/
    @Test
    public void getProductMaxQualityInRegionTest()
    {
        Map<String,Optional<Sale>> map = irg.getProductMaxQualityInRegion(RxDataUtils.getSales());
        System.out.println(map);
        Assert.assertEquals(3, map.size());
        Assert.assertEquals("Pen", map.get("PAT").orElseThrow().product());
        Assert.assertEquals("KeyBoard", map.get("DEL").orElseThrow().product());
        Assert.assertEquals("Mouse", map.get("BAN").orElseThrow().product());
    }

    /**For each product category, calculate total sales, average price, min price.*/
    @Test
    public void getProductStaticsTest()
    {
        Map<String, ProductStaticsKey> map = irg.getProductStatics(RxDataUtils.getProducts());
        System.out.println(map);
        Assert.assertEquals(3,map.size());
        Assert.assertEquals(15000, map.get("Apple").total(),0.001);
        Assert.assertEquals(5000, map.get("Apple").avg(),0.001);
        Assert.assertEquals(10000, map.get("Apple").max(),0.001);
        Assert.assertEquals(2000, map.get("Apple").min(),0.001);
    }

/** 7. Grouping with Custom Collector / Immutable Map**/
    /**Group and collect to unmodifiable map:
     Collectors.collectingAndThen(groupingBy(...), Collections::unmodifiableMap)*/
    @Test
    public void groupByUnmodifiableMapTest()
    {
        Map<String,List<Student>> map = irg.groupByUnmodifiableMap(RxDataUtils.getStudents());
        System.out.println(map);
        Assert.assertEquals(3,map.size());
        try {
            map.remove("PHY");
        }catch (Exception ex){
            Assert.assertEquals(UnsupportedOperationException.class,ex.getClass());
        }

    }
    /**Group and use a TreeMap to keep keys sorted:
     Collectors.groupingBy(..., TreeMap::new, downstream)*/
    @Test
    public void keepKeySortedGroupTest()
    {
        Map<String, List<String>> map = irg.keepKeySortedGroup(RxDataUtils.getStudents());
        System.out.println(map);
        Assert.assertEquals(3, map.size());
        Assert.assertEquals("kumar", map.get("CHE").getLast());
        Assert.assertEquals("raj", map.get("MATH").getFirst());
        Assert.assertEquals("abhi", map.get("PHY").getFirst());
    }
    /** 8. Partitioning (a specialized grouping case)*/
    /**Partition students by passing/failing grades.*/
    @Test
    public void groupByFailPassStudTest()
    {
        Map<Boolean,List<String>> map = irg.groupByFailPassStud(RxDataUtils.getStudents());
        System.out.println(map);
        Assert.assertEquals(2,map.size());
        Assert.assertEquals(3,map.get(true).size());
        Assert.assertEquals(3,map.get(false).size());
    }

    /**Partition numbers by prime vs non-prime.*/
    @Test
    public void segregatePrimeNonPrimePredicateTest()
    {
        Map<Boolean, List<Integer>> map = irg.segregatePrimeNonPrimePredicate(List.of(1,2,3,4,5,6,7,8,9,10));
        System.out.println(map);
        Assert.assertTrue(map.get(false).contains(5));
        Assert.assertTrue(map.get(false).contains(7));
        Assert.assertTrue(map.get(true).contains(9));
        Assert.assertTrue(map.get(true).contains(10));
    }

    /**Partition strings by palindrome or not.**/
    @Test
    public void segregatePalindromeTest()
    {
        Map<Boolean, List<String>> map = irg.segregatePalindrome(RxDataUtils.getPalindromesList());
        System.out.println(map);
        System.out.println(map);
        Assert.assertTrue(map.get(false).contains("aabcc"));
        Assert.assertTrue(map.get(false).contains("integer"));
        Assert.assertTrue(map.get(true).contains("abcba"));
        Assert.assertTrue(map.get(true).contains("abhihba"));
    }
    /**Partition employees by age > 40, and then count per group.**/
    @Test
    public void empOldYoungCountTest()
    {
        Map<Boolean,Long>  map = irg.empOldYoungCount(RxDataUtils.getEmpList());
        System.out.println(map);
        Assert.assertEquals(5,map.get(false).intValue());
        Assert.assertEquals(3,map.get(true).intValue());
    }

    /**9. Real-World Business Scenarios*/
    /**Group orders by customer and calculate total order value per customer.*/
    @Test
    public void totalOrderByPerCustomerTest()
    {
        Map<String,Long> map = irg.totalOrderByPerCustomer(RxDataUtils.getOrders());
        System.out.println(map);
        Assert.assertEquals(4,map.size());
        Assert.assertEquals(1,map.get("suman").intValue());
        Assert.assertEquals(2,map.get("kumar").intValue());
    }

    /**Group flights by airline and find the flight with max distance/amount.**/
    @Test
    public void groupByAirlineFlightMaxDistanceTest()
    {
        Map<String,Map<String,Integer>> map = irg.groupByAirlineFlightMaxDistance(RxDataUtils.getFlights());
        System.out.println(map);
        Assert.assertEquals(4,map.size());
        Assert.assertEquals(1500,map.get("SPICE-JET").get("SPJ10").intValue());
        Assert.assertEquals(1500,map.get("AIR-INDIA").get("AIR11").intValue());
        Assert.assertEquals(1000,map.get("INDIGO").get("INGGO11").intValue());
    }

    @Test
    public void test() throws ParseException {

        //Supplier<Integer> supplier = List.of(2,3,4);
    }
}
