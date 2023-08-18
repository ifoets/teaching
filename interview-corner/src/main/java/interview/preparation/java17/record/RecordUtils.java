package interview.preparation.java17.record;

public class RecordUtils {
    public static record Footballer(String name, int age, String team) {
        public String getName()
        {
            return this.name;
        }
        public int getAge()
        {
            return this.age;
        }
    };
    public static record Engineer(String name, int age) {
        //Explicit canonical constructor
       public Engineer {
            //Custom validation
            if (age < 1)
                throw new IllegalArgumentException("Age less than 1 is not allowed!");
            //Custom modifications
            name = name.toUpperCase();
        }
        //Explicit accessor
        public int age() {
            return this.age;
        }
        public String name() {
            return this.name;
        }
    }
}
