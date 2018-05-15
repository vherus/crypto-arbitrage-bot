package util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import registry.DependencyRegistry;

import static org.junit.jupiter.api.Assertions.*;

class EngineTest {
    private Engine engine;

    @BeforeEach
    void setUp() {
        engine = DependencyRegistry.boot().getInstance(Engine.class);
    }

    @Test
    void injection() {
        assertNotNull(engine);
    }
}