package org.tfog.atm;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

class AtmTests {
    @Test
    void test() {
      assertDoesNotThrow(() -> {
        new Atm();
      });
    }
}
