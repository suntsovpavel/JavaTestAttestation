import java.util.List;
import java.util.ArrayList;
import java.util.Random;

//магазин игрушек
public class Shop {
    // 1. Коллекция разыгрываемых игрушек
    private List<Toy> toys;

    public List<Toy> getCollectionToys() {
        return toys;
    }

    public Shop() {
        toys = new ArrayList<>();
    }

    // Добавляем новую игрушку в коллекцию разыгрываемых
    public void addNewToy(Toy toy) throws RuntimeException {
        if (toy.getMessageError() != null)
            throw new RuntimeException(toy.getMessageError());

        // Пополняем коллекцию
        toys.add(toy);
    }

    // Разыгрываем игрушку
    public Toy GetToy() throws RuntimeException {
        if (toys.size() == 0) {
            throw new RuntimeException("Коллекция игрушек для розыгрыша пуста. Добавьте элементы");
        }
        // Реализуем алгоритм розыгрыша игрушки с учетом веса(частоты выпадения)
        // 1. Суммируем веса всех игрушек
        int sumWeigths = 0;
        for (Toy t : toys) {
            sumWeigths += t.getWeight();
        }
        // 2. Генерим случайное число от 0 до sumWeigths-1:
        Random rnd = new Random();
        int randomValue = rnd.nextInt(sumWeigths);

        // 3. Повторно обходим список и выбираем игрушку,
        // для которой текущая сумма превысила randomValue:
        sumWeigths = 0;
        for (Toy t : toys) {
            sumWeigths += t.getWeight();
            if (randomValue < sumWeigths) {
                return t;
            }
        }
        // Сюда добраться не должны
        throw new RuntimeException("Shop::GetToy(), ошибка алгоритма");
    }
}
