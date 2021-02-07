package hashcode.y21.practice;

import hashcode.y21.practice.dto.Delivery;
import hashcode.y21.practice.dto.Input;
import hashcode.y21.practice.dto.Output;
import hashcode.y21.practice.dto.Pizza;
import lombok.val;

import java.util.*;
import java.util.stream.Collectors;

public class Algorithm {
    public Output compute(final Input input) {
        List<Pizza> mostIngredientsPizzas = input.getPizzas().stream()
                .sorted((p1, p2) -> Integer.compare(p2.getIngredients().size(), p1.getIngredients().size()))
                .collect(Collectors.toList());

        final TreeMap<Integer, Integer> orderedTeams = new TreeMap<>(Collections.reverseOrder());
        orderedTeams.putAll(input.getTeams());

        val deliveries = new ArrayList<Delivery>();
        for (final Map.Entry<Integer, Integer> entry : orderedTeams.entrySet()) {
            val numberOfMembers = entry.getKey();
            val numberOfTeams = entry.getValue();
            for (int i = 0; i < numberOfTeams; i++) {
                if (mostIngredientsPizzas.size() >= numberOfMembers) {
                    final Delivery delivery = new Delivery(numberOfMembers, mostIngredientsPizzas.subList(0, numberOfMembers).stream().map(Pizza::getId).collect(Collectors.toList()));
                    deliveries.add(delivery);
                    mostIngredientsPizzas = mostIngredientsPizzas.subList(numberOfMembers, mostIngredientsPizzas.size());
                } else {
                    break;
                }
            }
        }
        return new Output(deliveries);
    }
}
