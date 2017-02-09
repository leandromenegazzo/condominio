package br.com.condominio.ejb.entity;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by: Leandro C. Menegazzo
 * Date: 31/08/2016.
 */

@Entity
@Table(name = "condominio", schema = "public")
public class Condominio implements Serializable {

    private static final long serialVersionUID = -552475315999520820L;

    private int versionId;

    private Integer id;
    private Integer numero;

    private Long cnpj;

    private String razaoSocial;
    private String nomeFantasia;
    private String cep;
    private String endereco;
    private String complemento;
    private String bairro;
    private String ddd;
    private String telefone;
    private String email;

    private Date dataCadastro;
    private Date dataUltimaAtualizacao;

    private LivroOcorrencia livroOcorrencia;

    private List<Bloco> blocos;
    private List<AreaComum> areasComuns;

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

    @Column(name = "numero")
    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    @Column(name = "cnpj")
    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }

    @Column(name = "razaosocial", length = 200)
    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    @Column(name = "nomefantasia", length = 200)
    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    @Column(name = "cep", length = 10)
    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Column(name = "endereco")
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Column(name = "complemento", length = 80)
    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Column(name = "bairro", length = 100)
    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    @Column(name = "ddd", length = 3)
    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    @Column(name = "telefone", length = 10)
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Email
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "datacadastro")
    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "dataultimaatualizacao")
    public Date getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }

    public void setDataUltimaAtualizacao(Date dataUltimaAtualizacao) {
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "condominio")
    public LivroOcorrencia getLivroOcorrencia() {
        return livroOcorrencia;
    }

    public void setLivroOcorrencia(LivroOcorrencia livroOcorrencia) {
        this.livroOcorrencia = livroOcorrencia;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "condominio")
    public List<Bloco> getBlocos() {
        return blocos;
    }

    public void setBlocos(List<Bloco> blocos) {
        this.blocos = blocos;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "condominio")
    public List<AreaComum> getAreasComuns() {
        return areasComuns;
    }

    public void setAreasComuns(List<AreaComum> areasComuns) {
        this.areasComuns = areasComuns;
    }
}
