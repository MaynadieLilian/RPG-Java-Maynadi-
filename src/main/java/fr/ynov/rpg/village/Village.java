package fr.ynov.rpg.village;
import fr.ynov.rpg.building.Building;

import java.util.ArrayList;
import java.util.List;

public class Village {
    private ArrayList<Building> buildings;

    Village(ArrayList<Building> buildings){
        this.buildings = buildings;
    }

    public ArrayList<Building> getBuildings() {
        return this.buildings;
    }

    public void addBuilding(Building building){
        this.buildings.add(building);
    }

    public void removeBuilding(int index){
        this.buildings.remove(index);
    }

    public void show(){
        System.out.println("Village: ");
        for(int i = 0; i < this.buildings.size(); i++){
            System.out.println(i+1+": "+this.buildings.get(i).getName()+" ");
        }
    }
}
