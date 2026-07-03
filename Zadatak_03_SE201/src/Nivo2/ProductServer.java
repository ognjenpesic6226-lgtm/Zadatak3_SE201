package Nivo2;


import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

public class ProductServer {
    static List<Product> products = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(5000), 0);
        server.createContext("/products", ProductServer::handleRequest);
        server.setExecutor(null);

        System.out.println("Server started on port 8080");
        server.start();
    }

    private static void handleRequest(HttpExchange exchange) throws IOException {
        String method = exchange.getRequestMethod();

        String response = "";

        switch (method) {
            case "GET":
                response = products.toString();
                break;
            case "POST":
                Product p = new Product(
                        products.size() + 1,
                        "Laptop",
                        1200,
                        "Gaming laptop"
                );
                products.add(p);
                response = "Product added.";
                break;
            case "PUT":
                if (!products.isEmpty()) {
                    Product product = products.get(0);

                    product.setName("Updated Laptop");
                    product.setPrice(1500);
                    product.setDescription("Updated description");

                    response = "Product updated.";
                } else {
                    response = "No product found.";
                }
                break;
            default:
                response = "Method not supported.";
        }

        exchange.sendResponseHeaders(200, response.length());

        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}