package com.aditya.personal.algorithmproblems.leetCode;

public class E_1450_NumberStudentsDoingHomeworkAtGivenTime {

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {

        int count = 0;

        for (int i = 0; i < startTime.length; i++) {

            if (startTime[i] <= queryTime && endTime[i] >= queryTime)
                count+=1;
        }

        return count;

    }

}
