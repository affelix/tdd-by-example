package guru.springframework;

import lombok.Getter;
import lombok.ToString;

@ToString()
public class Money implements Expression {

    @Getter
    private int amount;
    @Getter
    private final String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    public static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    protected String currency() {
        return currency;
    }

    @Override
    public Expression times(int multiplier) {
        return new Money(amount * multiplier, this.currency);
    }

    @Override
    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }

    @Override
    public Money reduce(Bank bank, String to) {
        return new Money(amount / bank.rate(this.currency, to), to);
    }

    /**
     * @param object - If classname changes, no problem in the parameter.
     * @return true if amount value is equal and currency is the same.
     */
    @Override
    public boolean equals(Object object) {
        Money money = (Money) object;
        return this.amount == money.amount && this.currency.equals(money.currency);
    }
}
