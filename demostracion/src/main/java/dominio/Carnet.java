package dominio;


import lombok.*;

/*
@Getter  //esto me crea los getters, pero no se muestra en código
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor //Constructor vacio
*/
@Data  //Crea todo los @ de arriba de una
@AllArgsConstructor //contructor con todos los atributos

public class Carnet {
    private Long id;
    private String numero;
}
