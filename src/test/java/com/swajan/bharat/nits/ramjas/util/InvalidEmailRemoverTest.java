package com.swajan.bharat.nits.ramjas.util;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class InvalidEmailRemoverTest {

    @Test
    void readInvalidEmails() {
        Set<String> strings = InvalidEmailRemover.readInvalidEmails();
        System.out.println(strings);
    }
}