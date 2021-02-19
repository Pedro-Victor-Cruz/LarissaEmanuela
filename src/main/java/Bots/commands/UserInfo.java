package Bots.commands;

import Bots.Command;
import Bots.Contains;
import Bots.tools.Tools;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class UserInfo implements Command {
    @Override
    public void run(List<String> args, GuildMessageReceivedEvent event) {
        if(args.size() == 1){
                String id = args.get(0).replaceAll("<@", "").replaceAll("!", "").replaceAll(">", "");
                Member member = event.getGuild().getMemberById(id);
                List<Role> roles = member.getRoles();
                EmbedBuilder userinfo = new EmbedBuilder();
                userinfo.setTitle("Informações do usuário " + member.getUser().getName() + "!");
                userinfo.setDescription("**Menção**: " + member.getAsMention()
                        + "\n**Tag**: " + member.getUser().getAsTag()
                        + "\n**ID**: " + member.getId()
                        + "\n**Avatar Link**: [link](" + member.getUser().getEffectiveAvatarUrl()
                        + ")\n **Cargo Prioritário**: " + roles.get(0).getAsMention());
                userinfo.addField("Entrou no servidor dia:", member.getTimeJoined().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), true);
                userinfo.addField("Conta criada dia:", member.getTimeCreated().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), true);
                userinfo.setThumbnail(member.getUser().getEffectiveAvatarUrl());
                userinfo.setAuthor(member.getUser().getName(), member.getUser().getAvatarUrl(), member.getUser().getEffectiveAvatarUrl());
                userinfo.setFooter(event.getJDA().getSelfUser().getName());
                userinfo.setColor(Color.orange);
                event.getChannel().sendMessage(userinfo.build()).queue();
        } else {
            Tools.wrongUsage(event.getChannel(), this);
        }
    }

    @Override
    public String getCommand() {
        return "userinfo";
    }

    @Override
    public String getHelp() {
        return "Utilizado para ver informações de um usuário. \n Uso: " + Contains.prefix + getCommand() + " [@usuario]";
    }
}
