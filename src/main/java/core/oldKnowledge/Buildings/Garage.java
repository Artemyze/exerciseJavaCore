package core.oldKnowledge.Buildings;

import java.io.InputStream;
import java.util.Objects;

import core.oldKnowledge.Menu.CommandsForExercise;

public class Garage extends Building{
    private int numberOfStoreys;
    private String equipmentOfTheGarage;

    public Garage(String address, int buildingWearFactor,
                  String equipmentOfTheGarage, int numberOfStoreys) {
        super(address, buildingWearFactor);
        this.numberOfStoreys = numberOfStoreys;
        this.equipmentOfTheGarage = equipmentOfTheGarage;
    }

    public Garage() {
        this(Constants.DEFAULT_STR_VALUE, Constants.DEFAULT_ZERO_INT_VALUE,
                Constants.DEFAULT_STR_VALUE, Constants.DEFAULT_ZERO_INT_VALUE);
    }

    public Garage(InputStream stream) {
        super(stream);
        System.out.println("Введите оборудование гаража");
        setEquipmentOfTheGarage(new CommandsForExercise.InputUserLine(stream).getText());
        System.out.println("Сколько этажей в гараже?");
        setNumberOfStoreys(new CommandsForExercise.InputUserInt(stream).getIntNumber());
    }


    public String getEquipmentOfTheGarage() {
        return equipmentOfTheGarage;
    }

    public void setEquipmentOfTheGarage(String equipmentOfTheGarage) {
        this.equipmentOfTheGarage = checkStrValue(equipmentOfTheGarage, Constants.NULL_STR_VALUE);
    }

    public int getNumberOfStoreys() {
        return numberOfStoreys;
    }

    public void setNumberOfStoreys(int numberOfStoreys) {
        this.numberOfStoreys = checkIntValue(numberOfStoreys,
                    Constants.DEFAULT_ZERO_INT_VALUE,
                    Constants.MAX_FLATS_IN_HOUSE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Garage garage)) return false;
        if (!super.equals(o)) return false;
        return numberOfStoreys == garage.numberOfStoreys && Objects.equals(equipmentOfTheGarage, garage.equipmentOfTheGarage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfStoreys, equipmentOfTheGarage);
    }

    @Override
    public String toString() {
        return String.format("%s Buildings.Garage{equipmentOfTheGarage='%s', numberOfStoreys=%d}",
                super.toString(),
                this.equipmentOfTheGarage,
                this.numberOfStoreys );
    }
}
