package chain.api;

import com.sun.net.httpserver.HttpServer;
import chain.core.BlockchainCore;
import java.net.InetSocketAddress;

public class BlockchainRestServer {
    private final BlockchainCore blockchain;
    private HttpServer server;

    public BlockchainRestServer(BlockchainCore blockchain) {
        this.blockchain = blockchain;
    }

    public void start(int port) {
        try {
            server = HttpServer.create(new InetSocketAddress(port), 0);
            server.createContext("/chain", new ChainHandler(blockchain));
            server.createContext("/mine", new MineHandler(blockchain));
            server.setExecutor(null);
            server.start();
            System.out.println("REST API running on port " + port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        if (server != null) {
            server.stop(0);
        }
    }
}
