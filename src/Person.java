/**
 * Created by Alan
 */

public class Person {

    private String name;
    private String gender;
    private String dob;
    private String address;
    private String postcode;
    

    public Person(String name, String gender, String dob, String address, String postcode) {
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.postcode = postcode;
    }

    /**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @param dob the date of birth to set
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @param postcode the postcode to set
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	/**
     * gets the name
     * @return name - the name to be set
     */
    public String getName(){
    	return name;
    }
    
    /**
     * gets the gender
     * @return gender - the gender of the person
     */
    public String getGender() {
		return gender;
	}
    
    /**
     * gets the Date of Birth
     * @return dob - the date of birth of the person
     */
    public String getDob() {
		return dob;
	}
    
    /**
     * gets the address
     * @return address - the address of the person
     */
    public String getAddress() {
		return address;
	}
    
    /**
     * gets the PostCode
     * @return postcode - the PostCode of the person
     */
    public String getPostcode() {
		return postcode;
	}
}