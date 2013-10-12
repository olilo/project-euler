package de.olilo.euler;

/**
 */
public class PrintPrimesUntilOOM {

    public static void main(String[] args) {
        int columns = 0;
        for (int prime : PrimesIterable.INSTANCE) {
            System.out.print(prime + "  ");
            if (++columns == 10) {
                columns = 0;
                int numPrimes = PrimesIterable.INSTANCE.countCachedPrimes();
                long memUsed = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024 / 1024;
                long memTotal = Runtime.getRuntime().totalMemory() / 1024 / 1024;
                System.out.println("   -- " + numPrimes + " primes total; mem: " + memUsed + "/" + memTotal + "MB");
            }
        }
    }

}
