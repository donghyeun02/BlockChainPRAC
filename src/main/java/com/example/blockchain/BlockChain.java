package com.example.blockchain;

import java.util.ArrayList;

public class BlockChain {
    public ArrayList<Block> blockChain;

    public BlockChain() {
        blockChain = new ArrayList<>();
        addBlock("Genesis Block", "0");
    }

    public void addBlock(String data, String previousHash) {
        Block block = new Block(data, previousHash);
        blockChain.add(block);
    }

    public Block getLatestBlock() {
        return blockChain.get(blockChain.size() - 1);
    }
}
