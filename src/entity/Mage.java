package entity;

import destructible.Destructible;

import java.util.Random;

public class Mage extends Entity {

    public static final String name = "Mage";
    public static final double HP = 100.;
    public static int specialAttackCount = 2;

    public Mage(String name) {
        super(name);
    }

    public Mage() {
    }

    public void specialAttack(Player player, Destructible d) {
        if (specialAttackCount > 0) {
            Random random = new Random();
            int nombreAleatoire = random.nextInt(4) + 2;
            d.hit(p.getWeapons().get(0).getDamage() * nombreAleatoire);
            specialAttackCount--;
        } else {
            System.out.println("Vous n'avez pas assez de points d'attaque spéciale.");
        }
    }
}
