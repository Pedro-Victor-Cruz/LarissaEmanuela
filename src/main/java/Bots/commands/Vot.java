package Bots.commands;

import Bots.Command;
import Bots.Contains;
import Bots.tools.Tools;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import javax.tools.Tool;
import java.util.Arrays;
import java.util.List;

public class Vot implements Command {
    @Override
    public void run(List<String> args, GuildMessageReceivedEvent event) {
        String msg = event.getMessage().getContentRaw();
        if( event.getMember().hasPermission(Permission.ADMINISTRATOR) || event.getMember().getId() == Contains.IDDONO) {
            if (!args.isEmpty()) {
                List<String> pollArgs = Arrays.asList(msg.split(" ", 2)[1].split("~"));
                if (pollArgs.size() > 20) {
                    event.getChannel().sendMessage("Excedeu a quantidade máxima de opções disponíveis no comando vot!").queue();
                    return;
                }
                String[] unicodeEmoji = {"\uD83C\uDDE6", "\uD83C\uDDE7", "\uD83C\uDDE8", "\uD83C\uDDE9", "\uD83C\uDDEA", "\uD83C\uDDEB", "\uD83C\uDDEC", "\uD83C\uDDED", "\uD83C\uDDEE", "\uD83C\uDDEF", "\uD83C\uDDF0", "\uD83C\uDDF1", "\uD83C\uDDF2", "\uD83C\uDDF3", "\uD83C\uDDF4", "\uD83C\uDDF5", "\uD83C\uDDF6", "\uD83C\uDDF7", "\uD83C\uDDF8", "\uD83C\uDDF9", "\uD83C\uDDFA", "\uD83C\uDDFB", "\uD83C\uDDFC", "\uD83C\uDDFD", "\uD83C\uDDFE", "\uD83C\uDDFF"};
                String[] emoji = {":regional_indicator_a:", ":regional_indicator_b:", ":regional_indicator_c:", ":regional_indicator_d:", ":regional_indicator_e:", ":regional_indicator_f:", ":regional_indicator_g:", ":regional_indicator_h:", ":regional_indicator_i:", ":regional_indicator_j:", ":regional_indicator_k:", ":regional_indicator_l:", ":regional_indicator_m:", ":regional_indicator_n:", ":regional_indicator_o:", ":regional_indicator_p:", ":regional_indicator_q:", ":regional_indicator_r:", ":regional_indicator_s:", ":regional_indicator_t:", ":regional_indicator_u:", ":regional_indicator_v:", ":regional_indicator_w:", ":regional_indicator_x:", ":regional_indicator_y:", ":regional_indicator_z:"};
                int counter = pollArgs.size();
                EmbedBuilder poll = new EmbedBuilder();
                poll.setTitle("Votação");
                poll.setDescription("Reaja a esta enquete com o emoji correspondente a cada opção. ");
                for (int i = 0; i < counter; i++) {
                    poll.appendDescription("\n" + emoji[i] + ": **" + pollArgs.get(i).trim() + "**\n");
                }
                event.getChannel().sendMessage(poll.build()).queue(reactPoll -> {
                    for (int i = 0; i < counter; i++) {
                        reactPoll.addReaction(unicodeEmoji[i]).queue();
                    }
                });
            } else {
                Tools.wrongUsage(event.getChannel(), this);
            }
        } else {
            Tools.notPermission(event.getChannel(), this, "ADMINISTRADOR");
        }
        event.getMessage().delete().queue();
    }

    @Override
    public String getCommand() {
        return "vot";
    }

    @Override
    public String getHelp() {
        return "Inicie uma votação. \\nUso: \"" + Contains.prefix + getCommand() + " Cada opção separada por **~**.";
    }
}
