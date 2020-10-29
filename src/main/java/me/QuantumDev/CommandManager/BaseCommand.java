package me.QuantumDev.CommandManager;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.bukkit.command.CommandSender;

public abstract class BaseCommand {

    private String permission;
    private final boolean needsPermission;
    private final boolean allowConsole;
    private final boolean mustHaveOP;

    public BaseCommand(String permission, boolean allowConsole, boolean mustHaveOP) {
        this.permission = permission;
        this.allowConsole = allowConsole;
        this.mustHaveOP = mustHaveOP;
        this.needsPermission = true;
    }

    public BaseCommand(boolean allowConsole, boolean mustHaveOP) {
        this.allowConsole = allowConsole;
        this.mustHaveOP = mustHaveOP;
        this.needsPermission = false;
    }

    public abstract void execute(CommandSender sender, String[] args);

    @Getter
    public boolean needsPermission() {
        return needsPermission;
    }

    @Getter
    public String getPermission() {
        return permission;
    }

    @Getter
    public boolean allowsConsole() { return allowConsole; }

    @Getter
    public boolean mustHaveOP() { return mustHaveOP; }

}
