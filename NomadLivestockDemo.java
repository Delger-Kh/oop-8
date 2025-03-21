import java.util.ArrayList;

// 1. Абстракт Класс: Livestock (Мал)
// Малын нийтлэг шинж чанаруудыг тодорхойлно
abstract class Livestock {
    String name;
    int age;

    // Конструктор: Малын нэр, насыг оноох
    public Livestock(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Абстракт арга: Мал дуугарах
    abstract String makeSound();

    // Бэлчих үйлдэл (гразе)
    void graze() {
        System.out.println(name + " талбайд бэлчинэ.");
    }

    // Бэлчээрийн өвсийг тодорхойлох хэт ачаалалтай арга
    void graze(String food) {
        System.out.println(name + " " + food + "-ыг бэлчинэ.");
    }
}

// 2. Интерфейс: WorkRole (Ажлын Үүрэг)
// Ажлын зориулалттай малыг тодорхойлох интерфейс
interface WorkRole {
    String performTask();
}

// 3. Морь Класс
// Livestock-оос өвлөнө, WorkRole интерфейсийг хэрэгжүүлнэ
class Horse extends Livestock implements WorkRole {
    public Horse(String name, int age) {
        super(name, age);
    }

    // Морь дуугарах
    @Override
    String makeSound() {
        return "Янцгаана!";
    }

    // Морийн ажил үүрэг
    @Override
    public String performTask() {
        return "Морь талбайд уналгад хэрэглэгдэнэ.";
    }
}

// 4. Хонь Класс
// Livestock-оос өвлөнө
class Sheep extends Livestock {
    public Sheep(String name, int age) {
        super(name, age);
    }

    // Хонь дуугарах
    @Override
    String makeSound() {
        return "Маа!";
    }
}

// 5. Тэмээ Класс
// Livestock-оос өвлөнө, WorkRole интерфейсийг хэрэгжүүлнэ
class Camel extends Livestock implements WorkRole {
    public Camel(String name, int age) {
        super(name, age);
    }

    // Тэмээ дуугарах
    @Override
    String makeSound() {
        return "Буйлна!";
    }

    // Тэмээний ажил үүрэг
    @Override
    public String performTask() {
        return "Тэмээ говийн тээвэрт хэрэглэгдэнэ.";
    }
}

// 6. Сүрэг Класс (Herd)
// Малын жагсаалтыг удирдах
class Herd {
    ArrayList<Livestock> livestock = new ArrayList<>();

    // Мал нэмэх арга
    void addLivestock(Livestock animal) {
        livestock.add(animal);
    }

    // Өдөр тутмын үйл ажиллагаа
    void dailyRoutine() {
        for (Livestock animal : livestock) {
            System.out.println(animal.name + ": " + animal.makeSound());
            // Хэрэв мал WorkRole интерфейстэй бол ажлын үүргийг харуулна
            if (animal instanceof WorkRole) {
                System.out.println(((WorkRole) animal).performTask());
            }
        }
    }
}

// 7. Үндсэн Класс (Main)
public class NomadLivestockDemo {
    public static void main(String[] args) {
        // Сүрэг үүсгэх
        Herd herd = new Herd();
        
        // Мал нэмэх
        herd.addLivestock(new Horse("Баян", 4));
        herd.addLivestock(new Sheep("Чулуун", 2));
        herd.addLivestock(new Camel("Тэмүр", 6));

        // Малын өдөр тутмын амьдралыг харуулах
        herd.dailyRoutine();
    }
}

