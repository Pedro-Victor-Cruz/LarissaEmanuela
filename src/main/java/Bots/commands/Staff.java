package Bots.commands;

import Bots.Command;
import Bots.Contains;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.awt.*;
import java.util.List;

public class Staff implements Command {
    @Override
    public void run(List<String> args, GuildMessageReceivedEvent event) {
        if(args.isEmpty()){
            List<Member> diretoria = event.getGuild().getMembersWithRoles(event.getGuild().getRoleById("792782195575619595"));
            List<Member> gerentes = event.getGuild().getMembersWithRoles(event.getGuild().getRoleById("792782955733975060"));
            List<Member> admins = event.getGuild().getMembersWithRoles(event.getGuild().getRoleById("792783053331628032"));
            List<Member> modchefe = event.getGuild().getMembersWithRoles(event.getGuild().getRoleById("803352442582466620"));
            List<Member> mod = event.getGuild().getMembersWithRoles(event.getGuild().getRoleById("792783092091846686"));
            List<Member> ajudantes = event.getGuild().getMembersWithRoles(event.getGuild().getRoleById("792783611535425616"));
            List<Member> ajudantesdiscord = event.getGuild().getMembersWithRoles(event.getGuild().getRoleById("792783768074977331"));
            EmbedBuilder staff = new EmbedBuilder();
            staff.setColor(Color.CYAN);
            staff.setTitle(":page_with_curl: **Staff do servidor Bitten**");
            staff.setFooter(event.getJDA().getSelfUser().getName());
            StringBuilder desc = staff.getDescriptionBuilder();

            desc.append("\n").append("**" + event.getGuild().getRoleById("792782195575619595").getName() + "**:\n");
            diretoria.forEach(cargos -> {
                desc.append("➥ ").append(cargos.getAsMention()).append("\n");
            });
            desc.append("\n").append("**" + event.getGuild().getRoleById("792782955733975060").getName() + "**:\n");
            gerentes.forEach(cargos -> {
                desc.append("➥ ").append(cargos.getAsMention()).append("\n");
            });
            desc.append("\n").append("**" + event.getGuild().getRoleById("792783053331628032").getName() + "**:\n");
            admins.forEach(cargos -> {
                    desc.append("➥ ").append(cargos.getAsMention()).append("\n");
            });
            desc.append("\n").append("**" + event.getGuild().getRoleById("803352442582466620").getName() + "**:\n");
            modchefe.forEach(cargos -> {
                desc.append("➥ ").append(cargos.getAsMention()).append("\n");
            });
            desc.append("\n").append("**" + event.getGuild().getRoleById("792783092091846686").getName() + "**:\n");
            mod.forEach(cargos -> {
                desc.append("➥ ").append(cargos.getAsMention()).append("\n");
            });
            desc.append("\n").append("**" + event.getGuild().getRoleById("792783611535425616").getName() + "**:\n");
            ajudantes.forEach(cargos -> {
                desc.append("➥ ").append(cargos.getAsMention()).append("\n");
            });
            desc.append("\n").append("**" + event.getGuild().getRoleById("792783768074977331").getName() + "**:\n");
            ajudantesdiscord.forEach(cargos -> {
                desc.append("➥ ").append(cargos.getAsMention()).append("\n");
            });
            event.getChannel().sendMessage(staff.build()).queue();

        }
    }

    @Override
    public String getCommand() {
        return "staff";
    }

    @Override
    public String getHelp() {
        return "Varifica todos os membros da staff. \n Uso: " + Contains.prefix + getCommand();
    }
}
