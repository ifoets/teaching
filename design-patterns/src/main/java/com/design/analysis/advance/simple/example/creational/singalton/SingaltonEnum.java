package com.design.analysis.advance.simple.example.creational.singalton;

/*a singleton means “unique within a VM” not “unique in the universe”*/
public enum SingaltonEnum {
    INSTANCE;
    private Object object;
    public Object getValue() {
        return object;
    }

    public void setValue(Object object) {
        this.object = object;
    }
    private Object readResolve(){
        return INSTANCE;
    }
}
