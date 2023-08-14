package practice.ipcount;

import java.util.regex.Pattern;

public interface IpCounter {
	
	public abstract void addAddress(String address);
	
	public abstract long getUniqueAmount();
	
	default boolean isValid(String address) {
        String pattern = "^((\\d{1,3}\\.){3}\\d{1,3})$";
        return Pattern.matches(pattern, address);
    }
}