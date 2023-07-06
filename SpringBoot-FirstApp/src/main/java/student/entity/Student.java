package student.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentid;
	private String studentname;
	private int studentage;
	private String address;

	@Override
	public String toString() {
		return "Student [studentid=" + studentid + ", studentname=" + studentname + ", studentage=" + studentage
				+ ", address=" + address + "]";
	}
}