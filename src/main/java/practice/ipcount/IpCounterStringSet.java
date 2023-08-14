package practice.ipcount;

public class IpCounterStringSet extends IpCounterSet<String> {
	@Override
	public void addAddress(String address) {
        if (!isValid(address)) {
            throw new IllegalArgumentException();
        }

        addToSet(address);
	}
}
