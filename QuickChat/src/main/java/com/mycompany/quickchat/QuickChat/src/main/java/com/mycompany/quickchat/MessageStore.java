/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quickchat;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Student
 */
public class MessageStore {

     public void storeMessage(Message message) {

        Gson gson = new Gson();

        try {

            FileWriter writer =
                    new FileWriter("messages.json", true);

            writer.write(gson.toJson(message));
            writer.write("\n");

            writer.close();

        } catch (IOException e) {

            System.out.println("Error saving message.");
        }
    }
    
    

