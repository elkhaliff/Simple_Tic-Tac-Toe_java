package tictactoe;

import java.util.Scanner;

public class Main {
    public static void println(String string) {
        System.out.println(string);
    }
    public static void print(String string) {
        System.out.print(string);
    }

    public static String getString(String input) {
        Scanner scanner = new Scanner(System.in);
        print(input);
        return scanner.nextLine();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameX0 gameX0 = new GameX0(3);
        gameX0.setField(getString("Enter cells: "));
        print(gameX0.toString());

        int err = -1;
        String step = "X";
        String checkGameStr = "";

        while (checkGameStr == "") { // Цикл получения координат - ожидание хода, проверка результатов
            print("Enter the coordinates (" + step + "): ");
            try {
                err = gameX0.setCoordinates(step, scanner.nextInt(), scanner.nextInt()); // Запрашиваем ход игрока, устанавливаем ход на доску
                switch (err) {
                    case 0: {
                        step = (step == "O") ? "X" : "O";
                        gameX0.statXO(); // Сбор статистики по заполненным клеткам
                        checkGameStr = gameX0.checkGame();
                        println(gameX0.toString());
                    }
                    case 1: println("Coordinates should be from 1 to 3!");
                    case 2: println("This cell is occupied! Choose another one!");
                }
            } catch (Exception e) {
                println("You should enter numbers!");
            }
        }
        println(gameX0.checkGame());
    }
}
