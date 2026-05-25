/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quickchat;

/**
 *
 * @author Student
 */
public class MessageService {
    
   
     public boolean checkMessageID(String messageID) {

        return messageID.length() == 10;
    }

    public String checkRecipientCell(String recipient) {

        if (recipient.startsWith("+")
                && recipient.length() <= 13) {

            return "Cell phone number successfully captured.";
        }

        return "Cell phone number is incorrectly formatted.";
    }

    public String validateMessage(String message) {

        if (message.length() <= 250) {
            return "Message ready to send.";
        }

        int excess = message.length() - 250;

        return "Message exceeds 250 characters by "
                + excess;
    }
    
    public String createMessageHash(Message message) {

    String[] words =
            message.getMessageText().split(" ");

    String firstWord =
            words[0].toUpperCase();

    String lastWord =
            words[words.length - 1].toUpperCase();

    return message.getMessageID().substring(0, 2)
            + ":"
            + message.getNumMessagesSent()
            + ":"
            + firstWord
            + lastWord;
}
}
