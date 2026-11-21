package org.example;

import java.util.Arrays;
import java.util.Objects;

public class PackageProductSet implements PackagedItem {
    private final String name;
    private final ProductPackage productPackage;
    private final PackagedItem[] items;

    public PackageProductSet(String name, ProductPackage productPackage, PackagedItem... items) {
        if (name == null || productPackage == null || items == null) {
            throw new IllegalArgumentException("Arguments must not be null");
        }
        for (PackagedItem item : items) {
            if (item == null) {
                throw new IllegalArgumentException("Item in set must not be null");
            }
        }
        this.name = name;
        this.productPackage = productPackage;
        this.items = Arrays.copyOf(items, items.length);
    }

    public PackageProductSet(ProductPackage productPackage, PackagedItem... items) {
        this(productPackage != null ? productPackage.getName() : null, productPackage, items);
    }

    @Override
    public String getName() {
        return name;
    }

    public ProductPackage getProductPackage() {
        return productPackage;
    }

    public PackagedItem[] getItems() {
        return Arrays.copyOf(items, items.length);
    }

    @Override
    public double getNetMass() {
        double sum = 0;
        for (PackagedItem item : items) {
            sum += item.getGrossMass();
        }
        return sum;
    }

    @Override
    public double getGrossMass() {
        return getNetMass() + productPackage.getMass();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PackageProductSet that = (PackageProductSet) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(productPackage, that.productPackage) &&
                Arrays.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, productPackage);
        result = 31 * result + Arrays.hashCode(items);
        return result;
    }

    @Override
    public String toString() {
        return "PackageProductSet{" +
                "name='" + name + '\'' +
                ", productPackage=" + productPackage +
                ", items=" + Arrays.toString(items) +
                '}';
    }
}