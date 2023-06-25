package com.tutoriais.spring_boot_postgresdb_amigoscode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity(name = "Student")
@Table(
    name = "student",
    uniqueConstraints = @UniqueConstraint(columnNames = "email", name = "student_email")
    )
public class Student {

    @Id
    @SequenceGenerator(
        name = "student_sequence",
        sequenceName = "student_sequence",
        allocationSize = 1
        )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "student_sequence"        
    )
    @Column(
        name = "id",
        updatable = false
        )
    private Long ID;

    @Column(
        name = "first_name",
        nullable = false,
        columnDefinition = "TEXT"
        )
    private String firstName;

    @Column(
        name = "last_name",
        nullable = false,
        columnDefinition = "TEXT"
        )
    private String lastName;

    @Column(
        name = "email",
        nullable = false,
        columnDefinition = "TEXT"
        //unique = true -> esta coluna é para não conter valores repetidos mas foi retirada daqui e 
        //foi especificado a constraint na notação @Table -> uniqueConstraints = @UniqueConstraint(columnNames = "email", name = "student_email")
        )
    private String email;

    @Column(
        name = "age",
        nullable = false,
        columnDefinition = "TEXT"
        )
    private Integer age;


    public Student(String firstName, String lastName, String email, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    public Long getID() {
        return ID;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    
    
}
