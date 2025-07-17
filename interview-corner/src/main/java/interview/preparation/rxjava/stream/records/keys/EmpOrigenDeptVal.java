package interview.preparation.rxjava.stream.records.keys;

public record EmpOrigenDeptVal(String origin, String dept) {

    @Override
    public String toString() {
        return origin+"::"+dept;
    }
}
