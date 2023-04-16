package com.company;
import java.io.*;
import java.util.*;

public class TaskQueue {
    public static void main(String[] args) {
        // Define the old and new task queues and the current index
        char[] oldQueue = {'A', 'B', 'C', 'D', 'E', 'F', 'A', 'B', 'C', 'D', 'A', 'B', 'C', 'A', 'B', 'A'};
        char[] newQueue = {'A', 'B', 'C', 'D', 'E', 'F', 'A', 'B', 'C', 'D', 'A', 'B', 'C', 'A', 'B', 'A'};
        int currentIndex = 7;

        // Remove inactive members from the new queue
        List<Character> newQueueList = new ArrayList<>();
        for (char member : newQueue) {
            if (member != 'A' && member != 'D') {
                newQueueList.add(member);
            }
        }
        char[] newQueueArray = new char[newQueueList.size()];
        for (int i = 0; i < newQueueList.size(); i++) {
            newQueueArray[i] = newQueueList.get(i);
        }

        // Determine the new index of the current index member
        char currentMember = oldQueue[currentIndex];
        int newIndex = -1;
        for (int i = 0, count = 0; i < newQueueArray.length; i++) {
            if (newQueueArray[i] == currentMember) {
                count++;
                if (count == currentIndex - i % (oldQueue.length - 1)) {
                    newIndex = i;
                    break;
                }
            }
        }
        if (newIndex == -1) {
            for (int i = currentIndex + 1; i < oldQueue.length; i++) {
                if (oldQueue[i] == currentMember) {
                    newIndex = i - (oldQueue.length - newQueueArray.length);
                    break;
                }
            }
        }

        // Output the result
        System.out.println("Old Task Queue: " + Arrays.toString(oldQueue));
        System.out.println("New Task Queue: " + Arrays.toString(newQueueArray));
        System.out.println("Current Index: " + currentIndex);
        System.out.println("Current Index Member: " + currentMember);
        System.out.println("New Index: " + newIndex);
    }
}
