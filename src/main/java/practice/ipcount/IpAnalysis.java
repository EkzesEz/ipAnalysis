package practice.ipcount;

import java.util.HashSet;
import java.util.regex.Pattern;

public class IpAnalysis {

    public static class IpCounter {
        protected static int countUnique = 0;

        protected boolean isValid(String address) {
            String pattern = "^((\\d{1,3}\\.){3}\\d{1,3})$";
            return Pattern.matches(pattern, address);
        }

        public static int getUniqueAmount() {
            return countUnique;
        }
    }

    public static class IpCounterSet extends IpCounter {
        public static HashSet<Integer> data = new HashSet<>();

        public IpCounterSet(String address) {
            if (!isValid(address)) {
                throw new IllegalArgumentException();
            }

            String[] strArr = address.split("\\.");
            int newIpCounterSet = 0;

            for (int i = 0; i < strArr.length; i++) {
                newIpCounterSet |= Integer.parseInt(strArr[i]) << (8 * (strArr.length - i - 1));
            }

            int sizeBefore = data.size();
            data.add(newIpCounterSet);

            if (data.size() != sizeBefore) {
                countUnique++;
            }
        }
    }

    public static class IpCounterArray extends IpCounter {
        public static long[] ipCounterRecord = new long[(int) Math.pow(2, 26)];

        public IpCounterArray(String address) {
            if (!isValid(address)) {
                throw new IllegalArgumentException();
            }

            String[] strArr = address.split("\\.");
            long bitNum = 0;

            for (int i = 0; i < 4; i++) {
                bitNum += Long.parseLong(strArr[i]) * (long) Math.pow(256, 3 - i);
            }

            int index = (int) (bitNum / 64);
            int localBit = (int) (bitNum % 64);

            long mask = -9223372036854775807L >> localBit;
            long numBefore = ipCounterRecord[index];

            long newNum = ipCounterRecord[index] | mask;

            ipCounterRecord[index] = newNum;

            if (numBefore != ipCounterRecord[index]) {
                countUnique++;
            }
        }
    }

    public static class IpCounterString extends IpCounter {
        public static HashSet<String> data = new HashSet<>();

        public IpCounterString(String address) {
            if (!isValid(address)) {
                throw new IllegalArgumentException();
            }

            int sizeBefore = data.size();
            data.add(address);

            if (sizeBefore != data.size()) {
                countUnique++;
            }
        }
    }
}