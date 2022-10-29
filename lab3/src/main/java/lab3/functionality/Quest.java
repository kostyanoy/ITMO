package lab3.functionality;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Quest {
    private final Scanner scanner = new Scanner(System.in);
    protected final Location startLocation;
    public Location curLocation;
    protected boolean isGoing = true;
    protected Player player;

    public Quest(Location startLocation) {
        this.startLocation = startLocation;
    }

    public void start() {
        System.out.print("Введите имя главного героя: ");
        player = new Player(scanner.nextLine());
        enterLocation(startLocation);
        while (isGoing) {
            showVariants();
            checkPlayer();
        }
    }

    public void end(String reason) {
        System.out.println(reason);
        isGoing = false;
    }

    private void checkPlayer() {
        if (player.getHealth() == Health.Dead) {
            end(String.format("%s умер!", player.getName()));
        }
    }

    private void showVariants() {
        System.out.printf("Выберите, с чем взаимодействовать:\n1)Посмотреть состояние %s\n2)Локации\n3)Предметы\n", player.getName());
        var num = readInt();
        switch (num) {
            case 1 -> chooseAction(player);
            case 2 -> chooseLocation();
            case 3 -> chooseItem();
            default -> System.out.println("Неверное число");
        }
    }

    private void chooseLocation() {
        System.out.printf("Выберите локацию:\n0)Вернуться\n1)Осмотреть %s (текущая)%n", curLocation.getName());
        var locations = curLocation.getLocations();
        showNames(locations, 2);
        var ind = readInt();
        switch (ind) {
            case 0:
                break;
            case 1:
                chooseAction(curLocation);
                break;
            default:
                try {
                    enterLocation(locations[ind - 2]);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Неправильное число");
                }
        }
    }

    private void chooseItem() {
        System.out.println("Выберите предмет:\n0)Вернуться");
        var items = curLocation.getItems();
        showNames(items, 1);
        var ind = readInt();
        if (ind != 0) {
            try {
                var item = items[ind - 1];
                chooseAction(item);
                if (item.isConsumable() && item.getActions().length == 0) {
                    curLocation.removeItem(ind - 1);
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Неверное число!");
            }
        }
    }

    private void chooseAction(Actionable act) {
        showDescription(act);
        System.out.println("Выберите действие:\n0)Вернуться");
        var actions = act.getActions();
        showNames(actions, 1);
        var ind = readInt();
        if (ind != 0) {
            try {
                var action = actions[ind - 1];
                showDescription(action);
                actions[ind - 1].use(this, player);
                if (actions[ind - 1].isDisposable()) {
                    try {
                        act.removeAction(ind - 1);
                    } catch (IndexOutOfBoundsException e) {
                    }
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Неверное число!");
            }
        }
    }

    private void showDescription(Nameable describable) {
        var description = describable.getDescription(player);
        if (description.length() > 0) {
            System.out.println(description);
        }
        System.out.println();
    }

    private void showNames(Nameable[] array, int shift) {
        for (var i = 0; i < array.length; i++) {
            System.out.printf("%d)%s%n", i + shift, array[i].getName());
        }
    }

    private int readInt() {
        while (true) {
            try {
                System.out.print("Введите число: ");
                var result = scanner.nextInt();
                System.out.println();
                return result;
            } catch (InputMismatchException e) {
                System.out.println("Необходимо ввести число!");
            } finally {
                scanner.nextLine();
            }
        }
    }

    public void enterLocation(Location loc) {
        curLocation = loc;
        System.out.println(loc.enter(player));
    }

}
