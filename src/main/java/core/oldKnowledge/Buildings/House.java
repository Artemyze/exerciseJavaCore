package core.oldKnowledge.Buildings;

import java.io.InputStream;
import java.util.Objects;

import core.oldKnowledge.Menu.CommandsForExercise;
public class House extends Building
{
    private String nameOfManagingCompany;
    private int amountFlats;
    public House(String address, int buildingWearFactor,
                 String nameOfManagingCompany, int amountFlats) {
        super(address, buildingWearFactor);
        setAmountFlats(amountFlats);
        setNameOfManagingCompany(nameOfManagingCompany);
    }

    public House() {
        this(Constants.DEFAULT_STR_VALUE, Constants.DEFAULT_ZERO_INT_VALUE,
                Constants.DEFAULT_STR_VALUE, Constants.DEFAULT_ZERO_INT_VALUE);
    }
    public House(InputStream stream) {
        super(stream);
        System.out.println("Введите название обслуживающей компании");
        setNameOfManagingCompany(new CommandsForExercise.InputUserLine(stream).getText());
        System.out.println("Введите количество квартир");
        setAmountFlats(new CommandsForExercise.InputUserInt(stream).getIntNumber());
    }

    public String getNameOfManagingCompany() {
        return nameOfManagingCompany;
    }

    public void setNameOfManagingCompany(String nameOfManagingCompany) {
        this.nameOfManagingCompany = checkStrValue(nameOfManagingCompany, Constants.NULL_STR_VALUE);
    }

    public int getAmountFlats() {
        return amountFlats;
    }

    public void setAmountFlats(int amountFlats) {
        this.amountFlats = checkIntValue(amountFlats,
                    Constants.DEFAULT_ZERO_INT_VALUE,
                    Constants.MAX_FLATS_IN_HOUSE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof House house)) return false;
        if (!super.equals(o)) return false;
        return amountFlats == house.amountFlats && Objects.equals(nameOfManagingCompany, house.nameOfManagingCompany);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nameOfManagingCompany, amountFlats);
    }

    @Override
    public String toString() {
        return String.format("%s Buildings.House{nameOfManagingCompany='%s', amountFlats=%d}",
                super.toString(),
                this.nameOfManagingCompany,
                this.amountFlats );
    }
}
