package hashcode.y21.practice;

import hashcode.y21.practice.dto.Delivery;
import hashcode.y21.practice.dto.Input;
import hashcode.y21.practice.dto.Output;
import hashcode.y21.practice.dto.Pizza;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
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
                    val teamPizzas = new LinkedList<Long>();
                    teamPizzas.add(mostIngredientsPizzas.get(0).getId());
                    val ingredients = mostIngredientsPizzas.get(0).getIngredients();
                    mostIngredientsPizzas = mostIngredientsPizzas.subList(1, mostIngredientsPizzas.size());

                    for (int k = 0; k < numberOfMembers - 1; k++) {
                        var ingredientsToCompare = new HashSet<>(ingredients);
                        var maxIngredients = ingredients.size();
                        Pizza chosenPizza = mostIngredientsPizzas.get(0);
                        int chosenPizzaIdx = 0;
                        for (int j = 0; j < mostIngredientsPizzas.size(); j++) {
                            final Pizza pizza = mostIngredientsPizzas.get(j);
                            ingredientsToCompare.addAll(pizza.getIngredients());
                            if (ingredientsToCompare.size() > maxIngredients) {
                                maxIngredients = ingredientsToCompare.size();
                                chosenPizza = pizza;
                                chosenPizzaIdx = j;
                            }
                            ingredientsToCompare = new HashSet<>(ingredients);
                        }
                        log.debug("TeamMember {} in team {} with number of members {} will eat pizza {}", k + 1, i, numberOfMembers, chosenPizza);
                        teamPizzas.add(chosenPizza.getId());
                        mostIngredientsPizzas.remove(chosenPizzaIdx);
                        ingredients.addAll(chosenPizza.getIngredients());
                    }
                    deliveries.add(new Delivery(numberOfMembers, teamPizzas));
                } else {
                    break;
                }
            }
        }
        return new Output(deliveries);
    }
}
