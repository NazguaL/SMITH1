package Lab07;

import org.junit.Test;

public class MonteCarloTest {

    @Test
    public void testGetPiParallel() throws InterruptedException {
        long start, finish;
        start = System.currentTimeMillis();
        System.out.println("Parallel Pi is: " + new Lab07MonteCarlo().getPiParallel());
        finish = System.currentTimeMillis();
        System.out.println("ITERATIONS " + new Lab07MonteCarlo().getIterationsTotal());
        System.out.println("TIME " + (finish - start) + "ms");
        System.out.println("===============================");
    }
}

