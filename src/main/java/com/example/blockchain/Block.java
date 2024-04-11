package com.example.blockchain;

import java.util.Date;

public class Block {
    public String hash;
    public String previousHash;
    private String data;
    private long timeStamp;

    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
    }

    public String calculateHash() {
        return BlockChainUtils.generateHash(
                previousHash,
                Long.toString(timeStamp),
                data
        );
    }

    public String getHash() {
        return hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public String getData() {
        return data;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    @Override
    public String toString() {
        return String.format("Block Hash : %s%n Previous Hash : %s%n Data : %s%n Timestamp : %d%n",
                hash, previousHash, data, timeStamp);
    }
}
