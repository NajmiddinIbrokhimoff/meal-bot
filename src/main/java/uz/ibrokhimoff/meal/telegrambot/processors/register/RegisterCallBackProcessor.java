package uz.ibrokhimoff.meal.telegrambot.processors.register;


import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import uz.ibrokhimoff.meal.enums.Department;
import uz.ibrokhimoff.meal.enums.Position;
import uz.ibrokhimoff.meal.telegrambot.buttons.InlineBoard;
import uz.ibrokhimoff.meal.telegrambot.utils.MessageExecutorService;
import uz.ibrokhimoff.meal.telegrambot.utils.State;
import uz.ibrokhimoff.meal.telegrambot.utils.UserStates;

@Component
public record RegisterCallBackProcessor(
        MessageExecutorService executorService
) {

    public void doProcess(CallbackQuery callbackQuery) {
        Message message = callbackQuery.getMessage();
        String chatId = message.getChatId().toString();
        String data = callbackQuery.getData();

        if (data.startsWith("d")) {
            int departmentOrder = Integer.parseInt(data.substring(data.indexOf("d_") + 2));
            Department department = Department.getByOrder(departmentOrder);
            // TODO: 10/03/22 save department
            executorService.deleteMessage(chatId, message.getMessageId());
            executorService.sendMessage(chatId, "Choose your position please", InlineBoard.positions());
        }
        if (data.startsWith("p_")) {
            int order = Integer.parseInt(data.substring(data.indexOf("p_") + 2));
            Position position = Position.getByOrder(order);
            // TODO: 10/03/22 save position
            // TODO: 10/03/22 save new user to db
            executorService.deleteMessage(chatId, message.getMessageId());
            executorService.sendMessage(chatId, "We sent your data to your head department. please wait untill your ....");
            UserStates.setState(chatId, State.WAITING_CONFIRMATION);
        }
    }
}
