package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Reader read = new Reader();
        Scanner scanner = new Scanner();
        read.openFileIn(args[Constants.PositionNameFileIn]);
        for (String str = read.readStr(); str != null; str = read.readStr()) {
            scanner.ScanString(str);
        }
        read.closeFileIn();
        Writer writer = new Writer();
        writer.openFileOut(args[Constants.PositionNameFileOut]);
        writer.writeList(scanner.getListWords(), scanner.getCountWorld());
        writer.closeFileIn();
    }
}
