package me.QuantumDev.Plugin;

import me.QuantumDev.CommandManager.BaseCommand;
import org.bukkit.command.CommandSender;

public class ExampleCommand extends BaseCommand {
    public ExampleCommand() {
        super(true, true);
    }

    public void execute(CommandSender commandSender, String[] strings) {
        commandSender.sendMessage("Example Command Executed");
    }
}
