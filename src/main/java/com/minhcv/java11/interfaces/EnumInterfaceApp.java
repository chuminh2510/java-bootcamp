package com.minhcv.java11.interfaces;

public class EnumInterfaceApp {
    interface Week {
        default String greedy() {
            return "Hello fen!";
        }

        String day();
    }

    enum Day implements Week {
        MONDAY {
            @Override
            public String day() {
                return "Mondayyy!!";
            }
        },
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY;

        @Override
        public String day() {
            return values()[ordinal()].toString();
        }
    }

    public static void main(String[] args) {
        System.out.println("Day: " + Day.MONDAY.day());
        System.out.println("Day: " + Day.TUESDAY.day());
        System.out.println("Day: " + Day.WEDNESDAY.greedy());

        Day day = Day.valueOf("MONDAY"); // Throw exception if not found

        System.out.println("End EnumInterfaceApp.main");
    }
}
