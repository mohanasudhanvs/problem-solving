package com.github.mathan26.concepts.basics;

import java.util.HashSet;

public class HashCodeAndEquals {
    public static void main(String[] args) {
        HashCodeAndEquals obj = new HashCodeAndEquals();
        System.out.println(obj.hashCode()); //1163157884 // some int value

        HashSet<String> set = new HashSet<>();
        set.add("A");

        //Internally it calculates the hashcode and put the value to the key.

        /**
         * Computes key.hashCode() and spreads (XORs) higher bits of hash
         * to lower.  Because the table uses power-of-two masking, sets of
         * hashes that vary only in bits above the current mask will
         * always collide. (Among known examples are sets of Float keys
         * holding consecutive whole numbers in small tables.)  So we
         * apply a transform that spreads the impact of higher bits
         * downward. There is a tradeoff between speed, utility, and
         * quality of bit-spreading. Because many common sets of hashes
         * are already reasonably distributed (so don't benefit from
         * spreading), and because we use trees to handle large sets of
         * collisions in bins, we just XOR some shifted bits in the
         * cheapest possible way to reduce systematic lossage, as well as
         * to incorporate impact of the highest bits that would otherwise
         * never be used in index calculations because of table bounds.
         */
    /*    static final int hash(Object key) {
            int h;
            return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
        }*/

        set.add("B");
        set.add("A");
        System.out.println(set);
    }
}
