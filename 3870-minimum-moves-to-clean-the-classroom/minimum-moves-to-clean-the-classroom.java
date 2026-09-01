class Solution {

    int X[] = {1, -1, 0, 0};
    int Y[] = {0, 0, 1, -1};

    class Pair {
        int x, y;
        int mask;
        int energy;
        int steps;

        Pair(int x, int y, int mask, int energy, int steps) {
            this.x = x;
            this.y = y;
            this.mask = mask;
            this.energy = energy;
            this.steps = steps;
        }
    }

    public int minMoves(String[] classroom, int energy) {

        int n = classroom.length;
        int m = classroom[0].length();

        int startX = 0;
        int startY = 0;

        int totalL = 0;

        // Give every L a number: 0,1,2,3...
        int[][] id = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                char c = classroom[i].charAt(j);

                if (c == 'S') {
                    startX = i;
                    startY = j;
                }

                if (c == 'L') {
                    id[i][j] = totalL;
                    totalL++;
                }
            }
        }

        int fullMask = (1 << totalL) - 1;

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(startX, startY, 0, energy, 0));

        boolean[][][][] vis =
            new boolean[n][m][1 << totalL][energy + 1];

        vis[startX][startY][0][energy] = true;

        while (!q.isEmpty()) {

            Pair temp = q.poll();

            int x = temp.x;
            int y = temp.y;
            int mask = temp.mask;
            int en = temp.energy;
            int steps = temp.steps;

            if (mask == fullMask) {
                return steps;
            }

            for (int k = 0; k < 4; k++) {

                int nx = x + X[k];
                int ny = y + Y[k];

                if (nx < 0 || nx >= n ||
                    ny < 0 || ny >= m) {
                    continue;
                }

                char c = classroom[nx].charAt(ny);

                if (c == 'X') {
                    continue;
                }

                if (en == 0) {
                    continue;
                }

                int newEnergy = en - 1;
                int newMask = mask;

                // Recharge
                if (c == 'R') {
                    newEnergy = energy;
                }

                // Litter
                if (c == 'L') {
                    newMask |= (1 << id[nx][ny]);
                }

                if (!vis[nx][ny][newMask][newEnergy]) {

                    vis[nx][ny][newMask][newEnergy] = true;

                    q.add(new Pair(
                        nx,
                        ny,
                        newMask,
                        newEnergy,
                        steps + 1
                    ));
                }
            }
        }

        return -1;
    }
}