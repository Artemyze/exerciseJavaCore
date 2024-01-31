package core.oldKnowledge;

import java.io.InputStream;
import core.oldKnowledge.Buildings.Building;
import core.oldKnowledge.Buildings.Flat;
import core.oldKnowledge.Buildings.Garage;
import core.oldKnowledge.Buildings.House;

public final class FactoryBuildings {
    public static Building createBuilding(BuildingType type) {
        Building building = null;
        switch (type) {
            case HOUSE -> building = new House();
            case APARTMENT -> building = new Flat();
            case GARAGE -> building = new Garage();
        }
        return building;
    }

    public static Building createBuilding(BuildingType type, InputStream stream) {
        Building building = null;
        switch (type) {
            case HOUSE -> building = new House(stream);
            case APARTMENT -> building = new Flat(stream);
            case GARAGE -> building = new Garage(stream);
        }
        return building;
    }
}
