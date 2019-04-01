
public class Student extends Person {

	private int studentNumber;
	private String courseTitle;
	private String startDate;
	private float bursary;
	private String email;

	/**
	 * constructor
	 */
	public Student(String name, String gender, String dob, String address, String postcode, int studentNumber,
			String courseTitle, String startDate, float bursary, String email) {
		super(name, gender, dob, address, postcode);

		this.studentNumber = studentNumber;
		this.courseTitle = courseTitle;
		this.startDate = startDate;
		this.bursary = bursary;
		this.email = email;
	}

	/**
	 * @return the studentNumber
	 */
	public int getStudentNumber() {
		return studentNumber;
	}

	/**
	 * @param studentNumber
	 *            the studentNumber to set
	 */
	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}

	/**
	 * @return the courseTitle
	 */
	public String getCourseTitle() {
		return courseTitle;
	}

	/**
	 * @param courseTitle
	 *            the Name of the course to set
	 */
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the course starting Date to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the bursary
	 */
	public float getBursary() {
		return bursary;
	}

	/**
	 * @param bursary
	 *            the amount of bursary to set
	 */
	public void setBursary(float bursary) {
		this.bursary = bursary;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "studentNumber: " + studentNumber + "\r\ncourseTitle: " + courseTitle + "\r\nstartDate: " 
				+ startDate + "\r\nbursary: " + bursary + "\r\nemail: " + email + "\r\nname: " + super.getName() 
				+ "\r\ngender: " + super.getGender() + "\r\ndob: " + super.getDob() + "\r\naddress: " + super.getAddress()
				+ "\r\npostcode: " + super.getPostcode() + "\r\n";
	}


	// Put your getters, setters and toString methods here with Javadoc ...

}
