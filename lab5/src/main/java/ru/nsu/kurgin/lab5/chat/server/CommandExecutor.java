package ru.nsu.kurgin.lab5.chat.server;

import com.google.gson.Gson;
import ru.nsu.kurgin.lab5.chat.server.Exeption.FabricExceptions;
import ru.nsu.kurgin.lab5.chat.server.Command.*;

public class CommandExecutor {
    FabricCommand fabricCommand = new FabricCommand();


    public CommandExecutor() {
        try {
            fabricCommand.configurateFabric();
        } catch (FabricExceptions e) {
            e.printStackTrace();
        }
    }


    public void jsonAdapter(String json) {
        Gson gson = new Gson();
        fabricCommand.getCommand(gson.fromJson(json, CommandReader.class).getTypeCommand()).runCommand(this, json);
    }
}
