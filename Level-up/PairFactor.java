import java.util.*;
import java.math.BigInteger;

public class PairFactor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger n = sc.nextBigInteger();
        System.out.println(sumLastPairFactor(n));
        sc.close();
    }

    private static BigInteger sumLastPairFactor(BigInteger n) {
        List<BigInteger[]> pairs = new ArrayList<>();
        BigInteger sqrtN = n.sqrt();
        for (BigInteger i = BigInteger.ONE; i.compareTo(sqrtN) <= 0; i = i.add(BigInteger.ONE)) {
            if (n.mod(i).equals(BigInteger.ZERO)) {
                pairs.add(new BigInteger[]{i, n.divide(i)});
            }
        }
        if (pairs.isEmpty()) {
            return BigInteger.ZERO; 
        }
        BigInteger[] lastPair = pairs.get(pairs.size() - 1);
        return lastPair[0].add(lastPair[1]);
    }
}
