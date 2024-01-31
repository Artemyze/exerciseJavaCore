package core.oldKnowledge.Menu;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import core.oldKnowledge.Buildings.Building;

public class CommandsForExercise {
    CommandsForExercise() {}

    public static class AddElementToArrList implements RunnableExercise {
        private final Building obj;
        private final ArrayList<Building> arrObjs;

        public AddElementToArrList(Building obj, ArrayList<Building> arrObjs) {
            this.obj = obj;
            this.arrObjs = arrObjs;
        }

        @Override
        public boolean run() {
            try {
                return this.arrObjs.add(this.obj);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return false;
        }
    }
    public static class ObjEquals implements RunnableExercise {
        private final Building obj1, obj2;

        public ObjEquals(Building obj1, Building obj2) {
            this.obj1 = obj1;
            this.obj2 = obj2;
        }

        @Override
        public boolean run() {
            return this.obj1.equals(this.obj2);
        }
    }

    public static class ArrPrint implements RunnableExercise {
        private final ArrayList<Building> arrayList;

        public ArrPrint(ArrayList<Building> arrayList) {
            this.arrayList = arrayList;
        }

        @Override
        public boolean run() {
            for (int i = 0; i < this.arrayList.size(); i++ ) {
                System.out.printf("%d. %s;", i, this.arrayList.get(i));
            }
            return true;
        }
    }

    public static class DelElement implements RunnableExercise {
        private final ArrayList<Building> arrayList;
        private final int index;

        public DelElement(ArrayList<Building> objects, int index) {
            this.arrayList = objects;
            this.index = index;
        }

        @Override
        public boolean run() {
            try {
                this.arrayList.remove(index);
            } catch (IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
                return false;
            }
            return true;
        }
    }

    public static class InputUserLine implements RunnableExercise {
        private final String text;

        public InputUserLine(InputStream stream) {
            try (Scanner in = new Scanner(stream)) {
				this.text = in.nextLine();
			}
        }

        public String getText() {
            return text;
        }
    }

    public static class InputUserInt implements RunnableExercise{
        private int intNumber;
        private InputStream stream;

        public InputUserInt(InputStream stream) {
            Scanner in = new Scanner(stream);
			try {
				this.intNumber = in.nextInt();
			} 
            catch (Exception e) {
            	System.out.println(e.getMessage());
				intNumber = new InputUserInt(stream).getIntNumber();
			}
        }
        public int getIntNumber() {
            return intNumber;
        }

    }

}
