package com.aditya.personal.algorithmproblems.coursera;

public class UnionFind {

    public static class QuickUnionFind {

        private final int[] dataStore;

        public QuickUnionFind(int size) {
            this.dataStore = new int[size];

            for (int i = 0; i < size; i++)
                this.dataStore[i] = i;
        }

        public void union(int left, int right) {

            int leftId = dataStore[left];
            int rightId = dataStore[right];

            for (int i = 0; i < dataStore.length; i++) {
                if (dataStore[i] == leftId)
                    dataStore[i] = rightId;
            }
        }

        public boolean isConnected(int left, int right) {
            return this.dataStore[left] == this.dataStore[right];
        }
    }

    public static class QuickUnion {

        private final int[] dataStore;

        public QuickUnion(int size) {
            this.dataStore = new int[size];

            for (int i = 0; i < size; i++)
                this.dataStore[i] = i;
        }

        public void union(int p, int q) {

            int parentP = findParent(p);
            int parentQ = findParent(q);

            this.dataStore[parentP] = parentQ;
        }

        public int findParent(int val) {

            if (val == this.dataStore[val])
                return val;

            return findParent(this.dataStore[val]);
        }

        public boolean isConnected(int p, int q) {
            return findParent(p) == findParent(q);
        }
    }

    public static void main(String[] args) {
        QuickUnionFind quickUnionFind = new QuickUnionFind(10);

        quickUnionFind.union(4, 3);
        quickUnionFind.union(3, 8);
        quickUnionFind.union(6, 5);
        quickUnionFind.union(9, 4);
        quickUnionFind.union(2, 1);
        System.out.println(quickUnionFind.isConnected(8, 9));
        System.out.println(quickUnionFind.isConnected(5, 0));

        System.out.println("--------");

        QuickUnion quickUnion = new QuickUnion(10);

        quickUnion.union(4, 3);
        quickUnion.union(3, 8);
        quickUnion.union(6, 5);
        quickUnion.union(9, 4);
        quickUnion.union(2, 1);
        System.out.println(quickUnion.isConnected(8, 9));
        System.out.println(quickUnion.isConnected(5, 0));
    }
}
