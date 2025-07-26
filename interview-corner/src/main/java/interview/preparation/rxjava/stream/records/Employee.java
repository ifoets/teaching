package interview.preparation.rxjava.stream.records;

public record Employee(String name, int age, String department, String location, double sal) {

    public String getDepartmentAndName()
    {
        return department+":"+name;
    }

    public String getLocationAndDepartment()
    {
        return location+":"+department;
    }
}
