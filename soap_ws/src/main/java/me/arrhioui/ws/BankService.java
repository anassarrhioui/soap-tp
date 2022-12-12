package me.arrhioui.ws;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.Date;


@WebService(serviceName = "se")
public class BankService {

    @WebMethod(operationName = "conversion")
    public double conversion(@WebParam(name = "montant") double mt){
        return mt*100;
    }

    @WebMethod(operationName = "getCompte")
    public Compte getCompte(@WebParam(name = "code") int code){
        return new Compte(code, Math.random()*2000, new Date());
    }
}
