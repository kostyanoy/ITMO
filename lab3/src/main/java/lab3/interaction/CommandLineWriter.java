package lab3.interaction;

import lab3.functionality.Writer;

public class CommandLineWriter implements Writer {
    @Override
    public void write(String text) {
        System.out.print(text);
    }

    @Override
    public void writeln(String text) {
        System.out.println(text);
    }
}
