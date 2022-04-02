package uz.ibrokhimoff.meal.telegrambot.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserCreateDto {
    private String fullName;
    private String chatId;
    private String department;
    private String position;
    private String phoneNumber;
}
