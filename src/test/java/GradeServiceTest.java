package com.school.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PromotionTest {

    private Promotion promotion;

    @BeforeEach
    void setUp() {
        promotion = new Promotion();
    }

    @Test
    void testAddGroupAndGetGroups() {
        // Arrange
        String group1 = "GroupA";
        String group2 = "GroupB";

        // Act
        promotion.addGroup(group1);
        promotion.addGroup(group2);
        Set<String> groups = promotion.getGroups();

        // Assert
        assertEquals(2, groups.size(), "Promotion should contain 2 groups");
        assertTrue(groups.contains(group1), "Promotion should contain GroupA");
        assertTrue(groups.contains(group2), "Promotion should contain GroupB");
    }

    @Test
    void testAddDuplicateGroup() {
        // Arrange
        String group = "GroupA";

        // Act
        promotion.addGroup(group);
        promotion.addGroup(group); // Ajout du même groupe
        Set<String> groups = promotion.getGroups();

        // Assert
        assertEquals(1, groups.size(), "Promotion should contain only 1 group due to duplicate");
        assertTrue(groups.contains(group), "Promotion should contain GroupA");
    }

    @Test
    void testEmptyPromotion() {
        // Act
        Set<String> groups = promotion.getGroups();

        // Assert
        assertTrue(groups.isEmpty(), "New promotion should have no groups");
    }

    @Test
    void testAddNullGroup() {
        // Act & Assert
        assertThrows(NullPointerException.class, () -> promotion.addGroup(null),
                "Adding null group should throw NullPointerException");
    }
}