package commands;

import commands.events.CommandFiles;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

import java.util.List;
import java.util.Objects;

public class GeneralCommands {

    public static void sendMsg(MessageReceivedEvent event, String msg){
        event.getChannel().asTextChannel().sendMessage(msg).queue();
    }

    public static void sendMsg(SlashCommandInteractionEvent event, String msg){
        event.getChannel().asTextChannel().sendMessage(msg).queue();
    }

    public static void getAvatar(MessageReceivedEvent event){
        List<User> mentionedUsers = event.getMessage().getMentions().getUsers();
        if (mentionedUsers.size()>0){
            String avatar = mentionedUsers.get(0).getAvatarUrl();
            sendMsg(event, avatar);
        }else{
            sendMsg(event, "You should mention a user to see an avatar.");
        }
    }


    public static boolean checkMsg(SlashCommandInteractionEvent event, String msg){
        event.getName().equals(msg);
        return true;
    }

}
