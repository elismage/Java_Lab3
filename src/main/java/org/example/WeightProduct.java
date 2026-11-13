package org.example;

import java.util.Objects;

public class WeightProduct extends Product{
    //construction
    public WeightProduct(String name, String description) {
        super(name, description);
    }

    //eq

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "WeightProduct{"+
                "name: '" + getName()+ '\'' +
                "specification: '" + getSpecification()+ '\'' +
                "}";
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }
}

