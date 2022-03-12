package com.company.Readers;

import com.company.Exeptions.FileInException;

import java.io.FileNotFoundException;

public class FabricReaders {
    public Reader getReader(String[] argc) throws FileNotFoundException, FileInException {
        if(argc.length == 0) {
            return new ReaderFromCmd();
        }
        else
            return new ReaderFromFile(argc[0]);
    }
}
