package me.arrhioui;

import jakarta.xml.ws.Endpoint;
import me.arrhioui.ws.BankService;

public class ServerJWS {

    public static void main(String[] args) {
        Endpoint.publish("http://0.0.0.0:8082/", new BankService());
        System.out.println("Deployment Done");
    }
}
