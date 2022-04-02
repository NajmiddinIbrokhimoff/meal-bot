package uz.ibrokhimoff.meal.telegrambot;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import uz.ibrokhimoff.meal.telegrambot.handlers.UpdateHandler;


@Component
public class TelegramBotConfiguration extends TelegramLongPollingBot {


    private final String token;
    private final String username;
    private final UpdateHandler updateHandler;

    public TelegramBotConfiguration(@Value("${telegram.bot.token}") String token, @Value("${telegram.bot.username}") String username, UpdateHandler updateHandler) {
        this.token = token;
        this.username = username;
        this.updateHandler = updateHandler;
    }

    @Override
    public String getBotToken() {
        return this.token;
    }

    @Override
    public void onUpdateReceived(Update update) {
        updateHandler.handle(update);
    }

    @Override
    public String getBotUsername() {
        return this.username;
    }
}
