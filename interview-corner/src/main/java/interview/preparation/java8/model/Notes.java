package interview.preparation.java8.model;

import lombok.Data;

@Data
public class Notes {

    public String id;
    public String name;
    public int no;

    public Notes(String name) {
        this.name = name;
    }

    public Notes(String id, String name, int no) {
        this.id = id;
        this.name = name;
        this.no = no;
    }
}
