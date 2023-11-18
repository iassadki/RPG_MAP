package entity;

import map.Map;
import weapons.*;
import destructible.Destructible;

public interface ActionsPlayer {

    void addWeapon(Weapon w);
    void buyWeapon(Weapon w);
    void changeWeapon();
    char deplacementOnMap(char direction, Map map, Entity e);
    void characterChoice(Entity c);
    void attack(Destructible d);

}
