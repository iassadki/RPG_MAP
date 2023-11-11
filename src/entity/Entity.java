package entity;

public class Entity {

    public static final int MAX_HEALTH = 100;
    private String name;

    public Entity(String name) {
        this.name = name;
    }

    public Entity() {

    }

    // methodes
    public void attack(Entity h) {
        // TODO
    }

    public String getName() {
        return this.name;
    }


}
