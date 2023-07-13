package src;
import java.util.HashSet;
import java.util.regex.Pattern;

public class ipAnalysis{

    public static class Ip {

        protected static int countUnique = 0;

        protected boolean isValid(String adress){

            String pattern = "^((\\d{1,3}\\.){3}\\d{1,3})$";

            return Pattern.matches(pattern, adress);
        }

        public static int getUniqueQuantity(){
            return countUnique;
        }

    }


    public static class IpSet extends Ip{

        public static HashSet<Integer> data = new HashSet<>();
        
        public IpSet(String adress){

            if (!(isValid(adress))) throw new IllegalArgumentException();
            
            String[] strArr = adress.split("\\.");
            int newIpSet = 0;
            for (int i = 0; i < strArr.length; i++){ // 00000000 0000000 00000000 ********
                newIpSet |= Integer.parseInt(strArr[i]) << (8 * (strArr.length - i - 1));
            }
            int sizeBefore = data.size();

            data.add(newIpSet);

            if (data.size() != sizeBefore) countUnique ++;
        }

        

        public static long getMemory(){
            return (data.size() * Integer.SIZE);
        }

        public static void printIpSet(){
        int mask = 255;
            for (int adress : data){
                int[] num = new int[4];
                for (int i = 3; i > -1; i--){
                    num[i] = (adress >> 8 * (3 - i)) & mask;
                } 
                System.out.format("%d.%d.%d.%d\n", num[0], num[1], num[2], num[3]);
            }
        }
    }

    public static class IpArray extends Ip{

        public static long[] ipRecord = new long[(int)Math.pow(2, 26)];
        
        public IpArray(String adress){
            
            if (!(isValid(adress))) throw new IllegalArgumentException();

            String[] strArr = adress.split("\\.");

            long bitNum = 0;

            for (int i = 0; i < 4; i++){
                bitNum += Long.parseLong(strArr[i]) * (long)Math.pow(256, 3 - i);
            }

            int index = (int)(bitNum / 64);
            int localBit = (int)(bitNum % 64);

            long mask = -9223372036854775807L >> localBit;
            long numBefore = ipRecord[index];

            long newNum = ipRecord[index] | mask;

            ipRecord[index] = newNum;

            if (numBefore != ipRecord[index]) countUnique++;
        }
    }

    public static class IpString extends Ip{
        
        public static HashSet<String> data = new HashSet<>();

        public IpString(String adress){

            if (!(isValid(adress))) throw new IllegalArgumentException();

            int sizeBefore = data.size();
            data.add(adress);
            if (sizeBefore != data.size()) countUnique++;
        }
    }
}