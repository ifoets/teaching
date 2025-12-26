package interview.preparation.company.design;

public class NoThreeConsecutiveDS {
    private Integer lastValue = null;
    private int count = 0;
    private int rejected = 0;

    public void add(int value) {
        if (lastValue != null && lastValue == value) {
            if (count == 2) {
                rejected++;     // reject third consecutive
                return;
            }
            count++;
        } else {
            lastValue = value;
            count = 1;
        }
    }

    public int getRejectedCount() {
        return rejected;
    }
}
