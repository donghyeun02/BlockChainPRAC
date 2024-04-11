package com.example.blockchain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlockChainApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlockChainApplication.class, args);

        BlockChain blockChain = new BlockChain();

        blockChain.addBlock("2nd Block", blockChain.getLatestBlock().getHash());
        blockChain.addBlock("3rd Block", blockChain.getLatestBlock().getHash());

        for (Block block : blockChain.blockChain) {
            System.out.println(block.toString());
        }

        System.out.println("Is blockchain valid? " + blockChain.isChainValid());
    }
}
