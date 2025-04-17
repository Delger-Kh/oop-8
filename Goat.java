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

    // Method overloading
    String makeSound(int volume) {
        return "Мэ-э! (чанга = " + volume + ")";
    }
}