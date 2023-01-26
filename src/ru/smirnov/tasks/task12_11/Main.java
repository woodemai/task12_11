package ru.smirnov.tasks.task12_11;

import ru.smirnov.tasks.task12_11.windows.Window;
import ru.smirnov.utils.Utils;

import javax.swing.*;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class Main {
    public static class CmdParams {
        public String inputFile;
        public String outputFile;
        public boolean error;
        public boolean help;
        public boolean window;
    }

    public static CmdParams parseArgs(String[] args) {
        CmdParams params = new CmdParams();
        if (args.length > 0) {
            if (args[0].equals("--help")) {
                params.help = true;
                return params;
            }
            if (args[0].equals("--window")) {
                params.window = true;
                return params;
            }
            params.inputFile = args[0];
            if (args.length > 1) {
                params.outputFile = args[1];
                return params;
            }
        } else {
            params.error = true;
            params.help = true;
        }
        return params;
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        CmdParams params = parseArgs(args);
        if (params.help) {
            PrintStream out = params.error ? System.err : System.out;
            out.print("Usage:\n");
            out.print("Help: <cmd> --help\n");
            out.print("Open GUI: <cmd> --window\n");
            out.print("Console: <cmd> <input-file> <money> (optional) <output-file>\n");
            System.exit(params.error ? 1 : 0);
        } else if (params.window) {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            new Window().setVisible(true);
        } else {
            int x = Integer.parseInt(Utils.readLineFromFile(params.inputFile));
            ArrayList<String> result = new Logic().resultOutput(x);
            PrintStream out = (params.outputFile != null) ? new PrintStream(params.outputFile) :
                    System.out;
            for (String s : result) {
                out.printf(s + "\n");
            }

            out.close();
        }
    }
}
