package practice.ipcount;

public class IpCounterIntSet extends IpCounterSet<Integer> {

	@Override
	public void addAddress(String address) {
        if (!isValid(address)) {
            throw new IllegalArgumentException();
        }

        String[] strArr = address.split("\\.");
        int compressedIp = 0;

        for (int i = 0; i < strArr.length; i++) {
            compressedIp |= Integer.parseInt(strArr[i]) << (8 * (strArr.length - i - 1));
        }
        
        addToSet(compressedIp);
	}
}