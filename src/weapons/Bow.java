package weapons;

public class Bow extends Weapon {

    private static final double DAMAGE = 15;
    private static final double PRICE = 10;

    public Bow() {
        super("Bow", DAMAGE, PRICE);
    }

}
