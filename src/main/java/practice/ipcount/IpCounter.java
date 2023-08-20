package practice.ipcount;

public interface IpCounter {
	
	public abstract void addAddress(String address);
	
	public abstract long getUniqueAmount();
	
	default boolean isValid(String address) {
	    String[] octets = address.split("\\.");
	    if (octets.length != 4) {
	        return false;
	    }

	    for (String octet : octets) {
	        try {
	            int value = Integer.parseInt(octet);
	            if (value < 0 || value > 255) {
	                return false;
	            }
	        } catch (NumberFormatException e) {
	            return false;
	        }
	    }

	    return true;
	}

}