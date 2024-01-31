package core.oldKnowledge;

import java.util.ArrayList;
import java.util.Scanner;

import core.oldKnowledge.Buildings.Building;
import core.oldKnowledge.Menu.CommandsForExercise;
import core.oldKnowledge.Menu.Menu;
import core.oldKnowledge.Menu.MenuAddBuildingObj;
import core.oldKnowledge.Menu.MenuInputType;
import core.oldKnowledge.Menu.RunnableExercise;

public class Program {
    private static ArrayList<Building> buildings = new ArrayList<>(); //массив с координатами точек, введенными юзером или рандомом
    RunnableExercise command;
    private static boolean isWork = true,
            isChanged = false,
            isProcessed = false;
    private static final Program appInstance = new Program(); // создается только один экземплр класса

    private Program() {
        this.command = null;
    }

    public static Program getAppInstance() {
            return appInstance;
        } // возвращает вход для синглтона


    public void run() { //основной метод программы, соединяющий всё вместе
        Menu menu = new Menu(); //отвечает за пользовательский интерфейс
        try (Scanner scanner = new Scanner(System.in)) {
			do {
			    menu.printMenu();// выводит для пользователя необходимый текст(пункты меню) для взаимодействия с программой
			    int choice = scanner.nextInt();

			    // пользователь вводит число, соответствующее пункту меню
			    Menu.MenuItems menuItem;
			    try {
			        menuItem = Menu.MenuItems.values()[choice];
			    } catch (Exception e) {
			        System.out.println(e.getMessage());
			        continue;
			    }
			    // затем объект menuItem cравнивается с объектами enum из класса Menu
			    // и выполняются соответствующие действия
			    switch (menuItem) {
			        case ADD_ELEMENT -> {
			            MenuInputType menuInputType = new MenuInputType();
			            menuInputType.printMenu();
			            choice = new CommandsForExercise.InputUserInt(System.in).getIntNumber();
			            MenuInputType.MenuItems menuItemsInputType;
			            try {
			                menuItemsInputType = MenuInputType.MenuItems.values()[choice];
			            } catch (Exception e) {
			                System.out.println(e.getMessage());
			                break;
			            }
			            MenuAddBuildingObj menuAddBuildingObj = new MenuAddBuildingObj();
			            menuAddBuildingObj.printMenu();

			            choice = new CommandsForExercise.InputUserInt(System.in).getIntNumber();
			            BuildingType buildingType;
			            try {
			                buildingType = BuildingType.values()[choice];
			            } catch (Exception e) {
			                System.out.println(e.getMessage());
			                break;
			            }
			            Building newBuilding = null;
			            switch (menuItemsInputType) {
			                case NULL_VALUE -> newBuilding = FactoryBuildings.createBuilding(buildingType);
			                case USER_VALUE -> newBuilding = FactoryBuildings.createBuilding(buildingType, System.in);
			            }
			            RunnableExercise command = new CommandsForExercise.AddElementToArrList(newBuilding, buildings);
			            command.run();
			            this.setIsChanged(true); // поднимаем флаг изменения данных
			            this.setIsProcessed(false); // опускаем флаг что данные уже обработанны
			        }
			        case DELETE_ELEMENT -> {
			            System.out.println("Уточните индекс удаляемого элемента");
			            int userIndex = new CommandsForExercise.InputUserInt(System.in).getIntNumber();
			            RunnableExercise command = new CommandsForExercise.DelElement(buildings, userIndex); // метод ввода рандомных точек в массив
			            this.setIsChanged(true);
			            this.setIsProcessed(false);
			        }
			        case PRINT_ELEMENTS -> { // сортировка реализованная через переопределнные Comparators класса
			            this.command = new CommandsForExercise.ArrPrint(buildings);
			            command.run();
			        }
			        case EQUALS_ELEMENTS -> {// редактор
			            System.out.println("Введите индекс первого элемента:");
			            int userIndex = new CommandsForExercise.InputUserInt(System.in).getIntNumber();
			            Building obj1 = buildings.get(userIndex);
			            System.out.println("Введите индекс второго элемента:");
			            userIndex = new CommandsForExercise.InputUserInt(System.in).getIntNumber();
			            Building obj2 = buildings.get(userIndex);
			            this.command = new CommandsForExercise.ObjEquals(obj1, obj2);
			            System.out.println(command.run());
			        }
			        case EXIT -> isWork = false; // опускаем флаг о возможности работы программы
			        default -> throw new IllegalStateException("Unexpected value: " + menuItem);
			    }
			} while (isWork);
		}


        }
        private void setIsChanged ( boolean choice) {
            isChanged = choice;
        }

        private void setIsProcessed(boolean choice) {
            isProcessed = choice;
        }

}
