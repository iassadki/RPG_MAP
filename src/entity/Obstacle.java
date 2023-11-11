package entity;

import destructible.Destructible;

public class Obstacle extends Destructible {
    private static final double HP = 50.;

    public Obstacle() {
        super(HP);
    }

}
