package entity;

import destructible.*;

public class Monster extends Destructible {
    private static final double HP = 100.;

    public Monster(String s) {
        super(HP);
    }

}
