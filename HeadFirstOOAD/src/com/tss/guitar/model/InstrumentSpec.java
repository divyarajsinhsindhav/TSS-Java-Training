package com.tss.guitar.model;

import java.util.Map;

public class InstrumentSpec {
    Map<String,Object> properties;
    public InstrumentSpec(Map<String,Object> properties) {
        this.properties=properties;
    }

    public Object getProperty(String property){
        for (String key : properties.keySet()) {
            if(key.equalsIgnoreCase(property)){
                return properties.get(key);
            }
        }
        return null;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public boolean match(InstrumentSpec userSpec){
        for(Map.Entry<String,Object> entry : userSpec.getProperties().entrySet()){
            String propertyKey=entry.getKey();
            if(!(userSpec.getProperties().get(propertyKey).equals(this.getProperty(propertyKey)))) return false;

        }
        return true;
    }

}