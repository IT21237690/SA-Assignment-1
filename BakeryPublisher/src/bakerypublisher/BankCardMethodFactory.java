package bakerypublisher;

class BankCardMethodFactory implements PaymentMethodFactory {
    @Override
    public String createPaymentMethod() {
        return "Bank Card";
    }
}
