package Bots.commands;

import Bots.Command;
import Bots.Contains;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.awt.*;
import java.util.List;
// final String newPrefix = String.join("", args);
// VeryBadDesign.PREFIXES.put(ctx.getGuild().getIdLong(), newPrefix);
public class Site implements Command {
    @Override
    public void run(List<String> args, GuildMessageReceivedEvent event) {
        EmbedBuilder site = new EmbedBuilder();
        site.setFooter("Site: www.bittenmc.com.br", event.getGuild().getIconUrl());
        site.setColor(Color.cyan);
        event.getChannel().sendMessage(site.build()).queue();
    }

    @Override
    public String getCommand() {
        return "site";
    }

    @Override
    public String getHelp() {
        return "Mostra o site do servidor. \nUso: " + Contains.prefix + getCommand();
    }
}
