package grocerypublisher;

class CashDeliveryMethodFactory implements PaymentMethodFactory {
    @Override
    public String createPaymentMethod() {
        return "Cash";
    }
}
