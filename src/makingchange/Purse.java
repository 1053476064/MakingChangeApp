package makingchange;

import java.util.HashMap;
import java.util.Map;

public class Purse {
    private final Map<Denomination, Integer> cash = new HashMap<>();

    public void add(Denomination type, int num) {
        cash.put(type, cash.getOrDefault(type, 0) + num);
    }

    public double getValue() {
        return cash.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().amt() * entry.getValue())
                .sum();
    }

    public Map<Denomination, Integer> getCash() {
        return cash;
    }

    @Override
    public String toString() {
        if (cash.isEmpty()) {
            return "Empty Purse!";
        }
        StringBuilder builder = new StringBuilder("Purse Contents:\n");
        for (var entry : cash.entrySet()) {
            builder.append(entry.getValue())
                    .append(" x ")
                    .append(entry.getKey().name())
                    .append("\n");
        }
        builder.append("Total Value: $").append(String.format("%.2f", getValue()));
        return builder.toString();
    }
}
