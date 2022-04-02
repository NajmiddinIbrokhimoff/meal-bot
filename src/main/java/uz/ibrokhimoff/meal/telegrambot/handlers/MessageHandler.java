package uz.ibrokhimoff.meal.telegrambot.handlers;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import uz.ibrokhimoff.meal.telegrambot.processors.register.RegisterMessageProcessor;
import uz.ibrokhimoff.meal.telegrambot.utils.BaseUtils;

@Component
public record MessageHandler(RegisterMessageProcessor registerProcessor,
                             BaseUtils utils) {

    public void handle(Update update) {
        Message message = update.getMessage();
        String chatId = message.getChatId().toString();

        if (utils.isAnonymous(chatId)) {
            registerProcessor.doProcess(message);
        }

    }
}
