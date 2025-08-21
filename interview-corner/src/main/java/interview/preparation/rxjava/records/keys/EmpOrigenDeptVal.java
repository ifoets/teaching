package interview.preparation.rxjava.records.keys;

public record EmpOrigenDeptVal(String origin, String dept) {

    @Override
    public String toString() {
        return origin+"::"+dept;
    }
}
