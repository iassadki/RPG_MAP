package destructible;

public class Destructible {

    protected double life  = 100.;

    public Destructible(double hp) {
        this.life = hp;
    }

    public double getLife() {
        return this.life;
    }

    public void hit(double damage) {
        this.life -= damage;
    }

}