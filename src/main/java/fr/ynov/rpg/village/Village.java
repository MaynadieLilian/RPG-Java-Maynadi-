package fr.ynov.rpg.village;
import fr.ynov.rpg.building.Building;

import java.util.ArrayList;

public class Village {
    private ArrayList<Building> buildings;

    public Village(){
        this.buildings = new ArrayList<>();
    }

    public ArrayList<Building> getBuildings() {
        return this.buildings;
    }

    public void addBuilding(Building building){
        this.buildings.add(building);
    }

    public void show(){
        System.out.println("Village: ");
        for(int i = 0; i < this.buildings.size(); i++){
            System.out.println(i+1+": "+this.buildings.get(i).getName()+" ");
        }
    }
}
