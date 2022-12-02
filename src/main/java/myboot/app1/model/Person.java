package myboot.app1.model;


import lombok.*;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Basic
	@Column
	String firstName;

	@Basic
	@Column
	String lastName;

	@Basic
	@Column
	String email;

	@Basic
	@Column
	String webSite;

	@Basic
	@Column
	String birthday;

	@Basic
	@Column
	String password;

	@OneToOne(targetEntity=CV.class,cascade={CascadeType.MERGE},orphanRemoval=true)
	CV cv;


	public Person(String firstName, String lastName, String email, String webSite, String birthday, String password, CV cv) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.webSite = webSite;
		this.birthday = birthday;
		this.password = password;
		this.cv= cv;
	}
}
