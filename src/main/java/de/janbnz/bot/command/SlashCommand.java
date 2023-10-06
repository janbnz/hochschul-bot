package de.janbnz.bot.command;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

public abstract class SlashCommand {

    public abstract void performCommand(SlashCommandInteractionEvent event, Member member, TextChannel channel);

    public OptionData[] getOptions() {
        return new OptionData[0];
    }
}