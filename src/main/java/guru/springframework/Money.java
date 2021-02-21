package guru.springframework;

public class Money {
    protected int amount;

    /**
     * @param object - If classname changes, no problem in the parameter.
     * @return true if amount value is equal.
     */
    @Override
    public boolean equals(Object object) {
        Money money = (Money) object;
        return amount == money.amount;
    }
}
