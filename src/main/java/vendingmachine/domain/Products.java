package vendingmachine.domain;

import vendingmachine.constant.BuyStatus;
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

    public Product getProduct(final BuyProduct buyProduct) {
        validateProduct(buyProduct);
        return products.stream()
                .filter(product -> product.hasSameName(buyProduct))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(ErrorMessage.PRODUCT_NOT_EXISTS.getMessage()));
    }

    private void validateProduct(final BuyProduct buyProduct) {
        if (hasNoMatchingProduct(buyProduct)) {
            throw new IllegalArgumentException(ErrorMessage.PRODUCT_NOT_EXISTS.getMessage());
        }
    }

    private boolean hasNoMatchingProduct(final BuyProduct buyProduct) {
        return this.products.stream().map(Product::getName).noneMatch(name -> name.equals(buyProduct.getName()));
    }

    public boolean isPurchasable(final UserMoney userMoney) {
        return this.products.stream().anyMatch(product -> product.hasQuantity() && product.getPrice() <= userMoney.getAmount());
    }

    public BuyStatus purchaseProduct(final UserMoney userMoney, final Product product) {
        if (isPurchasable(userMoney)) {
            return purchase(userMoney, product);
        }
        return BuyStatus.FINISHED;
    }

    private BuyStatus purchase(final UserMoney userMoney, final Product product) {
        userMoney.decrease(product);
        product.purchase();
        if (isPurchasable(userMoney)) {
            return BuyStatus.CONTINUE;
        }
        return BuyStatus.FINISHED;
    }
}
