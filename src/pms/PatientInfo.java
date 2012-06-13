package pms;
/**
 * Class to store the information of a specific patient.
 * @author Eric
 * @version 1.0
 * 
 */
public class PatientInfo {

	private String name;
	private String address;
	private String patientNumber;
	private int age;
	private Gender gender;
	private double weight;
	private double height;
	private SafeLimit safeLimits;
	private String specificCondition;

	/**
	 * create an instance of a patientInfo to store the information
	 * @param name
	 * @param address
	 * @param patientNumber
	 * @param age
	 * @param gender
	 * @param weight
	 * @param height
	 * @param specificCondition
	 */
	public PatientInfo(String name, String address, String patientNumber, int age,
			Gender gender, double weight, double height, SafeLimit safeLimits,
			String specificCondition) {
		this.name = name;
		this.address = address;
		this.patientNumber = patientNumber;
		this.age = age;
		this.gender = gender;
		this.weight = weight;
		this.height = height;
		this.safeLimits = safeLimits;
		this.specificCondition = specificCondition;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the patientNumber
	 */
	public String getPatientNumber() {
		return patientNumber;
	}

	/**
	 * @param patientNumber the patientNumber to set
	 */
	public void setPatientNumber(String patientNumber) {
		this.patientNumber = patientNumber;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	/**
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}
	
	/**
	 * @return the safe limits
	 */
	public SafeLimit getSafeLimits() {
		return safeLimits;
	}

	/**
	 * @param safeLimits the safe limits
	 */
	public void setSafeLimits(SafeLimit safeLimits) {
		this.safeLimits = safeLimits;
	}

	/**
	 * @return the specificCondition
	 */
	public String getSpecificCondition() {
		return specificCondition;
	}

	/**
	 * @param specificCondition the specificCondition to set
	 */
	public void setSpecificCondition(String specificCondition) {
		this.specificCondition = specificCondition;
	}

	/** 
	 * return the description of the patient
	 */
	@Override
	public String toString(){
		return 	"Patient" +
				"\nName: \t" + name +
				"\nAddress: \t" + address +
				"\nPatientNumber: \t" + patientNumber +
				"\nAge: \t" + age +
				"\nGender: \t" + gender +
				"\nWeight: \t" + weight +
				"\nHeight: \t" + height +
				"\nSpecific Condition: \t" + specificCondition +
				"\n";
	}
	
	/**
	 * enum to indicate the gender of the patient
	 * @author Eric
	 */
	public enum Gender {
		MALE("Male"),
		FEMALE("Female");
		
		private String gender;
		
		private Gender(String gender) {
			this.gender = gender;
		}
		
		@Override
		public String toString() {
			return gender;
		}
	}
}
