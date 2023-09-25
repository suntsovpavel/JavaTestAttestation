public class Toy implements Comparable {
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

    @Override
    public String toString() {
        return String.format("(id: %d, name: %s, weight: %d)", id, name, weight);
    }

    // Пишем свой компаратор, сначала по весу weight, затем по имени name
    @Override
    public int compareTo(Object o){
        int deltaWeigths = ((Toy) o).getWeight() - this.weight;
        if(deltaWeigths == 0){
            return this.getName().compareTo(((Toy) o).getName());
        }else{
            return deltaWeigths;
        }
    }
}