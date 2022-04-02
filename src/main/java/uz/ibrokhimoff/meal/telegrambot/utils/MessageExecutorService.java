package uz.ibrokhimoff.meal.telegrambot.utils;


import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import uz.ibrokhimoff.meal.telegrambot.TelegramBotConfiguration;

@Component
@Slf4j
public record MessageExecutorService(@Lazy TelegramBotConfiguration configuration) {

    public void deleteMessage(String chatId, Integer messageId) {
        try {
            configuration.execute(new DeleteMessage(chatId, messageId));
        } catch (TelegramApiException e) {
            log.error(e.getMessage(), e);
        }
    }

    @SneakyThrows
    public void sendMessage(String chatId, String text) {
        sendMessage(chatId, text, null);
    }

    @SneakyThrows
    public void sendMessage(String chatId, String text, ReplyKeyboard replyKeyboard) {
        SendMessage message = new SendMessage(chatId, text);
        message.setReplyMarkup(replyKeyboard);
        configuration.execute(message);
    }
}
