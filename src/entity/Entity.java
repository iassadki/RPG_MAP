package entity;

import destructible.Destructible;
import weapons.Weapon;

public class Entity {

    private String name;
    private double HP;
    private int specialAttackCount;
    Player p;

    public Entity(String name) {
        this.name = name;
        this.HP = 100.0;
        this.specialAttackCount = 2;
    }

    public Entity() {
        this.HP = 100.0;
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

    public double getSpecialAttackCount() {
        return specialAttackCount;
    }

    public void hit(double damage) {
        this.HP -= damage;
    }

    public void specialAttack(Player p, Destructible d) {
    }

}
