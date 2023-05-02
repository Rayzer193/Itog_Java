import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Розыгрыш игрушек
 */

public class DrawingToys {
    private List<Toy> toysList;
    private List<Toy> prizeToysList;

    public DrawingToys(List<Toy> toysList) {
        this.toysList = toysList;
        prizeToysList = new ArrayList<>();
    }

    public Toy choice_toy() {
        float randomValue = new Random().nextFloat() * 100;
        float sumFrequency = 0;
        for (Toy toy : toysList) {
            sumFrequency += toy.frequency;
            if (randomValue <= sumFrequency) {
                return toy;
            }
        }
        return null;
    }

    public void addPrizeToy(Toy prizeToy) {
        if (toysList.contains(prizeToy) && prizeToy.sum > 0 && !prizeToysList.contains(prizeToy)) {
            toysList.get(toysList.indexOf(prizeToy)).reduceQuantity(1, Toy.getTotalToys());
            prizeToysList.add(prizeToy);
        }
    }

    public Toy getPrizeToy() {
        if (prizeToysList.isEmpty()) { 
            return null;
        }
        Toy prizeToy = prizeToysList.get(0);
        prizeToysList.remove(0);
        return prizeToy;
    }
}