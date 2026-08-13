class Solution {

    class Node {
        char leftChar;
        char rightChar;

        int prefix;
        int suffix;
        int best;
        int len;

        Node(char leftChar, char rightChar, int prefix, int suffix, int best, int len) {
            this.leftChar = leftChar;
            this.rightChar = rightChar;
            this.prefix = prefix;
            this.suffix = suffix;
            this.best = best;
            this.len = len;
        }
    }

    Node[] tree;
    String s;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {

        this.s = s;
        int n = s.length();

        tree = new Node[4 * n];

        build(1, 0, n - 1);

        int[] ans = new int[queryIndices.length];

        for (int i = 0; i < queryIndices.length; i++) {

            int index = queryIndices[i];
            char ch = queryCharacters.charAt(i);

            update(1, 0, n - 1, index, ch);

            ans[i] = tree[1].best;
        }

        return ans;
    }

    void build(int node, int l, int r) {

        if (l == r) {
            char c = s.charAt(l);

            tree[node] = new Node(c, c, 1, 1, 1, 1);
            return;
        }

        int mid = (l + r) / 2;

        build(node * 2, l, mid);
        build(node * 2 + 1, mid + 1, r);

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    void update(int node, int l, int r, int index, char ch) {

        if (l == r) {
            tree[node] = new Node(ch, ch, 1, 1, 1, 1);
            return;
        }

        int mid = (l + r) / 2;

        if (index <= mid) {
            update(node * 2, l, mid, index, ch);
        } else {
            update(node * 2 + 1, mid + 1, r, index, ch);
        }

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    Node merge(Node a, Node b) {

        char leftChar = a.leftChar;
        char rightChar = b.rightChar;

        int len = a.len + b.len;

        int prefix = a.prefix;

        if (a.prefix == a.len && a.rightChar == b.leftChar) {
            prefix = a.len + b.prefix;
        }

        int suffix = b.suffix;

        if (b.suffix == b.len && a.rightChar == b.leftChar) {
            suffix = b.len + a.suffix;
        }

        int best = Math.max(a.best, b.best);

        if (a.rightChar == b.leftChar) {
            best = Math.max(best, a.suffix + b.prefix);
        }

        return new Node(
            leftChar,
            rightChar,
            prefix,
            suffix,
            best,
            len
        );
    }
}