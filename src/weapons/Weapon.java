package weapons;

public abstract class Weapon {

    private double damage;
    private double price;
    private String name;

    public Weapon(String name, double damage, double price) {
        this.name = name;
        this.damage = damage;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public double getDamage() {
        return this.damage;
    }

    public double getPrice() {
        return this.price;
    }

    public String toString() {
        return this.name + " : price = " + this.price + " $ ; damage = " + this.damage;
    }

}
