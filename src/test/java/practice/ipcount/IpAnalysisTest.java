package practice.ipcount;

import static org.junit.Assert.*;

import org.junit.Test;

public class IpAnalysisTest {
    @Test
    public void getUniqueAmountIntSetTest() {
    	IpCounter ipCounterIntSet = new IpCounterIntSet();
        ipCounterIntSet.addAddress("123.22.222.198");
        ipCounterIntSet.addAddress("13.1.252.0");
        ipCounterIntSet.addAddress("0.0.0.0");
        ipCounterIntSet.addAddress("255.255.255.255");
        ipCounterIntSet.addAddress("0.0.0.0");
        ipCounterIntSet.addAddress("255.255.255.255");
        ipCounterIntSet.addAddress("123.22.222.198");
        assertEquals(4, ipCounterIntSet.getUniqueAmount());
    }

    @Test
    public void getUniqueAmountArrayTest() {
    	IpCounter ipCounterArray = new IpCounterArray();
        ipCounterArray.addAddress("123.22.222.198");
        ipCounterArray.addAddress("13.1.252.0");
        ipCounterArray.addAddress("0.0.0.0");
        ipCounterArray.addAddress("255.255.255.255");
        ipCounterArray.addAddress("0.0.0.0");
        ipCounterArray.addAddress("255.255.255.255");
        ipCounterArray.addAddress("123.22.222.198");
        assertEquals(4, ipCounterArray.getUniqueAmount());
    }

    @Test
    public void getUniqueAmountStringSetTest() {
    	IpCounter ipCounterStringSet = new IpCounterStringSet();
        ipCounterStringSet.addAddress("123.22.222.198");
        ipCounterStringSet.addAddress("13.1.252.0");
        ipCounterStringSet.addAddress("0.0.0.0");
        ipCounterStringSet.addAddress("255.255.255.255");
        ipCounterStringSet.addAddress("0.0.0.0");
        ipCounterStringSet.addAddress("255.255.255.255");
        ipCounterStringSet.addAddress("123.22.222.198");
        assertEquals(4, ipCounterStringSet.getUniqueAmount());
    }

    @Test
    public void loadIntSetTest() {
    	IpCounter ipCounterIntSet = new IpCounterIntSet();
        for (int first = 0; first < 50; first++) {
            for (int second = 0; second < 50; second++) {
                for (int third = 0; third < 50; third++) {
                    for (int fourth = 0; fourth < 50; fourth++) {
                        ipCounterIntSet.addAddress(String.format("%d.%d.%d.%d", first, second, third, fourth));
                    }
                }
            }
        }
        
        System.out.println("Load is executed");

        assertEquals((int) Math.pow(50, 4), ipCounterIntSet.getUniqueAmount());
    }

    @Test
    public void loadArrayTest() {
    	IpCounter ipCounterArray = new IpCounterArray();
        for (int first = 0; first < 50; first++) {
            for (int second = 0; second < 50; second++) {
                for (int third = 0; third < 50; third++) {
                    for (int fourth = 0; fourth < 50; fourth++) {
                        ipCounterArray.addAddress(String.format("%d.%d.%d.%d", first, second, third, fourth));
                    }
                }
            }
        }
        
        System.out.println("Load is executed");

        assertEquals((int) Math.pow(50, 4), ipCounterArray.getUniqueAmount());
    }

    @Test
    public void loadStringSetTest() {
    	IpCounter ipCounterStringSet = new IpCounterStringSet();
        for (int first = 0; first < 50; first++) {
            for (int second = 0; second < 50; second++) {
                for (int third = 0; third < 50; third++) {
                    for (int fourth = 0; fourth < 50; fourth++) {
                        ipCounterStringSet.addAddress(String.format("%d.%d.%d.%d", first, second, third, fourth));
                    }
                }
            }
        }
        
        System.out.println("Load is executed");

        assertEquals((int) Math.pow(50, 4), ipCounterStringSet.getUniqueAmount());
    }
}