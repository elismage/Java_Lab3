package org.example;

import java.util.Objects;

public class PieceProduct extends Product{
    private final double mass;

    //construction
    public PieceProduct(String name, String description, double mass) {
        super(name, description);
        if (mass <= 0){
            throw new IllegalArgumentException("Mass below zero or equals zero");
        } else {
            this.mass = mass;
        }
    }

    //getters

    public double getMass() {
        return mass;
    }

    //eq

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }
        if (!super.equals(obj)){
            return false;
        }
        PieceProduct that = (PieceProduct) obj;
        return Double.compare(that.mass, mass) == 0;
    }



    @Override
    public String toString() {
        return "PieceProduct{"+
                "name: '" + getName()+ '\'' +
                "specification: '" + getSpecification()+ '\'' +
                "mass(kg): ': " + getMass()+ '\'' +
                "'}";
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), mass);
    }
}

