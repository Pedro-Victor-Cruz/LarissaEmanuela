package Bots.commands;

import Bots.Command;
import Bots.Contains;
import Bots.tools.Tools;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.awt.*;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Sugestao implements Command {


    @Override
    public void run(List<String> args, GuildMessageReceivedEvent event) throws IOException {
        if(args.size() > 0){
            TextChannel canalsugestao = event.getGuild().getTextChannelById("792896282641039391");
            String msg = String.join(" ", args);
            EmbedBuilder embed = new EmbedBuilder();
            EmbedBuilder sucess = new EmbedBuilder();

            embed.setTitle(" Sugestão ");
            embed.setDescription("➥ **Sugerido por**: " + event.getMember().getAsMention() +
                    "\n➥ **Data**: " + event.getMessage().getTimeCreated().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                    "\n➥ **Sugestão**: " + msg);
            embed.setColor(Color.CYAN);
            embed.setFooter(event.getJDA().getSelfUser().getName());

            sucess.setTitle("Sugestão enviada com sucesso!");
            sucess.setDescription("Agredecemos o envio da sua sugestão!\n Caso tenha mais alguma sugestão não deixe de nós enviar.");
            sucess.setColor(Color.GREEN);
            sucess.setFooter(event.getJDA().getSelfUser().getName());

            canalsugestao.sendMessage(embed.build()).queue(add -> {
                add.addReaction("U+2705").queue();
                add.addReaction("U+274E\t").queue();
            });
            event.getChannel().sendMessage(sucess.build()).queue();

        } else {
            Tools.wrongUsage(event.getChannel(), this);
        }
    }

    @Override
    public String getCommand() {
        return "sugestao";
    }

    @Override
    public String getHelp() {
        return "Comando utilizado para enviar uma sugestão! \n" +
                "Uso: " + Contains.prefix + getCommand() + " [sugestão]";
    }
}
