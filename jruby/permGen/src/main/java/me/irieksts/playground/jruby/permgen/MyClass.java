package me.irieksts.playground.jruby.permgen;

import java.util.Map;

public class MyClass {
    private String name;
    private Map<String, Object> myMap;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Object> getMyMap() {
        return myMap;
    }
    
    public void setMyMap(Map<String, Object> myMap) {
        this.myMap = myMap;
    }    
}
