package fr.ynov.rpg.village;
import fr.ynov.rpg.building.Building;

import java.util.ArrayList;
import java.util.List;

public class Village {
    private List<Building> buildings;

    Village(List<Building> buildings){
        this.buildings = buildings;
    }
}
