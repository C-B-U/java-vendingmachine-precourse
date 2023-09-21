package vendingmachine.domain;

import vendingmachine.constant.ExceptionMessage;

import java.util.ArrayList;
import java.util.List;

public class Products {

    private final List<Product> elements;

    public Products(List<Product> elements) {
        this.elements = new ArrayList<>(elements);
    }

    public Product findByProductName(String name) {
        return elements.stream()
                .filter(value -> value.isSameName(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.NOT_EXIST_PRODUCT.toString()));
    }

    public boolean isExistProduct() {
        return elements.stream()
                .anyMatch(Product::isExist);
    }

    public int getMinPrice() {
        return elements.stream()
                .filter(Product::isExist)
                .mapToInt(Product::getPrice)
                .min()
                .orElseThrow(() -> new IllegalArgumentException(""));
    }
}
