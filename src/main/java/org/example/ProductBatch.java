package org.example;

import java.util.Arrays;
import java.util.Objects;

public class ProductBatch {
    private final String description;
    private final PackagedItem[] items;

    public ProductBatch(String description, PackagedItem... items) {
        if (description == null || items == null) {
            throw new IllegalArgumentException("Description and items must not be null");
        }
        for (PackagedItem item : items) {
            if (item == null) {
                throw new IllegalArgumentException("Batch item must not be null");
            }
        }
        this.description = description;
        this.items = Arrays.copyOf(items, items.length);
    }

    public String getDescription() {
        return description;
    }

    public PackagedItem[] getItems() {
        return Arrays.copyOf(items, items.length);
    }

    public double getMass() {
        double total = 0;
        for (PackagedItem item : items) {
            total += item.getGrossMass();
        }
        return total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductBatch that = (ProductBatch) o;
        return Objects.equals(description, that.description) &&
                Arrays.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(description);
        result = 31 * result + Arrays.hashCode(items);
        return result;
    }

    @Override
    public String toString() {
        return "ProductBatch{" +
                "description='" + description + '\'' +
                ", items=" + Arrays.toString(items) +
                '}';
    }
}