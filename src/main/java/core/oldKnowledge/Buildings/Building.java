package core.oldKnowledge.Buildings;

import java.io.InputStream;
import java.util.Objects;

import core.oldKnowledge.Menu.CommandsForExercise;
public abstract class Building
{
    private String address;
    private int buildingWearFactor;
    public Building(String address,int buildingWearFactor) {
        setBuildingWearFactor(buildingWearFactor);
        setAddress(address);
    }
    public Building() {
        this(Constants.DEFAULT_STR_VALUE, Constants.DEFAULT_ZERO_INT_VALUE);
    }

    public Building(InputStream stream) {
        System.out.println("Введите адрес строения:");
        setAddress(new CommandsForExercise.InputUserLine(stream).getText());
        System.out.println("Введите целое значение износа здания в процентах:");
        setBuildingWearFactor(new CommandsForExercise.InputUserInt(stream).getIntNumber());
    }

    static protected String checkStrValue(String valueToCheck, String valueCompared) {
        if (Objects.equals(valueToCheck, valueCompared)) return Constants.DEFAULT_STR_VALUE;
        else return valueToCheck;
    }
    public void setAddress(String address) {
        this.address = checkStrValue(address, Constants.NULL_STR_VALUE);
    }

    public String getAddress() {
        return address;
    }

    static protected int checkIntValue(Integer valueToCheck, Integer minValue, Integer maxValue) {
        if (valueToCheck < minValue || valueToCheck > maxValue) return Constants.DEFAULT_ZERO_INT_VALUE;
        else return valueToCheck;
    }

    public void setBuildingWearFactor(int buildingWearFactor) {
        this.buildingWearFactor = checkIntValue(buildingWearFactor,
                                                Constants.DEFAULT_ZERO_INT_VALUE,
                                                Constants.MAX_PERCENTAGE_FOR_BUILDING_WEAR);
    }

    public int getBuildingWearFactor() {
        return buildingWearFactor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Building building)) return false;
        return buildingWearFactor == building.buildingWearFactor && Objects.equals(address, building.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, buildingWearFactor);
    }

    @Override
    public String toString() {
        return "Buildings.Building{" +
                "address='" + address + '\'' +
                ", buildingWearFactor=" + buildingWearFactor +
                '}';
    }
}
