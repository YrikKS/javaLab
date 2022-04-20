package ru.nsu.lab1.Kurgin;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner();
        try (Reader read = new Reader()) {
            read.openFileIn(args[Constants.PositionNameFileIn]);
            for (String str = read.readStr(); str != null; str = read.readStr()) {
                scanner.ScanString(str);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        try (Writer writer = new Writer()) {
            writer.openFileOut(args[Constants.PositionNameFileOut]);
            writer.writeList(scanner.getListWords(), scanner.getCountWorld());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
