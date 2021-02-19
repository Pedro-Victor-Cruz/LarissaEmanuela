package Bots.commands;

import Bots.Command;
import Bots.Contains;
import Bots.Manager;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.awt.*;
import java.util.List;

public class Ajuda implements Command {
    public final Manager manager;

    public Ajuda(Manager m){
        this.manager = m;
    }
    @Override
    public void run(List<String> args, GuildMessageReceivedEvent event) {
        if(args.isEmpty()){
            EmbedBuilder e = new EmbedBuilder();
            e.setTitle(":page_with_curl: Lista de Comandos :page_with_curl:");
            e.setFooter(event.getJDA().getSelfUser().getName());
            e.setColor(Color.green);
            StringBuilder desc = e.getDescriptionBuilder();
            manager.getCommands().forEach(command -> {
                desc.append("➥ " + Contains.prefix).append(command.getCommand()).append("\n");
            });
            event.getChannel().sendMessage(e.build()).queue();
            return;
        }
        Command command = manager.getCommand(String.join("", args));
        if(command == null){
            EmbedBuilder err = new EmbedBuilder();
            err.setTitle(":x: Esse comando não existe! :x:");
            err.setDescription("Utilize `" + Contains.prefix + "ajuda` para listar todos os comandos que existem!");
            err.setColor(Color.RED);
            err.setFooter(event.getJDA().getSelfUser().getName());
            event.getChannel().sendMessage(err.build()).queue();
            return;
        }
        EmbedBuilder help = new EmbedBuilder();
        help.setTitle("Comando: " + command.getCommand());
        help.setDescription(command.getHelp());
        help.setColor(Color.CYAN);
        help.setFooter(event.getJDA().getSelfUser().getName());
        event.getChannel().sendMessage(help.build()).queue();
    }

    @Override
    public String getCommand() {
        return "ajuda";
    }

    @Override
    public String getHelp() {
        return "Mostra como utiliza um comando.. \nUso: " + Contains.prefix + getCommand() + " `[comando]`";
    }
}
