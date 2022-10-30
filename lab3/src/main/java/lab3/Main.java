package lab3;

import lab3.functionality.Player;
import lab3.functionality.Reader;
import lab3.functionality.Writer;
import lab3.interaction.ConsoleReader;
import lab3.interaction.ConsoleWriter;
import lab3.myquest.locations.Space;
import lab3.myquest.MyQuest;

public class Main {
    static final Writer writer = new ConsoleWriter();
    static final Reader reader = new ConsoleReader();

    public static void main(String[] args) {
        writer.write("Введите имя главного героя: ");
        var player = new Player(reader.readLine(), new Space("Пространство"));
        var quest = new MyQuest(player);
        quest.start();
    }
}