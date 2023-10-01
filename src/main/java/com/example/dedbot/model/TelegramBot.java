package com.example.dedbot.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class TelegramBot extends TelegramLongPollingBot {


    public TelegramBot(@Value("${bot.token}") String botToken) {
        super(botToken);
    }

    @Override
    public void onUpdateReceived(Update update) {
        sendMessage(update.getMessage().getChat().getId(), "Привет мир!");
    }

    @Override
    public String getBotUsername() {
        return "DedBot";
    }

    public void sendMessage(Long chatId, String messageText) {
        var sendMessage = new SendMessage(chatId.toString(), messageText);
        try {
            execute(sendMessage);
        } catch (Exception ex) {
            System.out.println("что-то пошло не так");
        }
    }
}
