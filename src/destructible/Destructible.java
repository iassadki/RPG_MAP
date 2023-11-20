package destructible;

public class Destructible {

    public double life  = 100.;
    private String classe;

    public Destructible(double hp) {
        this.life = hp;
    }

    public Destructible() { }

    public double getLife() {
        return this.life;
    }

    public void hit(double damage) {
        this.life -= damage;
    }

}