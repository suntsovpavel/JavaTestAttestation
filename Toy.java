public class Toy {
    private int id;
    private String name; // название игрушки
    private int weight; // вес = частота выпадения, условно от 1 до 100

    public Toy(int id, String name, int weight) throws RuntimeException {
        this.id = id;
        if (name.length() == 0) {
            throw new RuntimeException("Конструктор Toy: name.length() == 0");
        }
        this.name = name;

        if (weight < 1 || weight > 99) {
            throw new RuntimeException("Конструктор Toy: get weight out of range [1; 99]");
        }
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }
}