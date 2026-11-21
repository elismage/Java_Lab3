package org.example;

import java.util.Objects;

public class PackageWeightProduct implements PackagedItem {
    private final ProductPackage productPackage;
    private final WeightProduct product;
    private final double mass;

    public PackageWeightProduct(ProductPackage productPackage, WeightProduct product, double mass) {
        if (productPackage == null || product == null){
            throw new IllegalArgumentException("Product must not be null");
        }
        if (mass <= 0){
            throw new IllegalArgumentException("Mass must not be below zero");
        }
        this.productPackage = productPackage;
        this.product = product;
        this.mass = mass;
    }

    public ProductPackage getProductPackage(){
        return productPackage;
    }

    public WeightProduct getProduct() {
        return product;
    }

    public double getMass() {
        return mass;
    }

    @Override
    public String getName() {
        return product.getName();
    }

    @Override
    public double getNetMass() {
        return mass;
    }

    @Override
    public double getGrossMass() {
        return mass + productPackage.getMass();
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        PackageWeightProduct that = (PackageWeightProduct) obj;
        return Double.compare(that.mass, mass) == 0 &&
                Objects.equals(productPackage, that.productPackage) &&
                Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productPackage, product, mass);
    }

    @Override
    public String toString() {
        return "PackageWeightProduct{" +
                "productPackage=" + productPackage +
                ", product=" + product +
                ", mass=" + mass +
                '}';
    }


}
