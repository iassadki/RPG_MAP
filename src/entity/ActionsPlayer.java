package entity;

import weapons.*;

public interface ActionsPlayer {

    void addWeapon(Weapon w);
    void buyWeapon(Weapon w);
    void changeWeapon();
    // void deplacementOnMap();
    void characterChoice(Entity c);
    void fight(Entity c);

}
