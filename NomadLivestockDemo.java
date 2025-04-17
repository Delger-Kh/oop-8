import java.util.ArrayList;

// 1. Абстракт Класс: Livestock (Мал)
abstract class Livestock {
    String name;
    int age;

    public Livestock(String name, int age) {
        this.name = name;
        this.age = age;
    }

    abstract String makeSound();

    void graze() {
        System.out.println(name + " талбайд бэлчинэ.");
    }

    void graze(String food) {
        System.out.println(name + " " + food + "-ыг бэлчинэ.");
    }
}

// 2. Интерфейс: WorkRole (Ажлын Үүрэг)
interface WorkRole {
    String performTask();
}

// 3. Морь Класс
class Horse extends Livestock implements WorkRole {
    public Horse(String name, int age) {
        super(name, age);
    }

    @Override
    String makeSound() {
        return "Янцгаана!";
    }

    @Override
    public String performTask() {
        return "Морь талбайд уналгад хэрэглэгдэнэ.";
    }
}

// 4. Хонь Класс
class Sheep extends Livestock {
    public Sheep(String name, int age) {
        super(name, age);
    }

    @Override
    String makeSound() {
        return "Маа!";
    }
}

// 5. Тэмээ Класс
class Camel extends Livestock implements WorkRole {
    public Camel(String name, int age) {
        super(name, age);
    }

    @Override
    String makeSound() {
        return "Буйлна!";
    }

    @Override
    public String performTask() {
        return "Тэмээ говийн тээвэрт хэрэглэгдэнэ.";
    }
}

// ✅ 6. Ямаа Класс (Шинэ мал)
class Goat extends Livestock implements WorkRole {
    public Goat(String name, int age) {
        super(name, age);
    }

    @Override
    String makeSound() {
        return "Мэ-э!";
    }

    @Override
    public String performTask() {
        return "Ямаа уулын хаданд авирч сүү өгнө.";
    }

    // Overloaded method
    String makeSound(int volume) {
        return "Мэ-э! (чанга = " + volume + ")";
    }
}

// 7. Сүрэг Класс (Herd)
class Herd {
    ArrayList<Livestock> livestock = new ArrayList<>();

    void addLivestock(Livestock animal) {
        livestock.add(animal);
    }

    void dailyRoutine() {
        for (Livestock animal : livestock) {
            System.out.println(animal.name + ": " + animal.makeSound());
            if (animal instanceof WorkRole) {
                System.out.println(((WorkRole) animal).performTask());
            }
        }
    }
}

// 8. Үндсэн Класс (Main)
public class NomadLivestockDemo {
    public static void main(String[] args) {
        Herd herd = new Herd();

        herd.addLivestock(new Horse("Баян", 4));
        herd.addLivestock(new Sheep("Чулуун", 2));
        herd.addLivestock(new Camel("Тэмүр", 6));
        herd.addLivestock(new Goat("Ууган", 3)); // ✅ New goat added

        // Өдөр тутмын амьдрал
        System.out.println("=== Сүргийн Өдөр тутмын амьдрал ===");
        herd.dailyRoutine();

        // ✅ makeSound(int volume) test
        Goat testGoat = new Goat("Туршилт", 1);
        System.out.println("\n" + testGoat.name + ": " + testGoat.makeSound(5));

        // ✅ Полиморфизм test
        System.out.println("\n=== Полиморфизм Туршилт ===");
        Livestock[] animals = {
            new Horse("Тэнгис", 5),
            new Sheep("Нараа", 2),
            new Camel("Сайхан", 7),
            new Goat("Өлзий", 4)
        };

        for (Livestock a : animals) {
            a.graze();
        }
    }
}