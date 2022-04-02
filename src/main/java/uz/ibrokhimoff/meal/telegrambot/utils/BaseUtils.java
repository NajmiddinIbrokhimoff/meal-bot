package uz.ibrokhimoff.meal.telegrambot.utils;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uz.ibrokhimoff.meal.repository.AuthUserRepository;

import java.util.stream.Stream;

import static uz.ibrokhimoff.meal.telegrambot.utils.State.*;

@Component
@RequiredArgsConstructor
public class BaseUtils {

    private final AuthUserRepository authUserRepository;

    public boolean isAnonymous(String chatId) {
        return Stream.of(ASK_FOR_DEPARTMENT,
                        PHONE_NUMBER,
                        FULL_NAME,
                        DELETE,
                        WAITING_CONFIRMATION,
                        UNDEFINED)
                .anyMatch(state -> state.equals(UserStates.getState(chatId)));
    }
}
