package uz.ibrokhimoff.meal.domain;

import uz.ibrokhimoff.meal.enums.MessageType;

import javax.persistence.*;

@Entity
@Table(name = "message_history")
public class MessageHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "chat_id", nullable = false)
    private String chatId;

    @Column(name = "message_id", nullable = false)
    private String messageId;

    @Enumerated(EnumType.STRING)
    private MessageType messageType;

}