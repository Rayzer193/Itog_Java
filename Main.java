import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    
        List<Toy> toys = new ArrayList<>();
        toys.add(new Toy(1, "Плюшевая", 5));
        toys.add(new Toy(2, "Кукла", 5));
        toys.add(new Toy(3, "Машинка", 8));
        toys.add(new Toy(4, "Лего", 15));
        toys.add(new Toy(5, "Робот", 12));
        toys.add(new Toy(6, "Мяч", 17));

        int totalToys = Toy.getTotalToys();
        for (Toy toy : toys) {
            toy.calculateFrequency(totalToys);
        }
    
        
        DrawingToys toyLottery = new DrawingToys(toys);
    
     
        Toy prizeToy = toyLottery.choice_toy();
        if (prizeToy != null) {
            try {
                FileWriter writer = new FileWriter("prizeToys.txt");
                writer.write(prizeToy.toString()); 
                writer.close(); 
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Поздравляем! Вы выиграли игрушку: " + prizeToy.getName());
        }
    }
}