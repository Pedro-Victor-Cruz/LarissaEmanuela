package Bots.commands;

import Bots.Command;
import Bots.Contains;
import Bots.tools.Tools;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Ausencia implements Command {
    @Override
    public void run(List<String> args, GuildMessageReceivedEvent event) throws IOException {
        if(event.getMember().hasPermission(Permission.MANAGE_ROLES) || event.getAuthor().getId().equals(Contains.IDDONO)){
            if(args.isEmpty()){
                HashMap<String, String> perguntas = new HashMap<>();
                event.getMessage().getPrivateChannel().sendMessage("Qual seu nome?");
                perguntas.put("Nome", event.getMessage().getPrivateChannel().toString());

            }
        } else {
            Tools.notPermission(event.getChannel(), this, "STAFF");
        }
    }

    @Override
    public String getCommand() {
        return "ausencia";
    }

    @Override
    public String getHelp() {
        return "Comando utilizado para a equipe postar ausencia! Uso: " + Contains.prefix + getCommand();
    }
}
