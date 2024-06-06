package cts.pepsico.Microservice_demo_GET.model;

import jakarta.persistence.*; //for object-relational mapping
import lombok.*; //reduce boilerplate code by automatically generating getter, setter, toString, and constructor methods

@Entity //it will be mapped to a database table
@Table(name = "Books") //table is named as Books, where the entity maps to
@NoArgsConstructor //without parameters
@AllArgsConstructor //parameters
@Getter
@Setter
@ToString
public class Book {

    @Id //specifying the primary key
    @GeneratedValue(strategy = GenerationType.AUTO) //primary value key will be generated automatically
    private Long id;
    private String title;
    private String author;
}
