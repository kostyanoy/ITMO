package lab3;

import lab3.functionality.Player;
import lab3.functionality.Reader;
import lab3.functionality.Writer;
import lab3.interaction.CommandLineReader;
import lab3.interaction.CommandLineWriter;
import lab3.myquest.locations.Space;
import lab3.myquest.myQuest;

public class Main {
    static Writer writer = new CommandLineWriter();
    static Reader reader = new CommandLineReader();

    public static void main(String[] args) {
        writer.write("Введите имя главного героя: ");
        var player = new Player(reader.readLine(), new Space("Пространство"));
        var quest = new myQuest(player);
        quest.start();
    }
}