
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
* Classe que representa a tabela COLECAO
* @generated
*/
@Entity
@Table(name = "\"COLECAO\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.Colecao")
public class Colecao implements Serializable {
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
    @Column(name = "nomecolecao", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String nomecolecao;


    /**
    * Construtor
    * @generated
    */
    public Colecao(){
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
    public Colecao setId(java.lang.String id) {
        this.id = id;
        return this;
    }
    /**
    * Obtém nomecolecao
    * return nomecolecao
    * @generated
    */
    public java.lang.String getNomecolecao() {
        return this.nomecolecao;
    }

    /**
    * Define nomecolecao
    * @param nomecolecao nomecolecao
    * @generated
    */
    public Colecao setNomecolecao(java.lang.String nomecolecao) {
        this.nomecolecao = nomecolecao;
        return this;
    }

    /**
    * @generated
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
Colecao object = (Colecao)obj;
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