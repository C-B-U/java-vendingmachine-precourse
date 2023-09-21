package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;

public class Products {

    private final List<Product> elements;

    public Products(List<Product> elements) {
        this.elements = new ArrayList<>(elements);
    }
}
