package br.com.condominio.ejb.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by: Leandro C. Menegazzo
 * Date: 02/09/2016.
 */
@Entity
@Table(name = "areacomum", schema = "public")
public class AreaComum implements Serializable {

    private static final long serialVersionUID = -7232068543324397932L;

    private int versionId;

    private boolean reservavel;

    private Integer id;

    private String nome;
    private String descricao;

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

    @Column(name = "reservavel", columnDefinition = "boolean not null default false")
    public boolean isReservavel() {
        return reservavel;
    }

    public void setReservavel(boolean reservavel) {
        this.reservavel = reservavel;
    }

    @Column(name = "nome", length = 150)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name = "descricao", length = 250)
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "condominio_id")
    public Condominio getCondominio() {
        return condominio;
    }

    public void setCondominio(Condominio condominio) {
        this.condominio = condominio;
    }
}
