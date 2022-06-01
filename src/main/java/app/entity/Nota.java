
package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;
import cronapi.swagger.CronappSwagger;


/**
* Classe que representa a tabela NOTA
* @generated
*/
@Entity
@Table(name = "\"NOTA\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.Nota")
public class Nota implements Serializable {
    /**
    * UID da classe, necessário na serialização
    * @generated
    */
    private static final long serialVersionUID = 1L;

    /**
    * @generated
    */
    @Id
    @Column(name = "id", nullable = false, insertable=true, updatable=true)
        private java.lang.String id = UUID.randomUUID().toString().toUpperCase();


    /**
    * @generated
    */
    @Column(name = "titulo", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String titulo;


    /**
    * @generated
    */
    @Column(name = "conteudo", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String conteudo;


    /**
    * @generated
    */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.util.Date data;


    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="fk_colecao", nullable = true, referencedColumnName = "id", insertable=true, updatable=true, foreignKey = @ForeignKey(name = "", foreignKeyDefinition = "FOREIGN KEY (fk_colecao) REFERENCES COLECAO (id)"))
        
        private Colecao colecao;


    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="fk_user", nullable = true, referencedColumnName = "id", insertable=true, updatable=true, foreignKey = @ForeignKey(name = "", foreignKeyDefinition = "FOREIGN KEY (fk_user) REFERENCES USER (id)"))
        
        private User user;


    /**
    * Construtor
    * @generated
    */
    public Nota(){
    }

    /**
    * Obtém id
    * return id
    * @generated
    */
    public java.lang.String getId() {
        return this.id;
    }

    /**
    * Define id
    * @param id id
    * @generated
    */
    public Nota setId(java.lang.String id) {
        this.id = id;
        return this;
    }
    /**
    * Obtém titulo
    * return titulo
    * @generated
    */
    public java.lang.String getTitulo() {
        return this.titulo;
    }

    /**
    * Define titulo
    * @param titulo titulo
    * @generated
    */
    public Nota setTitulo(java.lang.String titulo) {
        this.titulo = titulo;
        return this;
    }
    /**
    * Obtém conteudo
    * return conteudo
    * @generated
    */
    public java.lang.String getConteudo() {
        return this.conteudo;
    }

    /**
    * Define conteudo
    * @param conteudo conteudo
    * @generated
    */
    public Nota setConteudo(java.lang.String conteudo) {
        this.conteudo = conteudo;
        return this;
    }
    /**
    * Obtém data
    * return data
    * @generated
    */
    public java.util.Date getData() {
        return this.data;
    }

    /**
    * Define data
    * @param data data
    * @generated
    */
    public Nota setData(java.util.Date data) {
        this.data = data;
        return this;
    }
    /**
    * Obtém colecao
    * return colecao
    * @generated
    */
    public Colecao getColecao() {
        return this.colecao;
    }

    /**
    * Define colecao
    * @param colecao colecao
    * @generated
    */
    public Nota setColecao(Colecao colecao) {
        this.colecao = colecao;
        return this;
    }
    /**
    * Obtém user
    * return user
    * @generated
    */
    public User getUser() {
        return this.user;
    }

    /**
    * Define user
    * @param user user
    * @generated
    */
    public Nota setUser(User user) {
        this.user = user;
        return this;
    }

    /**
    * @generated
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
Nota object = (Nota)obj;
        if (id != null ? !id.equals(object.id) : object.id != null) return false;
        return true;
    }

    /**
    * @generated
    */
    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

}