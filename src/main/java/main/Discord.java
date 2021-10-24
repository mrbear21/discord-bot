package main;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Discord extends ListenerAdapter {

	public static JDA jda;
	
	public void login() {
		
		String token = "NzcxMzk3Njc3MTU4MTA1MDg4.X5riEg.VE3-TdHb5nYN91N6e4KiPdUsSA8";
		
		try {
			jda = new JDABuilder(AccountType.BOT).setToken(token).addEventListener(this).buildAsync();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws LoginException {
		Discord d = new Discord();
		d.login();
	}
	
	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		Message message = event.getMessage();
		if (!event.getAuthor().isBot()) {
			if (message.getContent().equalsIgnoreCase("ping")) {
				event.getTextChannel().sendMessage("fuck you").queue();
			}
			return;
		}
	}
	
}
