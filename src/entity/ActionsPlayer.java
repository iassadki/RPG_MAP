package entity;

import weapons.*;

public interface ActionsPlayer {

    void buyWeapon(Weapon w);
    void changeWeapon(Weapon w);
    // void deplacementOnMap();
    void characterChoice(Entity c);
    void fight(Entity c);

}
