package core.oldKnowledge.Menu;


public class MenuAddBuildingObj implements MenuInterface {
    enum MenuItems {
        ADD_HOUSE("Добавить дом"),
        ADD_APARTMENT("Добавить квартиру"),
        ADD_GARAGE("Добавить гараж"),;
        private final String description;

        MenuItems(String description) {
            this.description = description;
        }

        public String description() {
            return this.description;
        }
    }

    public MenuAddBuildingObj() {
    }

    public void printMenu() {
        for (MenuItems item : MenuItems.values()) {
            System.out.printf("%d. %s\n", item.ordinal(), item.description);
        }
    }
}
