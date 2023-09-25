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

    public void validateInputMoney(String money){
        int price = Integer.parseInt(money);
        if(products.stream().anyMatch(product -> product.getPrice() > price)){
            throw new IllegalArgumentException(ErrorMessage.INPUT_MONEY_ERROR.getMessage());
        }
    }

    public void validateInputProductName(String name) {
        if (products.stream().noneMatch(product -> product.getName().equals(name))){
            throw new IllegalArgumentException(ErrorMessage.INPUT_PRODUCT_NAME_ERROR.getMessage());
        }
    }

    public boolean isBuyingProducts(int inputMoney){
        int minProductPrice = products.stream()
                .mapToInt(Product::getPrice)
                .min()
                .orElse(Integer.MAX_VALUE);
        return inputMoney > minProductPrice && isNotProductSoldOut();
    }

    private boolean isNotProductSoldOut(){
        int amount = products.stream()
                .mapToInt(Product::getAmount)
                .sum();
        return amount != 0;
    }

    public int getProductPrice(String name){
        return products.stream()
                .filter(product -> product.getName().equals(name))
                .findFirst()
                .map(Product::getPrice)
                .orElse(Integer.MAX_VALUE);
    }
}
