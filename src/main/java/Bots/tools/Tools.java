package Bots.tools;

import Bots.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Tools {
    public static void wrongUsage(TextChannel tc, Command c){
        EmbedBuilder err = new EmbedBuilder();
        err.setTitle(":x: Comando utilizado de forma incorreta!");
        err.setDescription(c.getHelp());
        err.setColor(Color.RED);
        err.setFooter(tc.getJDA().getSelfUser().getName());
        tc.sendMessage(err.build()).queue(msg -> {
            msg.delete().queueAfter(5, TimeUnit.SECONDS);
        });

    }

    public static void notPermission(TextChannel tc, Command c, String permission){
        EmbedBuilder err = new EmbedBuilder();
        err.setTitle(":x: Sem permissão!");
        err.setDescription("Você não tem permissão para executar esse comando! \n Permissão: `" + permission + "`");
        err.setColor(Color.RED);
        err.setFooter(tc.getJDA().getSelfUser().getName());
        tc.sendMessage(err.build()).queue(msg -> {
            msg.delete().queueAfter(5, TimeUnit.SECONDS);
        });
    }

}
