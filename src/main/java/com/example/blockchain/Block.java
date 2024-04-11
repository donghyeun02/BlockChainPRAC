package com.example.blockchain;

import java.util.Date;

public class Block {
    public String hash;
    public String previousHash;
    private String data;
    private long timeStamp;
    private int nonce;

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
                data,
                Integer.toString(nonce)
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

    public int getNonce() {
        return nonce;
    }

    public void setData(String data) {
        this.data = data;
        this.hash = calculateHash();
    }

    @Override
    public String toString() {
        return String.format("Block Hash : %s%nPrevious Hash : %s%nData : %s%nTimestamp : %d%nNonce: %d%n",
                hash, previousHash, data, timeStamp, nonce);
    }

    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0');
        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calculateHash();
        }
        System.out.println("Mined ! : " + hash);
    }
}
