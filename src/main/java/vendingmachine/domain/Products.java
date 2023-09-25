package vendingmachine.domain;

import vendingmachine.constant.ErrorMessage;

import java.util.Collections;
import java.util.List;

public class Products {

    private final List<Product> products;

    public Products(final List<Product> products) {
        validateUniqueName(products);
        this.products = Collections.unmodifiableList(products);
    }

    private void validateUniqueName(final List<Product> products) {
        if (isUnique(products)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PRODUCTS_INPUT.getMessage());
        }
    }

    private boolean isUnique(final List<Product> products) {
        return products.stream().map(Product::getName).distinct().count() != products.size();
    }
}
