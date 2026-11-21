package org.example;

public class ProductService {

    // 3.1
    public int countByFilter(ProductBatch batch, Filter filter) {
        if (batch == null || filter == null) {
            throw new IllegalArgumentException("Batch or filter is null.");
        }
        int count = 0;
        for (PackagedItem item : batch.getItems()) {
            if (filter.apply(item.getName())) {
                count++;
            }
        }
        return count;
    }

    // 3.2
    public int countByFilterDeep(ProductBatch batch, Filter filter) {
        if (batch == null || filter == null) {
            throw new IllegalArgumentException("Batch or filter is null.");
        }
        int count = 0;
        for (PackagedItem item : batch.getItems()) {
            if (matchesDeep(item, filter)) {
                count++;
            }
        }
        return count;
    }

    private boolean matchesDeep(PackagedItem item, Filter filter) {
        if (filter.apply(item.getName())) {
            return true;
        }
        if (item instanceof PackageProductSet set) {
            for (PackagedItem child : set.getItems()) {
                if (matchesDeep(child, filter)) {
                    return true;
                }
            }
        }
        return false;
    }

    // 3.3
    public boolean checkAllWeighted(ProductBatch batch) {
        if (batch == null) {
            throw new IllegalArgumentException("Batch is null.");
        }
        PackagedItem[] items = batch.getItems();
        if (items.length == 0) {
            return false;
        }
        for (PackagedItem item : items) {
            if (!isWeightedDeep(item)) {
                return false;
            }
        }
        return true;
    }

    private boolean isWeightedDeep(PackagedItem item) {
        if (item instanceof PackageWeightProduct) {
            return true;
        }
        if (item instanceof PackageProductSet set) {
            PackagedItem[] children = set.getItems();
            if (children.length == 0) {
                return false;
            }
            for (PackagedItem child : children) {
                if (!isWeightedDeep(child)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}