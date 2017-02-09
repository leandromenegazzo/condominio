package br.com.condominio.ejb.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by: Leandro C. Menegazzo
 * Date: 02/09/2016.
 */

@Entity
@Table(name = "unidade", schema = "public")
public class Unidade implements Serializable {

    private static final long serialVersionUID = 9163206312555068868L;

    private int versionId;

    private Integer id;

    private Bloco bloco;

    @Version
    @Column(name = "versionid", nullable = false, columnDefinition = "integer default 0")
    public int getVersionId() {
        return versionId;
    }

    public void setVersionId(int versionId) {
        this.versionId = versionId;
    }

    @Id
    @SequenceGenerator(name = "UnidadeGenId", sequenceName = "unidade_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UnidadeGenId")
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bloco_id")
    public Bloco getBloco() {
        return bloco;
    }

    public void setBloco(Bloco bloco) {
        this.bloco = bloco;
    }
}
