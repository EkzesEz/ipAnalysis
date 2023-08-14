package practice.ipcount;

import java.util.HashSet;
import java.util.Set;

public abstract class IpCounterSet<T> implements IpCounter {
	private long uniqueAmount = 0;
	private Set<T> data = new HashSet<>();

	@Override
	public long getUniqueAmount() {
		return uniqueAmount;
	}
	
	void addToSet(T element){
		if (data.add(element)){
			uniqueAmount++;
		}
	}
}
