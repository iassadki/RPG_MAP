package entity;

import map.Map;
import weapons.*;

public interface ActionsPlayer {

    void addWeapon(Weapon w);
    void buyWeapon(Weapon w);
    void changeWeapon();
    void deplacementOnMap(char direction, Map map);
    void characterChoice(Entity c);
    void fight(Entity c);

}
