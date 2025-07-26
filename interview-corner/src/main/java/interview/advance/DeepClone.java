package interview.advance;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DeepClone {

    @SuppressWarnings("unchecked")
    public static <T extends Serializable> T deepClone1(T object) {
        try (
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bos)
        ) {
            out.writeObject(object);
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream in = new ObjectInputStream(bis);
            return (T) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Deep clone failed", e);
        }
    }

    private static final Gson gson = new Gson();

    public static <T> T deepClone2(T object, Class<T> clazz) {
        return gson.fromJson(gson.toJson(object), clazz);
    }

    static class Address implements  Serializable{
        String city;
        Address(String city) { this.city = city; }
    }

    static class Company implements  Serializable{
        String name;
        Address hqAddress;
        Company(String name, Address hqAddress) {
            this.name = name;
            this.hqAddress = hqAddress;
        }
    }

    static class Employee implements  Serializable{
        String name;
        Company company;
        List<String> skills;
        Map<String, String> metadata;

         Employee(String name, Company company, List<String> skills, Map<String, String> metadata) {
            this.name = name;
            this.company = company;
            this.skills = skills;
            this.metadata = metadata;
        }

        // Deep clone
        public Employee deepClone() {
            Company clonedCompany = new Company(
                company.name,
                new Address(company.hqAddress.city)
            );
            List<String> clonedSkills = new ArrayList<>(skills); // Strings are immutable
            Map<String, String> clonedMetadata = new HashMap<>(metadata); // Strings are immutable

            return new Employee(name, clonedCompany, clonedSkills, clonedMetadata);
        }

    }
    public void myMethod()
    {
        //get used for testing in class loader
    }

}
