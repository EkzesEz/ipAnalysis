package test;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import src.ipAnalysis.*;

public class ipAnalysisTest {

    @Test
    public void getUniqueQuantitySetTest(){
        new IpSet("123.22.222.198");
        new IpSet("13.1.252.0");
        new IpSet("0.0.0.0");
        new IpSet("255.255.255.255");
        new IpSet("0.0.0.0");
        new IpSet("255.255.255.255");
        new IpSet("123.22.222.198");
        assertEquals(4, IpSet.getUniqueQuantity());
    }

    @Test
    public void getUniqueQuantityArrayTest(){
        new IpArray("123.22.222.198");
        new IpArray("13.1.252.0");
        new IpArray("0.0.0.0");
        new IpArray("255.255.255.255");
        new IpArray("0.0.0.0");
        new IpArray("255.255.255.255");
        new IpArray("123.22.222.198");
        assertEquals(4, IpArray.getUniqueQuantity());
    }

    @Test
    public void getUniqueQuantityStringTest(){
        new IpString("123.22.222.198");
        new IpString("13.1.252.0");
        new IpString("0.0.0.0");
        new IpString("255.255.255.255");
        new IpString("0.0.0.0");
        new IpString("255.255.255.255");
        new IpString("123.22.222.198");
        assertEquals(4, IpString.getUniqueQuantity());
    }

    @Test
    public void loadSetTest(){
        for (int first = 0; first < 50; first++){
            for (int second = 0; second < 50; second++){
                for (int third = 0; third < 50; third++){
                    for (int fourth = 0; fourth < 50; fourth++){
                        new IpSet(String.format("%d.%d.%d.%d", first, second, third, fourth));
                    }
                }
            }
        }
        System.out.println("Load is produced");
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals((int)Math.pow(50, 4), IpSet.getUniqueQuantity());
    }

    @Test
    public void loadArrayTest(){
        for (int first = 0; first < 50; first++){
            for (int second = 0; second < 50; second++){
                for (int third = 0; third < 50; third++){
                    for (int fourth = 0; fourth < 50; fourth++){
                        new IpArray(String.format("%d.%d.%d.%d", first, second, third, fourth));
                    }
                }
            }
        }
        System.out.println("Load is produced");
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals((int)Math.pow(50, 4), IpArray.getUniqueQuantity());
    }

    @Test
    public void loadStringTest(){
        for (int first = 0; first < 50; first++){
            for (int second = 0; second < 50; second++){
                for (int third = 0; third < 50; third++){
                    for (int fourth = 0; fourth < 50; fourth++){
                        new IpString(String.format("%d.%d.%d.%d", first, second, third, fourth));
                    }
                }
            }
        }
        System.out.println("Load is produced");
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals((int)Math.pow(50, 4), IpString.getUniqueQuantity());
    }
}