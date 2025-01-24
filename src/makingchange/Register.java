package makingchange;

import java.util.ArrayList;
import java.util.List;

public class Register {
    private final List<Denomination> denominations;

    public Register() {
        denominations = new ArrayList<>();
        denominations.add(new Denomination("Fifty Dollar Note", 50.0, "bill", "images/fifty.png"));
        denominations.add(new Denomination("Twenty Dollar Note", 20.0, "bill", "images/twenty.png"));
        denominations.add(new Denomination("Ten Dollar Note", 10.0, "bill", "images/ten.png"));
        denominations.add(new Denomination("Five Dollar Note", 5.0, "bill", "images/five.png"));
        denominations.add(new Denomination("One Dollar Note", 1.0, "bill", "images/one.png"));
        denominations.add(new Denomination("Quarter", 0.25, "coin", "images/quarter.png"));
        denominations.add(new Denomination("Dime", 0.10, "coin", "images/dime.png"));
        denominations.add(new Denomination("Nickel", 0.05, "coin", "images/nickel.png"));
        denominations.add(new Denomination("Penny", 0.01, "coin", "images/penny.png"));
    }

    public Purse makeChange(double amt) {
        amt = Math.round(amt * 100.0) / 100.0;

        if (amt <= 0) {
            return new Purse();
        }

        Purse purse = new Purse();
        for (Denomination denomination : denominations) {
            int count = (int) (amt / denomination.amt());
            if (count > 0) {
                purse.add(denomination, count);
                amt -= count * denomination.amt();
                amt = Math.round(amt * 100.0) / 100.0;
            }
        }
        return purse;
    }
}
