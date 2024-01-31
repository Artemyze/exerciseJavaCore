package core.oldKnowledge.Menu;

public class Menu implements MenuInterface{
    public enum MenuItems {
        ADD_ELEMENT("Добавить элемент"),
        EQUALS_ELEMENTS("Сравнить два элемента"),
        DELETE_ELEMENT("Удалить"),
        PRINT_ELEMENTS("Вывести на экран все элементы"),
        EXIT("Выход");
        private final String description;

        MenuItems(String description) {
            this.description = description;
        }

        public String description() {
            return this.description;
        }
    }

    public Menu() {
    }

    public void printMenu() {
        for (MenuItems item : MenuItems.values()) {
            System.out.printf("%d. %s\n", item.ordinal(), item.description);
        }
    }
}

