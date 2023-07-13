import java.util.HashSet;
import java.util.regex.Pattern;

public class ip_analysis{
    public static void main(String[] args){
        for (int i = 0; i < 10_000_000; ++i){
            String newip = String.format("%d.%d.%d.%d", (int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255));
            Ip tmp = new Ip(newip);
        }
        //Ip.printip();
        //long usedBytes = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println(Ip.getMemory());
        System.out.println(Ip.getUniqueQuantity());
    }
    public static class Ip{
        
        static int countUnique = 0, count = 0;

        static HashSet<Integer> data = new HashSet<>();

        //static int mask0 = -16777216;
        //static int mask1 = 16711680;
        //static int mask2 = 65280;
        //static int mask3 = 255;

        public Ip(String adress){

            if (!(isValid(adress))) throw new IllegalArgumentException();

            count += 1;
            
            String[] strArr = adress.split("\\.");
            int newip = 0;
            for (int i = 0; i < strArr.length; i++){ // 00000000 0000000 00000000 ********
                newip |= Integer.parseInt(strArr[i]) << (8 * (strArr.length - i - 1));
            }
            int sizeBefore = data.size();

            data.add(newip);

            if (data.size() != sizeBefore) countUnique += 1;
        }

        public static int getUniqueQuantity(){
            return countUnique;
        }

        public static long getMemory(){
            return (data.size() * Integer.SIZE);
        }

        public static void printip(){
        int mask = 255;
            for (int adress : data){
                int[] num = new int[4];
                for (int i = 3; i > -1; i--){
                    num[i] = (adress >> 8 * (3 - i)) & mask;
                } 
                System.out.format("%d.%d.%d.%d\n", num[0], num[1], num[2], num[3]);
            }
        }

        static boolean isValid(String adress){

            String pattern = "^((\\d{1,3}\\.){3}\\d{1,3})$";

            return Pattern.matches(pattern, adress);
        }
    }
}