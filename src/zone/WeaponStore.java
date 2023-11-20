package zone;

import weapons.Axe;
import weapons.Bow;
import weapons.Hammer;
import weapons.Weapon;

import java.util.ArrayList;

public class WeaponStore {

    private ArrayList<Weapon> weaponsList;

    public WeaponStore() {
        this.weaponsList = new ArrayList<Weapon>();
        this.weaponsList.add(new Bow());
        this.weaponsList.add(new Axe());
        this.weaponsList.add(new Hammer());
    }

    public void printWeaponsList() {
        System.out.println("Available weapons in the store:");
        int displayIndex = 1;
        for (Weapon w : this.weaponsList) {
            System.out.println((Integer.toString(displayIndex)) + "." + " " + w.toString());
            displayIndex++;
        }
    }

    public Weapon getWeapon(int userInputIndex) {
        int actualIndex = userInputIndex - 1;

        if (actualIndex >= 0 && actualIndex < weaponsList.size()) {
            return weaponsList.get(actualIndex);
        } else {
            System.out.println("L'index choisi n'est pas valide.");
            return null;
        }
    }
}
