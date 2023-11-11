package weapons;

public abstract class Weapon {

    protected double damage;
    protected double price;

    protected String name;

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

    // public abstract String ascii_art();
}
