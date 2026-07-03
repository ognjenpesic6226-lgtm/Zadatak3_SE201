package Nivo1;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.*;
import java.net.InetSocketAddress;

//1.Zadatak: Kreirajte mikroservis Payment Service koji omogućava korisnicima da izvrše plaćanje.
// Servis treba da podrži samo jednu funkcionalnost: Pokretanje plaćanja (POST zahtev) – korisnici šalju iznos plaćanja.
// Uputstvo: • Koristite osnovni HTTP server u Javi. • Pri plaćanju, servis treba da vrati poruku
// "Plaćanje je uspešno" nakon što korisnik pošalje iznos
// 2.Zadatak: Kreirajte Java program koji traži od korisnika
// da unese broj telefona i proverava da li broj ima tačno 10 cifara. Uputstvo: • Koristite Scanner za unos broja telefona. •
// Proverite da li uneseni broj ima tačno 10 cifara i sadrži samo brojeve. • Ako broj nije validan, prikažite poruku o grešci.
// 3.Zadatak:  Kreirajte metodu koja sabira dva broja. Napišite jedinicni test koji proverava da li metoda pravilno sabira dva broja.
// 4.Zadatak: Kreirajte novi repozitorijum na GitHub-u. Dodajte osnovnu README.md datoteku i napravite prvi commit.
// Dokumentujte korake i dostavite link ka repozitorijumu (public).

//zadatak 1
public class PaymentService {

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(5000), 0);
        server.createContext("/pay", new PaymentHandler());
        server.setExecutor(null);
        server.start();
        System.out.println("Payment Service je pokrenut na portu 5000...");
    }

    static class PaymentHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if (!"POST".equalsIgnoreCase(exchange.getRequestMethod())) {
                String error = "Dozvoljen je samo POST";
                exchange.sendResponseHeaders(405, error.length());
                OutputStream os = exchange.getResponseBody();
                os.write(error.getBytes());
                os.close();
                return;
            }

            InputStreamReader isr = new InputStreamReader(exchange.getRequestBody(), "utf-8");
            BufferedReader br = new BufferedReader(isr);
            String body = br.readLine();

            try {
                if(body == null) return;
                double amount = Double.parseDouble(body.trim());

                String response = "Plaćanje je uspešno";
                exchange.sendResponseHeaders(200, response.getBytes().length);
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();

            } catch (NumberFormatException e) {
                String response = "Nevalidan unos.";
                exchange.sendResponseHeaders(400, response.getBytes().length);
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        }
    }
}

//zadatak 2