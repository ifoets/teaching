package interview.preparation.newjava.java8.model;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }
}
