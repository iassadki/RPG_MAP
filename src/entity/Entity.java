package entity;

public class Entity {

    // Pas d'accesseurs pour la CONST ci-dessous, accessible via SubEntity.MAX_HP par exemple
    public static final double MAX_HP = 100.;
    private String name;

    public Entity(String name) {
        this.name = name;
    }

    public Entity() {

    }

    // methodes
    public void attack(Entity e) {
        // TODO
    }

    public String getName() {
        return this.name;
    }


   // public void hit(double damage) {
     //   this.life -= damage;
   // }


}