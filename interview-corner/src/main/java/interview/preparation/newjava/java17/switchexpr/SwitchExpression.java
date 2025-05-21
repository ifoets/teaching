package interview.preparation.newjava.java17.switchexpr;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

public class SwitchExpression {
    public static Map<Integer, Position> positionMap = new HashMap<>();
    public static int randomNumber;
    public static Position randomPosition;
    public static void setup() {
        positionMap.put(1, Position.GOALKEEPER);
        positionMap.put(2, Position.DEFENCE);
        positionMap.put(3, Position.MIDFIELDER);
        positionMap.put(4, Position.STRIKER);
        randomNumber = ThreadLocalRandom.current().nextInt(1, 6);
        randomPosition = Optional.ofNullable(positionMap.get(randomNumber)).orElse(Position.BENCH);
    }
}