package core.oldKnowledge.Menu;

public class MenuInputType implements MenuInterface {

    public enum MenuItems {
        NULL_VALUE("Нулевое значение"),
        USER_VALUE("Ввод пользователя");

        private final String description;

        MenuItems(String description) {
            this.description = description;
        }

        public String gescription() {
            return description;
        }
    }
    @Override
    public void printMenu() {
        for (MenuItems item : MenuItems.values()) {
            System.out.printf("%d. %s\n", item.ordinal(), item.description);
        }
    }
}
