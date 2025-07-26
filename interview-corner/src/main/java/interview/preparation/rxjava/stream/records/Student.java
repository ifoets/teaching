package interview.preparation.rxjava.stream.records;

public record Student(String name, String subject, int marks) {

    public String getSubjectStudName()
    {
        return subject+"::"+name;
    }
}
