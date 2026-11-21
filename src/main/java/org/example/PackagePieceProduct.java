package org.example;

import java.util.Objects;

public class PackagePieceProduct implements PackagedItem {
    private final ProductPackage productPackage;
    private final PieceProduct product;
    private final int count;

    public PackagePieceProduct(PieceProduct product, int count, ProductPackage productPackage) {
        if (product == null || productPackage == null) {
            throw new IllegalArgumentException("Product and package must not be null");
        }
        if (count <= 0) {
            throw new IllegalArgumentException("Count must be positive");
        }
        this.product = product;
        this.count = count;
        this.productPackage = productPackage;
    }

    public ProductPackage getProductPackage() {
        return productPackage;
    }

    public PieceProduct getProduct() {
        return product;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String getName() {
        return product.getName();
    }

    @Override
    public double getNetMass() {
        return count * product.getMass();
    }

    @Override
    public double getGrossMass() {
        return getNetMass() + productPackage.getMass();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PackagePieceProduct that = (PackagePieceProduct) o;
        return count == that.count &&
                Objects.equals(productPackage, that.productPackage) &&
                Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productPackage, product, count);
    }

    @Override
    public String toString() {
        return "PackagePieceProduct{" +
                "productPackage=" + productPackage +
                ", product=" + product +
                ", count=" + count +
                '}';
    }
}