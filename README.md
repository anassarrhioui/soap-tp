# Web service SOAP

## dependency de jaxws dans pom.xml

```xml
<dependencies>
    <dependency>
        <groupId>com.sun.xml.ws</groupId>
        <artifactId>jaxws-ri</artifactId>e
        <version>4.0.0</version>
        <type>pom</type>
    </dependency>

</dependencies>
```

## Class Compte

```java

public class Compte{
    private int code;
    private double solde;
    private Date dateCreation;

    public Compte() {
    }

    public Compte(int code, double solde, Date dateCreation) {
        this.code = code;
        this.solde = solde;
        this.dateCreation = dateCreation;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
}

```

## Web Service Ebank
```java
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

```

## Serveur

```java
package me.arrhioui;

import jakarta.xml.ws.Endpoint;
import me.arrhioui.ws.BankService;

public class ServerJWS {

    public static void main(String[] args) {
        Endpoint.publish("http://0.0.0.0:8082/", new BankService());
        System.out.println("Deployment Done");
    }
}

```

# Client SOAP

## Classe Main

```java
package me.arrhioui;



public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        BankService bankService = new Se().getBankServicePort();
        System.out.println(bankService.conversion(200));
        System.out.println(bankService.getCompte(43));

    }
}

```