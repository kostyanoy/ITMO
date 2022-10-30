package lab3.functionality;

import java.util.ArrayList;

public abstract class Quest {
    protected final Reader reader;
    protected final Writer writer;
    protected boolean isGoing = true;
    protected Player player;

    public Quest(Reader reader, Writer writer, Player player) {
        this.reader = reader;
        this.writer = writer;
        this.player = player;
    }

    public void start() {
        while (isGoing) {
            showVariants();
            checkPlayer();
        }
    }

    public void end(String reason) {
        writer.writeln(reason);
        isGoing = false;
    }

    private void checkPlayer() {
        if (player.getHealth() == Health.DEAD) {
            end(String.format("%s умер!", player.getName()));
        }
    }

    private void showVariants() {
        writer.writeln(String.format("Выберите, с чем взаимодействовать:\n1)Посмотреть состояние %s\n2)Локации\n3)Предметы", player.getName()));
        var num = reader.readInt();
        switch (num) {
            case 1 -> chooseAction(player);
            case 2 -> chooseLocation();
            case 3 -> chooseItem();
            default -> writer.writeln("Неверное число");
        }
    }

    private void chooseLocation() {
        writer.writeln(String.format("Выберите локацию:\n0)Вернуться\n1)Осмотреть %s (текущая)", player.getLocation().getName()));
        var locations = player.getLocation().getLocations();
        showNames(locations, 2);
        var ind = reader.readInt();
        switch (ind) {
            case 0:
                break;
            case 1:
                chooseAction(player.getLocation());
                break;
            default:
                try {
                    player.setLocation(locations.get(ind - 2));
                } catch (IndexOutOfBoundsException e) {
                    writer.writeln("Неправильное число");
                }
        }
    }

    private void chooseItem() {
        writer.writeln("Выберите предмет:\n0)Вернуться");
        var items = player.getLocation().getItems();
        showNames(items, 1);
        var ind = reader.readInt();
        if (ind != 0) {
            try {
                var item = items.get(ind - 1);
                chooseAction(item);
                if (item.isConsumable() && item.getActions().size() == 0) {
                    player.getLocation().removeItem(ind - 1);
                }
            } catch (IndexOutOfBoundsException e) {
                writer.writeln("Неверное число!");
            }
        }
    }

    private void chooseAction(Actionable act) {
        showDescription(act);
        writer.writeln("Выберите действие:\n0)Вернуться");
        var actions = act.getActions();
        showNames(actions, 1);
        var ind = reader.readInt();
        if (ind != 0) {
            try {
                var action = actions.get(ind - 1);
                showDescription(action);
                actions.get(ind - 1).use(this, player);
                if (actions.get(ind - 1).isDisposable()) {
                    try {
                        act.removeAction(ind - 1);
                    } catch (IndexOutOfBoundsException e) {
                    }
                }
            } catch (IndexOutOfBoundsException e) {
                writer.writeln("Неверное число!");
            }
        }
    }

    private void showDescription(Nameable describable) {
        var description = describable.getDescription(player);
        if (description.length() > 0) {
            writer.writeln(description);
        }
        writer.writeln("");
    }

    private void showNames(ArrayList<? extends Nameable> array, int shift) {
        for (var i = 0; i < array.size(); i++) {
            writer.writeln(String.format("%d)%s", i + shift, array.get(i).getName()));
        }
    }
}
