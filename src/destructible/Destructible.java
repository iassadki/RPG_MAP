package destructible;

public class Destructible {

    public double life  = 100.;

    public Destructible(double hp) {
        this.life = hp;
    }

    public Destructible() { } // constructeur vide

    public double getLife() {
        return this.life;
    }

    public void hit(double damage) {
        this.life -= damage;
    }

}