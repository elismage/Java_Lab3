package org.example;

import java.util.Objects;

public class Product {
    private final String name;
    private final String specification;

    //construction
    public Product(String name, String description) {
        this.name = name;
        this.specification = description;
    }

    //getters
    public String getName() {
        return name;
    }

    public String getSpecification() {
        return specification;
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
        Product product = (Product) obj;
        return Objects.equals(name, product.name) && Objects.equals(specification, product.specification);
    }



    @Override
    public String toString() {
        return "Product{"+
                "name: '" + getName()+ '\'' +
                ", specification: '" + getSpecification()+ '\'' +
                "}";
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, specification);
    }
}

