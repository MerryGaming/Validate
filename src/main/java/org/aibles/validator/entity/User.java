package org.aibles.validator.entity;


import java.sql.Date;
import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aibles.validator.validation.BaseValidator;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@Entity
@NoArgsConstructor
@Table(name = "user_profile")
public class User extends BaseValidator<User> {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "email", unique = true, length = 100)
  private String email;

  @Column(name = "password", unique = true, length = 20)
  @NotBlank
  private String password;

  @Column(name = "firstname", unique = true, length = 20)
  @NotBlank
  private String firstname;

  @Column(name = "lastname", unique = true, length = 20)
  @NotBlank
  private String lastname;

  @Column(name = "number_phone", unique = true, length = 15)
  @NotBlank
  private String numberPhone;

  @Column(name = "date_of_birth")
  @NotNull
  private Date dateOfBirth;

  @Column(name = "address", unique = true, length = 256)
  @NotBlank
  private String address;

  @CreationTimestamp
  @Column(name = "created_at")
  @NotNull
  private Instant createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at")
  @NotNull
  private Instant updatedAt;





}
