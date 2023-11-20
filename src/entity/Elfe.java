package entity;

import destructible.Destructible;

import java.util.Random;

public class Elfe extends Entity {

    public static final String name = "Elfe";
    public static final double HP = 100.;
    public static int specialAttackCount = 2;

    public Elfe(String name) {
        super(name);
    }

    public Elfe() {
    }

    public void specialAttack(Player player, Destructible d) {
        if (specialAttackCount > 0) {
            Random random = new Random();
            int nombreAleatoire = random.nextInt(4) + 3;
            d.hit(player.getWeapons().get(0).getDamage() * nombreAleatoire);
            specialAttackCount--;
        } else {
            System.out.println("Vous n'avez pas assez de points d'attaque spéciale.");
        }
    }
}
