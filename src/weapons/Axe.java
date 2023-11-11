package weapons;

import destructible.*;
import entity.Monster;
import entity.Obstacle;

public class Axe extends Weapon {

    static final double MONSTER_DAMAGE_RATIO = 0.8;
    static final double OBSTACLE_DAMAGE_RATIO = 1.2;

    private static final double DAMAGE = 10;
    private static final double PRICE = 5;

    public Axe() {
        super("Axe", DAMAGE, PRICE);
    }

    public static double getDamageRatio(Destructible d) {
        if (d instanceof Monster) {
            return MONSTER_DAMAGE_RATIO;
        } else if (d instanceof Obstacle) {
            return OBSTACLE_DAMAGE_RATIO;
        } else {
            return 1.;
        }
    }
    public void attack(Destructible d) {
        d.hit(this.damage * getDamageRatio(d));
    }
}
