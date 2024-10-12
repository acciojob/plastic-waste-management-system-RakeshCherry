package com.driver.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.driver.PlasticWaste;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class TestCases {

    private PlasticWaste plasticWaste;

    @BeforeEach
    void setUp() {
        plasticWaste = new PlasticWaste();
    }

    @Test
    void testAddPlasticType() {
        plasticWaste.addPlasticType("Type1", 5.0);
        assertEquals(5.0, plasticWaste.getTotalWeight());
    }

    @Test
    void testUpdatePlasticWeight() {
        plasticWaste.addPlasticType("Type2", 8.0);
        plasticWaste.updatePlasticWeight("Type2", 10.0);
        assertEquals(10.0, plasticWaste.getWeightByType("Type2"));
    }

    @Test
    void testGetTotalWeight() {
        plasticWaste.addPlasticType("Type3", 3.0);
        plasticWaste.addPlasticType("Type4", 7.0);
        assertEquals(10.0, plasticWaste.getTotalWeight());
    }

    @Test
    void testGetWeightByType() {
        plasticWaste.addPlasticType("Type5", 12.0);
        assertEquals(12.0, plasticWaste.getWeightByType("Type5"));
    }

    @Test
    void testGetTypeWithHighestWeight() {
        plasticWaste.addPlasticType("Type6", 15.0);
        plasticWaste.addPlasticType("Type7", 8.0);
        assertEquals("Type6", plasticWaste.getTypeWithHighestWeight());
    }

    @Test
    void testGetTypeWithHighestWeightEmpty() {
        assertNull(plasticWaste.getTypeWithHighestWeight());
    }
}

