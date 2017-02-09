package br.com.condominio.ejb.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by: Leandro C. Menegazzo
 * Date: 02/09/2016.
 */

@Entity
@Table(name = "livroocorrencia", schema = "public")
public class LivroOcorrencia implements Serializable {

    private static final long serialVersionUID = 1530522678577780950L;

    private int versionId;

    private Integer id;

    private Condominio condominio;

    @Version
    @Column(name = "versionid", nullable = false, columnDefinition = "integer default 0")
    public int getVersionId() {
        return versionId;
    }

    public void setVersionId(int versionId) {
        this.versionId = versionId;
    }

    @Id
    @SequenceGenerator(name = "CondominioGenId", sequenceName = "condominio_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CondominioGenId")
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @OneToOne
    @JoinColumn(name = "condominio_id")
    public Condominio getCondominio() {
        return condominio;
    }

    public void setCondominio(Condominio condominio) {
        this.condominio = condominio;
    }
}
