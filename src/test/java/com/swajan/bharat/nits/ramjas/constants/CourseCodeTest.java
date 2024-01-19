package com.swajan.bharat.nits.ramjas.constants;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseCodeTest {

    @Test
    void values() {
        for (CourseCode CC : CourseCode.values()){
            System.out.println(CC.courseName+"\t"+CC.courseCode);
            }

        }
}