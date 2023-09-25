
public class Main {
    public static void main(String[] args) {
        try {
            Shop shop = new Shop();
            int id = 0;
            // 1. Добавляем игрушки в коллекцию
            shop.addNewToy(id++, "Кубик Рубика", 25);
            shop.addNewToy(id++, "Монополия", 75);
            shop.addNewToy(id++, "Конструктор", 35);
            shop.addNewToy(id++, "Кукла Барби", 99);

            // 2. Разыгрываем игрушки: вызываем метод GetToy 10 раз, согласно заданию
            for (int j = 0; j < 10; j++) {
                System.out.println("Разыграна игрушка: " + shop.GetToy());
            }

        } catch (RuntimeException e) {
            System.out.println(e);
        }
    }
}
