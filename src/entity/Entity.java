package entity;

public class Entity {

    private String name;
    private double HP; // Ajout d'une variable pour stocker les points de vie actuels

    public Entity(String name) {
        this.name = name;
        this.HP = 100.0; // Initialise les points de vie actuels avec une valeur par défaut
    }

    public Entity() {
        this.HP = 100.0; // Initialise les points de vie actuels avec une valeur par défaut
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCurrentHP() {
        return this.HP;
    }

    public void hit(double damage) {
        this.HP -= damage;
    }

}
