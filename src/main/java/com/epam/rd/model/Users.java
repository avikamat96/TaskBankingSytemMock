package com.epam.rd.model;

import com.epam.rd.enums.Gender;

/**
 * The Class Users.
 *
 * @author Avinash_Kamat
 */
public class Users {

  /**
   * @param name
   * @param age
   * @param gender
   */
  public Users(String name, int age, Gender gender) {
    super();
    this.name = name;
    this.age = age;
    this.gender = gender;
  }

  private String name;
  private int age;
  private Gender gender;

  /**
   * Instantiates a new users.
   */
  public Users() {

  }

  /**
   * Gets the name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name.
   *
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets the age.
   *
   * @return the age
   */
  public int getAge() {
    return age;
  }

  /**
   * Sets the age.
   *
   * @param age the age to set
   */
  public void setAge(int age) {
    this.age = age;
  }

  /**
   * Gets the gender.
   *
   * @return the gender
   */
  public Gender getGender() {
    return gender;
  }

  /**
   * Sets the gender.
   *
   * @param gender the gender to set
   */
  public void setGender(Gender gender) {
    this.gender = gender;
  }

}
