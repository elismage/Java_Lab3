package org.example;

import java.util.Objects;

public class ProductPackage {
    private final String name;
    private final double mass;



    //constructor
    public ProductPackage(String name, double mass){
        this.name = name;
        if (mass <= 0){
            throw new IllegalArgumentException("Mass is below zero or equals zero");
        }
        this.mass = mass;
    }
    //getters
    public String getName() {
        return name;
    }

    public double getMass() {
        return mass;
    }

    //hc & eq

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductPackage that = (ProductPackage) o;
        return Double.compare(mass, that.mass) == 0 && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, mass);
    }

    @Override
    public String toString() {
        return "ProductPackage{" +
                "name: '" + name + '\'' +
                ", mass: " + mass +
                '}';
    }
}
