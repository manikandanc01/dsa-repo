/*
 * Problem Description

You are given a string A of size N consisting of lowercase alphabets.

You can change at most B characters in the given string to any other lowercase alphabet such that the number of distinct characters in the string is minimized.

Find the minimum number of distinct characters in the resulting string.


Problem Constraints

1 <= N <= 100000

0 <= B <= N


Input Format

The first argument is a string A.
The second argument is an integer B.

Output Format

Return an integer denoting the minimum number of distinct characters in the string.

Example Input

A = "abcabbccd"
B = 3

Example Output
2

Example Explanation

We can change both 'a' and one 'd' into 'b'.So the new string becomes "bbcbbbccb".
So the minimum number of distinct character will be 2.
 */

package Scaler.Intermediate.Strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ChangeCharacter {
    class Pair {
        char c;
        int frequency;

        Pair(char c, int freq) {
            this.c = c;
            this.frequency = freq;
        }

    }

    public int solve(String A, int B) {
        // Better approach: Greedy
        // Let's say number of unique characters in the given string is k
        // Tc: O(n)+O(k)+O(k logk)+O(k),
        // Sc: O(k)+O(k) -> ~O(k) -> Only smallcase letters, so mostly the size will be
        // always less than or equal to 26
        Map<Character, Integer> freq = new HashMap<>();
        int n = A.length();
        if (n == 1) {
            return 1; // Handling edge cases are very important
        }

        for (char c : A.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        int sz = freq.size();
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // min heap

        // If we only want to iterate over the keys of the map, use freq.keySet()
        for (int frequency : freq.values()) {
            pq.add(frequency);
        }

        int count = sz;
        while (!pq.isEmpty() && B >= 0) {
            int val = pq.poll();
            B -= val;
            if (B >= 0) {
                count--;
            }
        }

        return count;

        /*
         * Map<Character, Integer> freq = new HashMap<>();
         * int n = A.length();
         * if (n == 1) {
         * return 1; // Handling edge cases are very important
         * }
         * 
         * for (char c : A.toCharArray()) {
         * if(!freq.containsKey(c)){
         * freq.put(c,0);
         * }
         * 
         * freq.put(c,freq.get(c)+1);
         * }
         * 
         * int sz = freq.size();
         * Pair[] pairList = new Pair[sz];
         * 
         * int idx = 0;
         * for(Map.Entry<Character, Integer> entry : freq.entrySet()){
         * char c = entry.getKey();
         * int frequency = entry.getValue();
         * 
         * Pair newPair = new Pair(c,frequency);
         * pairList[idx++] = newPair;
         * }
         * 
         * Arrays.sort(pairList, (a,b)->{
         * return a.frequency-b.frequency;
         * });
         * 
         * int count = sz;
         * int i = 0;
         * while(B>=0 && i<sz){
         * int currFreq = pairList[i].frequency;
         * B-=currFreq;
         * if(B>=0){
         * count--;
         * }
         * i++;
         * }
         * 
         * return count;
         * 
         */

    }

}

/*
 * Brute Force Approach:
 * -> Try out all subsets of unique characters and check how many characters can
 * be removed
 * -> Use bitwise operators to generate all subsets
 * -> unique characters: ['a','b','c']
 * -> 2^3 = 8 subsets
 * -> Subsets: [], ['a'], ['b'], ['c'], ['a','b'], ['a','c'], ['b','c'],
 * ['a','b','c']
 * -> 000,001,010,011,100,101,110,111
 * -> if the ith index bit is set, then we are removing the ith unique character
 * -> each subset consider removing that and finally take the minimum remaining
 * unique characters
 * -> Time Complexity: O(2^k * k) where k is the number of unique characters
 * -> Space Complexity: O(k) for storing the unique characters
 * 
 * 
 * // Pseudocode
 * int bruteForce(String A, int B) {
 * Map<Character, Integer> freq = new HashMap<>();
 * for (char c : A.toCharArray()) {
 * freq.put(c, freq.getOrDefault(c, 0) + 1);
 * }
 * 
 * List<Character> uniqueChars = new ArrayList<>(freq.keySet());
 * int k = uniqueChars.size();
 * int minRemaining = k;
 * 
 * // Try all subsets of unique characters
 * for (int mask = 0; mask < (1 << k); mask++) {
 * int totalRemoved = 0;
 * int remaining = k;
 * 
 * for (int i = 0; i < k; i++) {
 * if ((mask & (1 << i)) != 0) {
 * // we are removing uniqueChars[i]
 * totalRemoved += freq.get(uniqueChars.get(i));
 * remaining--;
 * }
 * }
 * 
 * if (totalRemoved <= B) {
 * minRemaining = Math.min(minRemaining, remaining);
 * }
 * }
 * 
 * return minRemaining;
 * }
 * 
 * 
 */