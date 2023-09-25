import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        try {
            Shop shop = new Shop();
            int id = 0;
            // 1. Добавляем игрушки в коллекцию
            shop.addNewToy(id++, "Кубик Рубика", 45);
            shop.addNewToy(id++, "Монополия", 50);
            shop.addNewToy(id++, "Конструктор", 50);
            shop.addNewToy(id++, "Кукла Барби", 55);
            shop.addNewToy(id++, "Елочка", 55);

            // 2. Разыгрываем игрушки: вызываем метод GetToy 10 раз, согласно заданию
            for (int j = 0; j < 10; j++) {
                System.out.println("Разыграна игрушка: " + shop.GetToy());
            }

            //3. Получаем из shop сформированную очередь и записываем содержимое в файл:
            String pathFile = "toys.txt";
            FileWriter fw = new FileWriter(pathFile);
            BufferedWriter bw = new BufferedWriter(fw);
            PriorityQueue<Toy> queueToys = shop.getQueueToys();
            while(queueToys.size() > 0){
                Toy t = queueToys.element();
                bw.write(t.toString() + System.lineSeparator());
                queueToys.remove();
            }
            bw.close();
            fw.close();
        }
        catch(IOException e){
            System.out.println(e.toString());
        }
        catch (RuntimeException e) {
            System.out.println(e.toString());
        }
    }
}
