package com.tss.guitar.model;

public enum Type {
    ACOUSTIC, ELECTRIC;

    @Override
    public String toString() {
        switch (this){
            case ACOUSTIC : return "Acoustic";
            case ELECTRIC : return "Electric";
        }
        return null;
    }
}
