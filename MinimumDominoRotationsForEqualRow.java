class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        // 2 1 2 4 2 2
        // 5 2 6 2 3 2

        if (tops.length != bottoms.length) {
            return -1;
        }

        int first = findMinRotations(tops, bottoms, tops[0]);
        if (first != -1) {
            return first;
        }

        return findMinRotations(tops, bottoms, bottoms[0]); // if second is -1, just return it. otherwise return value of second.
        
    }

    private int findMinRotations(int[] tops, int[] bottoms, int target) {
        int a = 0;
        int b = 0;

        int i = 0;
        while(i < tops.length) {
            if (tops[i] != target && bottoms[i] != target) {
                return -1;
            }

            if (tops[i] != target) {
                a++;
            } 
            if (bottoms[i] != target) {
                b++;
            }
            i++;
        }

        return Math.min(a, b);
    }
}