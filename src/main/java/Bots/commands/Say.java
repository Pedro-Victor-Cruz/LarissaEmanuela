package Bots.commands;

import Bots.Command;
import Bots.Contains;
import Bots.tools.Tools;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.io.IOException;
import java.util.List;

public class Say implements Command {
    @Override
    public void run(List<String> args, GuildMessageReceivedEvent event) throws IOException {
        if(event.getAuthor().getId().equals(Contains.IDDONO)){
            if(args.size() > 1){
                String canal = args.get(0).replaceAll("<#", "").replaceAll(">", "");
                event.getGuild().getTextChannelById(canal).sendMessage(String.join(" ", args.subList(1, args.size()))).queue();
                event.getMessage().delete().queue();
            } else {
                Tools.wrongUsage(event.getChannel(), this);
            }
        } else {
            Tools.notPermission(event.getChannel(), this, "Developer");
        }
    }

    @Override
    public String getCommand() {
        return "say";
    }

    @Override
    public String getHelp() {
        return "Utilizado para o bot enviar uma mensagem!\n" +
                "Uso: " + Contains.prefix + getCommand() + " [#canal] [msg]";
    }
}
