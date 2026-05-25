

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.quickchat;
/**
 *
 * @author Student
 */
 class Message {
    
   private String messageID;
    private int numMessagesSent;
    private String recipient;
    private String messageText;
    private String messageHash;

    public Message(String messageID,
                   int numMessagesSent,
                   String recipient,
                   String messageText) {

        this.messageID = messageID;
        this.numMessagesSent = numMessagesSent;
        this.recipient = recipient;
        this.messageText = messageText;
    }

    public String getMessageID() {
        return messageID;
    }

    public int getNumMessagesSent() {
        return numMessagesSent;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getMessageText() {
        return messageText;
    }

    public String getMessageHash() {
        return messageHash;
    }

    public void setMessageHash(String messageHash) {
        this.messageHash = messageHash;
    }
}
    

