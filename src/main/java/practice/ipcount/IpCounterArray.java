package practice.ipcount;

public class IpCounterArray implements IpCounter {
	private long[] ipCounterRecord = new long[(int) Math.pow(2, 26)];
	private long uniqueAmount = 0;

	@Override
	public void addAddress(String address) {
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
            uniqueAmount++;
        }
    
	}

	@Override
	public long getUniqueAmount() {
		return uniqueAmount;
	}
}
