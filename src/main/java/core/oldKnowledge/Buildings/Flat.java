package core.oldKnowledge.Buildings;

import java.io.InputStream;
import java.util.Objects;

import core.oldKnowledge.Menu.CommandsForExercise;

public class Flat extends House
{
    private int apartmentNumber;
    private String ownerName;

    public Flat(String address, int buildingWearFactor,
                String nameOfManagingCompany, int amountFlats,
                String ownerName, int apartmentNumber) {
        super(address, buildingWearFactor, nameOfManagingCompany, amountFlats);
        setApartmentNumber(apartmentNumber);
        setOwnerName(ownerName);
    }

    public Flat() {
        this(Constants.DEFAULT_STR_VALUE, Constants.DEFAULT_ZERO_INT_VALUE,
                Constants.DEFAULT_STR_VALUE, Constants.DEFAULT_ZERO_INT_VALUE,
                Constants.DEFAULT_STR_VALUE, Constants.DEFAULT_ZERO_INT_VALUE);
    }
    public Flat(InputStream stream) {
        super(stream);
        System.out.println("Введите ФИО владельца квартиры");
        setOwnerName(new CommandsForExercise.InputUserLine(stream).getText());
        System.out.println("Номер квартиры");
        setApartmentNumber(new CommandsForExercise.InputUserInt(stream).getIntNumber());
    }


    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = checkIntValue(apartmentNumber,
                Constants.DEFAULT_ZERO_INT_VALUE,
                Constants.MAX_FLATS_IN_HOUSE);
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
            this.ownerName = checkStrValue(ownerName, Constants.NULL_STR_VALUE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flat flat)) return false;
        if (!super.equals(o)) return false;
        return apartmentNumber == flat.apartmentNumber && Objects.equals(ownerName, flat.ownerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), apartmentNumber, ownerName);
    }

    @Override
    public String toString() {
        return String.format("%s Buildings.House{ownerName='%s', apartmentNumber=%d}",
                super.toString(),
                this.ownerName,
                this.apartmentNumber );
    }
}
