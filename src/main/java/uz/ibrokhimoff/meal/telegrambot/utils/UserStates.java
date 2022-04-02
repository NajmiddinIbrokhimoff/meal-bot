package uz.ibrokhimoff.meal.telegrambot.utils;

import uz.ibrokhimoff.meal.telegrambot.dto.UserCreateDto;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

public class UserStates {
    private final static ConcurrentHashMap<String, State> userStates = new ConcurrentHashMap<>();
    private final static ConcurrentHashMap<String, UserCreateDto> userCreateDto = new ConcurrentHashMap<>();

    static {
        // TODO: 10/03/22 load states from file
    }

    public static State getState(String chatId) {
        State state = userStates.get(chatId);
        if (state == null) {
            return State.UNDEFINED;
        }
        return state;
    }

    public static void setState(String chatId, State state) {
        CompletableFuture.runAsync(() -> {
            // TODO: 10/03/22 write to file
        });
        userStates.put(chatId, state);
    }

    public static void setUserCreateDto(String chatId, UserCreateDto dto) {
        userCreateDto.put(chatId, dto);
    }

    public static UserCreateDto getUserCreateDto(String chatId) {
        return userCreateDto.get(chatId);
    }


}
