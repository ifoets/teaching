package interview.preparation.rxjava.records;

public record Student(String name, String subject, int marks) {

    public String getSubjectStudName()
    {
        return subject+"::"+name;
    }
}
