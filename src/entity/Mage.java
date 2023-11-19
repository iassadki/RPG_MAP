package entity;

public class Mage extends Entity {

    public static final double HP = 100.; // Accessible via Mage.HP

    public Mage(String name) {
        super(name); // Appel du constructeur de la classe parente
    }

    public Mage() { }
}
