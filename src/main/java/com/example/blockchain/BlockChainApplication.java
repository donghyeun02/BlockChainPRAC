package com.example.blockchain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlockChainApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlockChainApplication.class, args);

        BlockChain blockChain = new BlockChain();

        for (int i = 2; i < 4; i++) {
            String data = String.format("Block %d", i);
            String previousHash = blockChain.getLatestBlock().getHash();

            blockChain.addBlock(data, previousHash);
        }

        System.out.println("Is blockchain valid? " + blockChain.isChainValid());
    }
}
