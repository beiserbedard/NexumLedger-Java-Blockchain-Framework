package chain.api;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import chain.core.BlockchainCore;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class MineHandler implements HttpHandler {
    private final BlockchainCore blockchain;

    public MineHandler(BlockchainCore blockchain) {
        this.blockchain = blockchain;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        blockchain.addBlock("API_MINED_" + System.currentTimeMillis());
        String response = "{\"status\":\"success\",\"message\":\"New block mined\"}";
        exchange.getResponseHeaders().set("Content-Type", "application/json");
        exchange.sendResponseHeaders(200, response.getBytes(StandardCharsets.UTF_8).length);
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(response.getBytes(StandardCharsets.UTF_8));
        }
    }
}
