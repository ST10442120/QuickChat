/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quickchat;

import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author Student
 */
public class QuickChats {
     public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        MessageService service =
                new MessageService();

        MessageStore store =
                new MessageStore();

        System.out.println("Welcome to QuickChat");

        boolean running = true;

        int totalMessages = 0;

        while (running) {

            System.out.println("""
                    1) Send Messages
                    2) Show recently sent messages
                    3) Quit
                    """);

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:

                    System.out.print(
                            "How many messages do you want to send? ");

                    int numMessages =
                            input.nextInt();

                    input.nextLine();

                    for (int i = 0; i < numMessages; i++) {

                        Random random =
                                new Random();

                        String messageID =
                                String.valueOf(
                                1000000000L +
                                (long)(random.nextDouble()
                                * 8999999999L));

                        System.out.print(
                                "Enter recipient number: ");

                        String recipient =
                                input.nextLine();

                        System.out.print(
                                "Enter message: ");

                        String messageText =
                                input.nextLine();

                        Message message =
                                new Message(
                                        messageID,
                                        i,
                                        recipient,
                                        messageText
                                );

                        System.out.println(
                                service.checkRecipientCell(recipient));

                        System.out.println(
                                service.validateMessage(messageText));

                        String hash =
                                service.createMessageHash(message);

                        message.setMessageHash(hash);

                        System.out.println(
                                "Message Hash: " + hash);

                        store.storeMessage(message);

                        System.out.println(
                                "Message successfully stored in JSON.");

                        totalMessages++;
                    }

                    System.out.println(
                            "Total messages sent: "
                            + totalMessages);

                    break;

                case 2:

                    System.out.println("Coming Soon.");
                    break;

                case 3:

                    running = false;

                    System.out.println("Goodbye.");
                    break;

                default:

                    System.out.println("Invalid option.");
            }
        }
    }
}



