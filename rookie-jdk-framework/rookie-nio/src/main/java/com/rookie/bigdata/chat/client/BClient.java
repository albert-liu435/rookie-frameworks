package com.rookie.bigdata.chat.client;

import java.io.IOException;

public class BClient {

    public static void main(String[] args) {
        try {
            new ChatClient().startClient("mary");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
