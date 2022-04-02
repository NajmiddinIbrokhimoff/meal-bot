package uz.ibrokhimoff.meal.telegrambot;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TelegramBot {
    private final TelegramBotConfiguration telegramBotConfiguration;

    public void run() {
//        TelegramBotsApi telegramBotsApi =
//                new TelegramBotsApi(telegramBotConfiguration);
    }
}
