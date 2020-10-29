package me.QuantumDev.CommandManager;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;

public class CommandManager {

    public static void executeCommand(CommandSender sender, Command command, String[] args, String dirPath) {

        try {

            String commandName = command.getName().substring(0, 1).toUpperCase() + command.getName().substring(1) + "Command";
            BaseCommand commandClass = (BaseCommand) Class.forName(dirPath + "." + commandName).newInstance();

            if (commandClass.needsPermission() && !sender.hasPermission(commandClass.getPermission())) {
                sender.sendMessage("&cYou do not have permission to execute this command!");
                return;
            }

            if (!commandClass.mustHaveOP() && !sender.isOp()) {
                sender.sendMessage("&cYou do not have permission to execute this command!");
                return;
            }

            if (sender instanceof ConsoleCommandSender && !commandClass.allowsConsole()) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cThis command can only be executed by players!"));
                return;
            }

            commandClass.execute(sender, args);

        } catch (ClassNotFoundException e) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4Critical Error: &cCould not locate command class, please report this as this is a bug!"));
        } catch (InstantiationException e) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4Critical Error: &cCould not initiate command class, please report this as this is a bug!"));
        } catch (IllegalAccessException e) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4Critical Error: &cCould not access command class, please report this as this is a bug!"));
        }

    }

}
