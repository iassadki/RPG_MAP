package entity;

public class Warrior extends Entity {

    public static final double HP = 100.; // Accessible via Hero.HP

    public Warrior(String name) {
        super(name);    // Appel du constructeur de la classe parente
    }

    public Warrior() { }
}
