package commands.events;

import commands.GeneralCommands;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;

import static commands.GeneralCommands.*;

public class EventChat extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String prefix = "d!";
        if (!event.getAuthor().isBot()){
            String usr = event.getMessage().getAuthor().getName();
            String messageSent = event.getMessage().getContentDisplay();
            String randomAnswer = CommandFiles.getRandomGreetingAnswer();

            greetingsAnswer(event);
            if (messageSent.contains(prefix+"avatar")) getAvatar(event);
        }
    }

    public void greetingsAnswer(MessageReceivedEvent event){
        String greetingCommands[] = CommandFiles.getGreetingCommands();
        String usr = event.getMessage().getAuthor().getName();
        String messageSent = event.getMessage().getContentDisplay();
        String randomAnswer = CommandFiles.getRandomGreetingAnswer();
        for (String w : greetingCommands){
            if (messageSent.contains(w)){
                event.getChannel().asTextChannel().sendMessage(randomAnswer+usr+"!").queue();
            }
        }
    }

    public void getAvatar(MessageReceivedEvent event){
        List<User> mentionedUsers = event.getMessage().getMentions().getUsers();
        if (mentionedUsers.size()>0){
            String avatar = mentionedUsers.get(0).getAvatarUrl();
            sendMsg(event, avatar);
        }else{
            sendMsg(event, "You should mention a user to see an avatar.");
        }
    }
}
