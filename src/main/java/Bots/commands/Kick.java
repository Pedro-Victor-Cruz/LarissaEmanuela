package Bots.commands;

import Bots.Command;
import Bots.Contains;
import Bots.tools.Tools;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.awt.*;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Kick implements Command {
    @Override
    public void run(List<String> args, GuildMessageReceivedEvent event) throws IOException {
        if( event.getMember().hasPermission(Permission.KICK_MEMBERS) || event.getMember().getId() == Contains.IDDONO){
            if(args.size() > 1){
                String idmember = args.get(0).replaceAll("<@", "").replaceAll("!", "").replaceAll(">", "");
                Member member = event.getGuild().getMemberById(idmember);
                String motivo = String.join(" ", args.subList(1, args.size()));
                EmbedBuilder kick = new EmbedBuilder();
                EmbedBuilder log = new EmbedBuilder();
                TextChannel registro = event.getGuild().getTextChannelById("812014412926812160");
                TextChannel canal = event.getChannel();

                kick.setDescription("Punição efetuada com sucesso!");
                kick.setColor(Color.green);

                log.setTitle(":exclamation:  Registro de punição :exclamation:");
                log.setDescription("➥ **Punição**: KICK" +
                        "\n➥ **Membro**: " + member.getAsMention() +
                        "\n➥ **Responsável**: " + event.getMember().getAsMention() +
                        "\n➥ **Data**: " + event.getMessage().getTimeCreated().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                        "\n➥ **Motivo**: " + motivo);
                log.setColor(Color.RED);

                canal.sendMessage(kick.build()).queue(msg -> {
                    msg.delete().queueAfter(5, TimeUnit.SECONDS);
                });
                registro.sendMessage(log.build()).queue();
                member.kick(motivo).queue();
            } else {
                Tools.wrongUsage(event.getChannel(), this);
            }
        } else {
            Tools.notPermission(event.getChannel(), this, "KICK_MEMBERS");
        }
        event.getMessage().delete().queue();
    }

    @Override
    public String getCommand() {
        return "kick";
    }

    @Override
    public String getHelp() {
        return "Comando utilizado para dar kick! \n" +
                "Uso: " + Contains.prefix + getCommand() + " [@membro] [motivo]";
    }
}
