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

    public boolean isChainValid() {
        for (int i = 1; i < blockChain.size(); i++) {
            Block currentBlock = blockChain.get(i);
            Block previousBlock = blockChain.get(i - 1);

            if (!currentBlock.getHash().equals(currentBlock.calculateHash())) {
                return false;
            }

            if (!currentBlock.getPreviousHash().equals(previousBlock.getHash())) {
                return false;
            }
        }
        return true;
    }
}
