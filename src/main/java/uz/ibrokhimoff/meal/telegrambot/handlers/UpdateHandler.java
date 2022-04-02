package uz.ibrokhimoff.meal.telegrambot.handlers;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
@RequiredArgsConstructor
public class UpdateHandler {

    private final CallbackHandler callbackHandler;
    private final MessageHandler messageHandler;

    public void handle(Update update) {
        if (update.hasCallbackQuery()) {
            callbackHandler.handle(update);
        } else if (update.hasMessage()) {
            messageHandler.handle(update);
        }
    }
}
