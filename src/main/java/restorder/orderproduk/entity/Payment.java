package restorder.orderproduk.entity;

import java.util.UUID;

public class Payment {

    private UUID userId;
    private UUID orderId;
    private double amount;
//    private PaymentCurrency currency;

    public UUID getUserId() {
        return userId;
    }

    public Payment userId(UUID userId) {
        this.userId = userId;
        return this;
    }

}
