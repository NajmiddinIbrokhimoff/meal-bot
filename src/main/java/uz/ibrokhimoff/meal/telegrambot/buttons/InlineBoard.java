package uz.ibrokhimoff.meal.telegrambot.buttons;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import uz.ibrokhimoff.meal.enums.Department;
import uz.ibrokhimoff.meal.enums.Position;
import uz.ibrokhimoff.meal.telegrambot.emojis.Emojis;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InlineBoard {

    private static final InlineKeyboardMarkup board = new InlineKeyboardMarkup();


    public static InlineKeyboardMarkup languageButtons() {
        InlineKeyboardButton uz = new InlineKeyboardButton(Emojis.UZ + " O'zbek");
        uz.setCallbackData("uz");

        InlineKeyboardButton ru = new InlineKeyboardButton(Emojis.RU + " Русский");
        ru.setCallbackData("ru");

        InlineKeyboardButton en = new InlineKeyboardButton(Emojis.EN + " English");
        en.setCallbackData("en");
        board.setKeyboard(Arrays.asList(getRow(uz), getRow(ru), getRow(en)));
        return board;
    }

    public static InlineKeyboardMarkup accept(String chatId) {
        InlineKeyboardButton accept = new InlineKeyboardButton(Emojis.ADD + " Confirm");
        accept.setCallbackData("accept_" + chatId);
        InlineKeyboardButton no = new InlineKeyboardButton(Emojis.REMOVE + " Ignore");
        no.setCallbackData("accept_no");
        board.setKeyboard(Arrays.asList(getRow(accept), getRow(no)));
        return board;
    }

    private static List<InlineKeyboardButton> getRow(InlineKeyboardButton... buttons) {
        return Arrays.stream(buttons).toList();
    }


    public static InlineKeyboardMarkup departments() {
        InlineKeyboardMarkup board = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        for (Department department : Department.values()) {
            InlineKeyboardButton button = new InlineKeyboardButton(department.name());
            button.setCallbackData("d_" + department.ordinal());
            rowList.add(getRow(button));
        }
        board.setKeyboard(rowList);
        return board;
    }

    public static ReplyKeyboard positions() {
        InlineKeyboardMarkup board = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        for (Position position : Position.values()) {
            InlineKeyboardButton button = new InlineKeyboardButton(position.name());
            button.setCallbackData("p_" + position.ordinal());
            rowList.add(getRow(button));
        }
        board.setKeyboard(rowList);
        return board;
    }
}
