package practice.ipcount;

import static org.junit.Assert.*;

import org.junit.Test;

public class IpAnalysisTest {
    @Test
    public void getUniqueAmountSetTest() {
        new IpAnalysis.IpCounterSet("123.22.222.198");
        new IpAnalysis.IpCounterSet("13.1.252.0");
        new IpAnalysis.IpCounterSet("0.0.0.0");
        new IpAnalysis.IpCounterSet("255.255.255.255");
        new IpAnalysis.IpCounterSet("0.0.0.0");
        new IpAnalysis.IpCounterSet("255.255.255.255");
        new IpAnalysis.IpCounterSet("123.22.222.198");
        assertEquals(4, IpAnalysis.IpCounterSet.getUniqueAmount());
    }

    @Test
    public void getUniqueAmountArrayTest() {
        new IpAnalysis.IpCounterArray("123.22.222.198");
        new IpAnalysis.IpCounterArray("13.1.252.0");
        new IpAnalysis.IpCounterArray("0.0.0.0");
        new IpAnalysis.IpCounterArray("255.255.255.255");
        new IpAnalysis.IpCounterArray("0.0.0.0");
        new IpAnalysis.IpCounterArray("255.255.255.255");
        new IpAnalysis.IpCounterArray("123.22.222.198");
        assertEquals(4, IpAnalysis.IpCounterArray.getUniqueAmount());
    }

    @Test
    public void getUniqueAmountStringTest() {
        new IpAnalysis.IpCounterString("123.22.222.198");
        new IpAnalysis.IpCounterString("13.1.252.0");
        new IpAnalysis.IpCounterString("0.0.0.0");
        new IpAnalysis.IpCounterString("255.255.255.255");
        new IpAnalysis.IpCounterString("0.0.0.0");
        new IpAnalysis.IpCounterString("255.255.255.255");
        new IpAnalysis.IpCounterString("123.22.222.198");
        assertEquals(4, IpAnalysis.IpCounterString.getUniqueAmount());
    }

    @Test
    public void loadSetTest() {
        for (int first = 0; first < 50; first++) {
            for (int second = 0; second < 50; second++) {
                for (int third = 0; third < 50; third++) {
                    for (int fourth = 0; fourth < 50; fourth++) {
                        new IpAnalysis.IpCounterSet(String.format("%d.%d.%d.%d", first, second, third, fourth));
                    }
                }
            }
        }
        
        System.out.println("Load is executed");

        assertEquals((int) Math.pow(50, 4), IpAnalysis.IpCounterSet.getUniqueAmount());
    }

    @Test
    public void loadArrayTest() {
        for (int first = 0; first < 50; first++) {
            for (int second = 0; second < 50; second++) {
                for (int third = 0; third < 50; third++) {
                    for (int fourth = 0; fourth < 50; fourth++) {
                        new IpAnalysis.IpCounterArray(String.format("%d.%d.%d.%d", first, second, third, fourth));
                    }
                }
            }
        }
        
        System.out.println("Load is executed");

        assertEquals((int) Math.pow(50, 4), IpAnalysis.IpCounterArray.getUniqueAmount());
    }

    @Test
    public void loadStringTest() {
        for (int first = 0; first < 50; first++) {
            for (int second = 0; second < 50; second++) {
                for (int third = 0; third < 50; third++) {
                    for (int fourth = 0; fourth < 50; fourth++) {
                        new IpAnalysis.IpCounterString(String.format("%d.%d.%d.%d", first, second, third, fourth));
                    }
                }
            }
        }
        
        System.out.println("Load is executed");

        assertEquals((int) Math.pow(50, 4), IpAnalysis.IpCounterString.getUniqueAmount());
    }
}