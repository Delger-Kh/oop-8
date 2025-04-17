public class PolymorphismTest {
    public static void main(String[] args) {
        Livestock[] animals = {
            new Horse("Сэрүүн", 5),
            new Sheep("Хөвсгөл", 3),
            new Camel("Алтай", 7),
            new Goat("Зэгст", 2)
        };

        for (Livestock animal : animals) {
            animal.graze(); // Полиморфик дуудалт
        }
    }
}