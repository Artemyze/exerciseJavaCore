package core.oldKnowledge;

public enum BuildingType {
    HOUSE("Дом"),
    APARTMENT("Квартира"),
    GARAGE("Гараж"),;

    private final String description;

    BuildingType(String description) {
        this.description = description;
    }

    public String description() {
        return this.description;
    }
}
