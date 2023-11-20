package entity;

import destructible.Destructible;

public class Warrior extends Entity {

    public static final String name = "Warrior";
    public static final double HP = 100.;
    public static int specialAttackCount = 2;

    public Warrior(String name) {
        super(name);
    }

    public Warrior() {
    }

    public void specialAttack(Player player, Destructible d) {
        if (specialAttackCount > 0) {
            d.hit(player.getWeapons().get(0).getDamage() * 3);
            specialAttackCount--;
        } else {
            System.out.println("Vous n'avez pas assez de points d'attaque spéciale.");
        }
    }


}
