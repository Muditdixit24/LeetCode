

class Fancy {

    List<Long> list;
    long add = 0;
    long mul = 1;
    long MOD = 1000000007;

    public Fancy() {
        list = new ArrayList<>();
    }

    public void append(int val) {
        long inv = modInverse(mul);
        long stored = ((val - add) % MOD + MOD) % MOD;
        stored = (stored * inv) % MOD;
        list.add(stored);
    }

    public void addAll(int inc) {
        add = (add + inc) % MOD;
    }

    public void multAll(int m) {
        mul = (mul * m) % MOD;
        add = (add * m) % MOD;
    }

    public int getIndex(int idx) {
        if (idx >= list.size()) return -1;

        long val = list.get(idx);
        long ans = (val * mul) % MOD;
        ans = (ans + add) % MOD;
        return (int) ans;
    }

    private long modInverse(long x) {
        return modPow(x, MOD - 2);
    }

    private long modPow(long a, long b) {
        long res = 1;
        a %= MOD;

        while (b > 0) {
            if ((b & 1) == 1)
                res = (res * a) % MOD;

            a = (a * a) % MOD;
            b >>= 1;
        }

        return res;
    }
}