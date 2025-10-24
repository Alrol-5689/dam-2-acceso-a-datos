package model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

  private static Long serialVersionUID = 1L;

  private int id;
  private String name, apellido, email, dni;
  private int telefono;

  public User(int id, String name, String apellido) {
    this.id = id;
    this.name = name;
    this.apellido = apellido;
  }

}
