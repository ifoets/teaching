package interview.preparation.rxjava;

import interview.preparation.rxjava.records.*;
import interview.preparation.rxjava.records.enums.OrderStatus;
import interview.preparation.rxjava.records.enums.TransactionStatus;
import interview.preparation.rxjava.records.enums.TransactionType;

import java.time.LocalDate;
import java.util.List;

public class RxDataUtils {

    public static List<Sale> getSales()
    {
        return
            List.of(
                new Sale("BAN","Apple-Mob",10),
                new Sale("BAN","Samsung-Mob",20),
                new Sale("BAN","Mac-pro",60),
                new Sale("BAN","Nokia-Mob",40),
                new Sale("BAN","Mouse",100),
                new Sale("DEL","KeyBoard",90),
                new Sale("DEL","Book",20),
                new Sale("DEL","Pen",60),
                new Sale("PAT","Pen",40),
                new Sale("PAT","Pensile",30)
            );
    }
    public static List<Customer> getCustomers()
    {
        return
            List.of(
                new Customer(1,"Aaa","PAT",100),
                new Customer(2,"Bbb","PAT",200),
                new Customer(3,"Ccc","PAT",500),
                new Customer(4,"Ddd","PAT",400),
                new Customer(5,"Eee","PAT",300),

                new Customer(10,"Ppp","MUM",5000),
                new Customer(9,"Qqq","MUM",4000),
                new Customer(8,"Rrr","MUM",3000),
                new Customer(7,"Xxx","MUM",2000),
                new Customer(6,"yy","MUM",1000),

                new Customer(11,"Fff","DEL",5000),
                new Customer(12,"Ggg","DEL",4000),
                new Customer(13,"Hhh","BAN",3000),
                new Customer(14,"Iii","KOL",2000),
                new Customer(15,"Jjj","BAN",1000)
            );
    }
    public static List<Flight> getFlights()
    {
        return
            List.of(
                new Flight(5000,"INDIGO","PAT","DEL",1000,"INGGO11"),
                new Flight(6000,"AIR-INDIA","PAT","DEL",1000,"AIR10"),
                new Flight(3000,"INDIGO","DEL","MUM",700,"IND10"),
                new Flight(7000,"SPICE-JET","DEL","BAN",1500,"SPJ10"),
                new Flight(5000,"GO-FIRST","DEL","RANCHI",500,"GO10"),

                new Flight(6000,"SPICE-JET","PAT","DEL",1000,"SPJ11"),
                new Flight(7000,"AIR-INDIA","PAT","BAN",1500,"AIR11"),
                new Flight(4000,"GO-FIRST","DEL","MUM",700,"GO11"),
                new Flight(8000,"SPICE-JET","DEL","BAN",1500,"SPJ10"),
                new Flight(6000,"GO-FIRST","DEL","KOL",700,"GO11")
            );
    }
    public static List<EmpMgr> getEmpMgrs()
    {
        return
            List.of(
                new EmpMgr("AAA",1,10,30),
                new EmpMgr("BBB",2,20,31),
                new EmpMgr("CCC",3,30,32),
                new EmpMgr("DDD",4,10,33),
                new EmpMgr("EEE",5,20,34),
                new EmpMgr("FFF",6,30,35),

                new EmpMgr("XXX",7,10,30),
                new EmpMgr("YYY",8,20,31),
                new EmpMgr("ZZZ",9,30,32),
                new EmpMgr("M-PP",10,20,40),
                new EmpMgr("M-QQ",20,30,45),
                new EmpMgr("M-RR",30,-1,50)

            );
    }
    public static List<Transaction> getTransactions()
    {
        return
            List.of(
                new Transaction(100, TransactionType.CREDIT, TransactionStatus.COMPLETED,LocalDate.of(2021,1,1)),
                new Transaction(200, TransactionType.DEBIT, TransactionStatus.FAILED,LocalDate.of(2021,1,1)),
                new Transaction(300, TransactionType.DEPOSIT, TransactionStatus.DECLINED,LocalDate.of(2022,2,2)),
                new Transaction(400, TransactionType.PAYMENT, TransactionStatus.CANCELLED,LocalDate.of(2022,2,2)),
                new Transaction(500, TransactionType.REFUND, TransactionStatus.PROCESSING,LocalDate.of(2023,3,3)),

                new Transaction(600, TransactionType.CREDIT, TransactionStatus.COMPLETED,LocalDate.of(2021,2,1)),
                new Transaction(700, TransactionType.DEBIT, TransactionStatus.COMPLETED,LocalDate.of(2021,2,1)),
                new Transaction(800, TransactionType.DEPOSIT, TransactionStatus.COMPLETED,LocalDate.of(2022,2,2)),
                new Transaction(900, TransactionType.PAYMENT, TransactionStatus.COMPLETED,LocalDate.of(2022,2,2)),
                new Transaction(10000, TransactionType.REFUND, TransactionStatus.COMPLETED,LocalDate.of(2023,3,3))
            );
    }
    public static List<Book> getBooks()
    {
        return
            List.of(
              new Book("1","Ego getting solid for ever","abhi","Mystery",100,100,true),
                new Book("2","Mind is ever thing under experience","kumar","Mystery",200,50,true),
                new Book("3","The Silent Patient","abhi","Thriller",300,100,true),
                new Book("4","Gone Girl","abhi","Thriller",400,12,true),
                new Book("5","The Da Vinci Code","suman","Thriller",500,56,true),
                new Book("6","The Reversal","raj","Horror",600,200,true)
            );
    }
    public static List<Order> getOrders()
    {
        return
            List.of(
                new Order("1","abhi",100, OrderStatus.CONFIRMED),
                new Order("2","kumar",300,OrderStatus.CONFIRMED),
                new Order("3","suman",500,OrderStatus.CONFIRMED),
                new Order("4","raj",500,OrderStatus.CANCELLED),
                new Order("5","kumar",1000,OrderStatus.DELIVERED),
                new Order("6","raj",2000,OrderStatus.DELIVERED)
            );
    }
    public static List<Student> getStudents()
    {
        return
            List.of(
                new Student("abhi","PHY", 70),
                new Student("kumar","CHE", 80),
                new Student("suman","MATH", 90),
                new Student("raj","PHY", 100),
                new Student("abkumar","CHE", 90),
                new Student("raj","MATH", 80)
            );
    }
    public static List<Product> getProducts()
    {
        return
            List.of(
                new Product("123","Apple","MOB",2000, true),
                new Product("124","Samsung","MOB",1000, true),
                new Product("234","Apple","LAP",3000, true),
                new Product("235","Lenovo","LAP",1000, true),
                new Product("321","Samsung","TV",5000, true),
                new Product("322","Apple","TV",10000, true)
            );
    }
    public static List<Person> getPersons()
    {
        return
            List.of(
                new Person("abhi",10,"DEL"),
                new Person("kumar",20,"BAN"),
                new Person("suman",30,"KOL"),
                new Person("vit",40,"DEL"),
                new Person("raj",15,"MUM"),
                new Person("abhi",45,"PAT"),
                new Person("kumar",5,"PAT"),
                new Person("kumar",25,"DEL"),

                new Person("abhi",31,"DEL"),
                new Person("kumar",32,"BAN"),
                new Person("suman",33,"KOL"),
                new Person("vit",34,"DEL"),
                new Person("raj",35,"MUM"),
                new Person("abhi",36,"PAT"),
                new Person("kumar",37,"PAT"),
                new Person("kumar",38,"DEL")
            );
    }
    public static List<Employee> getEmpList()
    {
       return List.of(
            new Employee("abhi",10,"IT","MUM",50000),
            new Employee("kumar",20,"ECE","DEL",60000),
            new Employee("suman",30,"ECE","PAT",50000),
            new Employee("vit",40,"IT","DEL",50000),
            new Employee("raj",15,"ECE","MUM",100000),
            new Employee("abhi",45,"MECH","BAN",70000),
            new Employee("kumar",5,"CS","BAN",90000),
            new Employee("kumar",25,"CS","DEL",500000)
        );
    }

    public static List<List<String>> getStrigList()
    {
        return List.of(
            List.of("abhi", "aksuman"),
            List.of("akumar", "raj"),
            List.of("kumar", "eager"),
            List.of("kumarAbhi", "orange"),
            List.of("aksumanvit", "integer")
        );
    }

    public static List<List<String>> getPalindromesList()
    {
        return List.of(
            List.of("abcba", "aabcc"),
            List.of("akuuka", "rjajr"),
            List.of("kumar", "ramuk"),
            List.of("abhihba", "orange"),
            List.of("bbbbb", "integer")
        );
    }

    public static List<List<String>> getListOfListStr()
    {
        return List.of(
            List.of("abhi", "aksuman"),
            List.of("akumar", "2"),
            List.of("kumar", "23"),
            List.of("kumarAbhi", "45"),
            List.of("aksumanvit", "456")
        );
    }
}
