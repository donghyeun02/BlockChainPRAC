package com.example.blockchain;

import java.util.ArrayList;

public class BlockChain {
    private ArrayList<Block> blockChain;
    private int difficulty;

    public BlockChain() {
        blockChain = new ArrayList<>();
        difficulty = 5;
        addBlock("Genesis Block", "0");
    }

    public void addBlock(String data, String previousHash) {
        Block block;
        if (blockChain.isEmpty()) {
            block = new Block(data, previousHash);
        } else {
            block = new Block(data, blockChain.get(blockChain.size() - 1).getHash());
            block.mineBlock(difficulty);
        }
        System.out.println("\n" + block.toString());
        blockChain.add(block);
    }

    public ArrayList<Block> getBlockChain() {
        return blockChain;
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
