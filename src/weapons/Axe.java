package weapons;

import destructible.Monster;
import entity.*;
import destructible.Obstacle;

public class Axe extends Weapon {

    // +CONSTANT_NAME: TYPE = value

    static final double MONSTER_DAMAGE_RATIO = 0.8; // Effectue 80% du DAMAGE de base de la Axe
    static final double OBSTACLE_DAMAGE_RATIO = 1.2; // Effectue 120% du DAMAGE de base de la Axe

    private static final double DAMAGE = 10;
    private static final double PRICE = 5;

    public Axe() {
        super("Axe", DAMAGE, PRICE);
    }

    /**
     * GetDamageRatio : Si c'est une instance de monstre, on retourne MONSTER_DAMAGE_RATIO,
     * Sinon si c'est un obstacle, on retourne OBSTACLE_DAMAGE_RATIO
     *
     * @param Entity e
     *
     * @return double
     */
    public static double getDamageRatio(Entity e) {
       // if (e instanceof Monster) {
        //    return MONSTER_DAMAGE_RATIO;
        //} else if (e instanceof Obstacle) {
        //    return OBSTACLE_DAMAGE_RATIO;
        //} else {
        //    return 1;
        //}
        return 0;
    }

    public void attack(Entity e) {
        // Je tape l'entité qui y'a devant moi
        // Il y'a plusieurs entités aevc des instances différentes
        //e.hit(this.damage * getDamageRatio(e)); // on recupere le this.damage de l'entité (classe mere)
        // e.hit(100) -> le nombre de degats que donne l'arme)
        // que je vais retirer a l'entité qui est devant moi
        // MAIN : personnage.attack(obstacle1);
    }
}
