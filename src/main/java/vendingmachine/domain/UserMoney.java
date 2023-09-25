package vendingmachine.domain;

public class UserMoney {

    private Integer amount;

    public UserMoney(final int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return this.amount;
    }
}
