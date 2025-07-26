package interview.advance;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeepCloneTest {


    DeepClone dp;

    public void init()
    {
        dp = new DeepClone();
    }
    @Test
    public void deepClone1Test()
    {
        DeepClone.Address address = new DeepClone.Address("Bangalore");
        DeepClone.Company company = new DeepClone.Company("OpenAI", address);
        List<String> skills = List.of("Java", "Spring", "Docker");
        Map<String, String> meta = Map.of("role", "engineer");

        DeepClone.Employee e1 = new DeepClone.Employee("Abhi", company, new ArrayList<>(skills), new HashMap<>(meta));
        DeepClone.Employee e2 = dp.deepClone1(e1);

        Assert.assertEquals(e2.company.hqAddress.city,e1.company.hqAddress.city); // Bangalore
        Assert.assertEquals(e2.skills.size(),e1.skills.size());                 // [Java, Spring, Docker]
        Assert.assertEquals(3,e1.skills.size());
    }
    @Test
    public void deepClone2Test()
    {
        DeepClone.Address address = new DeepClone.Address("Bangalore");
        DeepClone.Company company = new DeepClone.Company("OpenAI", address);
        List<String> skills = List.of("Java", "Spring", "Docker");
        Map<String, String> meta = Map.of("role", "engineer");

        DeepClone.Employee e1 = new DeepClone.Employee("Abhi", company, new ArrayList<>(skills), new HashMap<>(meta));
        DeepClone.Employee e2 = dp.deepClone2(e1,DeepClone.Employee.class);

        Assert.assertEquals(e2.company.hqAddress.city,e1.company.hqAddress.city); // Bangalore
        Assert.assertEquals(e2.skills.size(),e1.skills.size());                 // [Java, Spring, Docker]
        Assert.assertEquals(3,e1.skills.size());
    }
    @Test
    public void deepClone3Test()
    {
        DeepClone.Address address = new DeepClone.Address("Bangalore");
        DeepClone.Company company = new DeepClone.Company("OpenAI", address);
        List<String> skills = List.of("Java", "Spring", "Docker");
        Map<String, String> meta = Map.of("role", "engineer");

        DeepClone.Employee e1 = new DeepClone.Employee("Abhi", company, new ArrayList<>(skills), new HashMap<>(meta));
        DeepClone.Employee e2 = e1.deepClone();

        e2.company.hqAddress.city = "Mumbai";
        e2.skills.add("Kubernetes");

        Assert.assertNotEquals(e2.company.hqAddress.city,e1.company.hqAddress.city); // Bangalore
        Assert.assertNotEquals(e2.skills.size(),e1.skills.size());                 // [Java, Spring, Docker]
        Assert.assertEquals(4,e2.skills.size());
    }
}
