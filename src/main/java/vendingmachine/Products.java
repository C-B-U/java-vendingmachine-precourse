package vendingmachine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Products {

    private static final String PRODUCT_DIVISION = ";";
    private static final String PRODUCT_DETAIL_DIVISION = ",";
    private final List<Product> products;


    public Products(String productData) {
        products = Arrays.stream(productData.split(PRODUCT_DIVISION))
                .map(productToken -> productToken.substring(1, productToken.length() - 1).split(PRODUCT_DETAIL_DIVISION))
                .map(productDetails -> new Product(productDetails[0], Integer.parseInt(productDetails[1]), Integer.parseInt(productDetails[2])))
                .collect(Collectors.toList());
    }

}
