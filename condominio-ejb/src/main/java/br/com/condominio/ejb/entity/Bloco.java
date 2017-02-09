package br.com.condominio.ejb.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by: Leandro C. Menegazzo
 * Date: 02/09/2016.
 */

@Entity
@Table(name = "bloco", schema = "public")
public class Bloco implements Serializable {

    private static final long serialVersionUID = -3377800624868227696L;

    private int versionId;

    private Integer id;

    private String nome;
    private String apelido;

    private Condominio condominio;

    private List<Unidade> unidades;

    @Version
    @Column(name = "versionid", nullable = false, columnDefinition = "integer default 0")
    public int getVersionId() {
        return versionId;
    }

    public void setVersionId(int versionId) {
        this.versionId = versionId;
    }

    @Id
    @SequenceGenerator(name = "BlocoGenId", sequenceName = "bloco_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BlocoGenId")
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "nome", length = 20)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name = "apelido", length = 100)
    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "condominio_id")
    public Condominio getCondominio() {
        return condominio;
    }

    public void setCondominio(Condominio condominio) {
        this.condominio = condominio;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bloco")
    public List<Unidade> getUnidades() {
        return unidades;
    }

    public void setUnidades(List<Unidade> unidades) {
        this.unidades = unidades;
    }
}
