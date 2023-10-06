package de.janbnz.bot.command;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;
import net.dv8tion.jda.internal.interactions.CommandDataImpl;

import java.util.HashMap;
import java.util.Map;

public class SlashCommandRegistry {

    private final Map<String, SlashCommand> commands;

    public SlashCommandRegistry(JDA jda) {
        this.commands = new HashMap<>();
        // TODO: register commands

        final CommandListUpdateAction updateAction = jda.updateCommands();
        this.commands.forEach((commandName, command) -> updateAction.addCommands(new CommandDataImpl(commandName, commandName).addOptions(command.getOptions())).queue());
    }

    private void registerCommand(String commandName, SlashCommand command) {
        this.commands.put(commandName, command);
    }

    public Map<String, SlashCommand> getCommands() {
        return commands;
    }
}