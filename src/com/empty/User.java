package com.empty;
import com.empty.Post;
import java.io.Serializable;

import javax.management.Query;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import java.util.List;
@Entity
@Table(name = "user")
@NamedQueries(
@NamedQuery(query= "select obj FROM User obj WHERE obj.isActive =null", name="user.getListActive"))
public class User implements Serializable{
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="name",length = 255 , nullable = false)
	private String name;
	@Column(name="email",length = 32 , nullable = false)
	private String email;
	@Column(name="password",length = 32 )
	private String password;
	@Column(name="number",length = 32 , nullable = false)
	private String number;
	@Column(name="gender",length = 32 , nullable = false)
	private Integer gender;
	@Column(name="role",length = 32 , nullable = true)
	@OneToMany(mappedBy = "userP")
	private List<Post> posts;
	@Column(name = "isActive")
	private String isActive;
	
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	private Integer role = 0;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", number="
				+ number + ", gender=" + gender + ", role=" + role + "]";
	}
	
	
	
		
}
