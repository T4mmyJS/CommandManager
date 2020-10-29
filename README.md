# CommandManager

## About
CommandManager is a simple command manager that can be used in all your plugins. It allows you to just create the command class, add the command to your plugin.yml, and the command will just execute! None of this setting the executer for every single command; it's as easy as that.

## Usage
Download the latest release, and add it as a library to your plugin. Next, in your `onCommand` method (normally your main class or one that implements `CommandExecutor`), add `CommandManager.executeCommand()`, and fill in the parametsr with the sender, command object, arguments array, and finally the directory path. This would be `me.QuantumDev.ExamplePlugin` for me. Then, to create a command, simply extend the command class (within the dirPath package) to `BaseCommand`, and make sure to implement the `execute()` method and the constructor. 

## Example:

```java
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
```

## Constructor Usage
Inside your constructor, construct a BaseCommand with `super()`. The first (optional) argument is the permission. Leave blank for everyone to use the command without a specific permission. The second argument is whether to allow console (boolean), and finally the last is whether to require OP status to execute the command (boolean).


#### Hopefully this makes everyone's lives easier, and thanks for reading!
