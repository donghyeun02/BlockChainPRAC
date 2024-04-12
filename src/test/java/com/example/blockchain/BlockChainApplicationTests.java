package com.example.blockchain;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BlockChainTest {

    @DisplayName("블록체인 유효성 검사 테스트")
    @Test
    void testBlockChainValidity() {
        BlockChain blockChain = new BlockChain();

        blockChain.addBlock("Block 1", blockChain.getLatestBlock().getHash());
        blockChain.addBlock("Block 2", blockChain.getLatestBlock().getHash());

        assertTrue(blockChain.isChainValid(), "블록체인이 올바르게 유효해야 합니다.");

        blockChain.getBlockChain().get(1).setData("Tampered Data");
        assertFalse(blockChain.isChainValid(), "데이터가 수정된 블록체인은 유효하지 않아야 합니다.");
    }

    @DisplayName("블록 마이닝 테스트")
    @Test
    void testMining() {
        BlockChain blockChain = new BlockChain();

        blockChain.addBlock("Genesis Block", "0");

        blockChain.addBlock("Block 1", blockChain.getLatestBlock().getHash());
        blockChain.addBlock("Block 2", blockChain.getLatestBlock().getHash());

        assertNotEquals(0, blockChain.getBlockChain().get(1).getNonce(), "블록 1의 난수는 0이 아니어야 합니다.");
        assertNotEquals(0, blockChain.getBlockChain().get(2).getNonce(), "블록 2의 난수는 0이 아니어야 합니다.");
    }
}
