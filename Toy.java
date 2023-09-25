public class Toy {
    private int id;
    private String name; // название игрушки
    private int weight; // вес = частота выпадения, условно от 1 до 100
    private String messageError; // сообщение-результат проверок в конструкторе. Если все ок, = null

    public Toy(int id, String name, int weight) {
        this.messageError = null;
        this.id = id;
        if (name.length() == 0) {
            messageError = "get empty name";
            return;
        }
        if (weight < 1 || weight > 99) {
            messageError = "get weight out of range [1; 99]";
            return;
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

    public String getMessageError() {
        return messageError;
    }
}