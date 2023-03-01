package com.ibjm.integraigreja.domain;

import com.ibjm.integraigreja.domain.enums.Perfil;
import com.ibjm.integraigreja.domain.enums.TipoFiliacao;
import com.ibjm.integraigreja.domain.enums.TipoMembro;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Document
public class Membro extends Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    private Boolean batizado;

    private Date dataBatismo;
    private Date dataDeNascimento;

    private Integer idade;
    private Character sexo;
    private String identidade;
    private String nascionalidade;
    private String nomeDoPai;
    private String nomeDaMae;
    private String profissao;
    private String estadoSivil;

    private Boolean possuiFilhos;

    private Boolean portadorDeNecessidadesEspeciais;

    private String descricaoDaNecessidade;

    private List<Pessoa> filhos;

    private Pessoa conjuge;

    private Date dataDeCasamento;

    private String endereco;

    private String numero;

    private String cep;
    private Igreja igreja;

    private String igrejaAnterior;

    private TipoMembro tipoMembro;

    private List<Funcao> funcoes;

    private Grupo grupo;

    private Date dataCadastroSistema;

    private Boolean dizimista;

    private Date dataFiliacao;

    private TipoFiliacao tipoFiliacao;

    public Membro(String id, String nome, String email, String telefone, String cpf, Perfil perfil, Boolean batizado, Date dataBatismo, Date dataDeNascimento, Character sexo,
                  String identidade, String nascionalidade, String nomeDoPai, String nomeDaMae, String profissao, String estadoSivil, Boolean possuiFilhos, Boolean portadorDeNecessidadesEspeciais,
                  String descricaoDaNecessidade, List<Pessoa> filhos, Pessoa conjuge, Date dataDeCasamento, String endereco, String numero, String cep, Igreja igreja, String igrejaAnterior,
                  TipoMembro tipoMembro, List<Funcao> funcoes, Grupo grupo, Date dataCadastroSistema, Boolean dizimista, Date dataFiliacao, TipoFiliacao tipoFiliacao) {
        super(id, nome, email, telefone, cpf, perfil);
        this.batizado = batizado;
        this.dataBatismo = dataBatismo;
        this.dataDeNascimento = dataDeNascimento;
        this.sexo = sexo;
        this.identidade = identidade;
        this.nascionalidade = nascionalidade;
        this.nomeDoPai = nomeDoPai;
        this.nomeDaMae = nomeDaMae;
        this.profissao = profissao;
        this.estadoSivil = estadoSivil;
        this.possuiFilhos = possuiFilhos;
        this.portadorDeNecessidadesEspeciais = portadorDeNecessidadesEspeciais;
        this.descricaoDaNecessidade = descricaoDaNecessidade;
        this.filhos = filhos;
        this.conjuge = conjuge;
        this.dataDeCasamento = dataDeCasamento;
        this.endereco = endereco;
        this.numero = numero;
        this.cep = cep;
        this.igreja = igreja;
        this.igrejaAnterior = igrejaAnterior;
        this.tipoMembro = tipoMembro;
        this.funcoes = funcoes;
        this.grupo = grupo;
        this.dataCadastroSistema = dataCadastroSistema;
        this.dizimista = dizimista;
        this.dataFiliacao = dataFiliacao;
        this.tipoFiliacao = tipoFiliacao;
    }

    @Override
    public void setId(String id) {
        super.setId(id);
    }

    public Boolean getBatizado() {
        return batizado;
    }

    public void setBatizado(Boolean batizado) {
        this.batizado = batizado;
    }

    public Date getDataBatismo() {
        return dataBatismo;
    }

    public void setDataBatismo(Date dataBatismo) {
        this.dataBatismo = dataBatismo;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    public String getNascionalidade() {
        return nascionalidade;
    }

    public void setNascionalidade(String nascionalidade) {
        this.nascionalidade = nascionalidade;
    }

    public String getNomeDoPai() {
        return nomeDoPai;
    }

    public void setNomeDoPai(String nomeDoPai) {
        this.nomeDoPai = nomeDoPai;
    }

    public String getNomeDaMae() {
        return nomeDaMae;
    }

    public void setNomeDaMae(String nomeDaMae) {
        this.nomeDaMae = nomeDaMae;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getEstadoSivil() {
        return estadoSivil;
    }

    public void setEstadoSivil(String estadoSivil) {
        this.estadoSivil = estadoSivil;
    }

    public Boolean getPossuiFilhos() {
        return possuiFilhos;
    }

    public void setPossuiFilhos(Boolean possuiFilhos) {
        this.possuiFilhos = possuiFilhos;
    }

    public Boolean getPortadorDeNecessidadesEspeciais() {
        return portadorDeNecessidadesEspeciais;
    }

    public void setPortadorDeNecessidadesEspeciais(Boolean portadorDeNecessidadesEspeciais) {
        this.portadorDeNecessidadesEspeciais = portadorDeNecessidadesEspeciais;
    }

    public String getDescricaoDaNecessidade() {
        return descricaoDaNecessidade;
    }

    public void setDescricaoDaNecessidade(String descricaoDaNecessidade) {
        this.descricaoDaNecessidade = descricaoDaNecessidade;
    }

    public List<Pessoa> getFilhos() {
        return filhos;
    }

    public void setFilhos(List<Pessoa> filhos) {
        this.filhos = filhos;
    }

    public Pessoa getConjuge() {
        return conjuge;
    }

    public void setConjuge(Pessoa conjuge) {
        this.conjuge = conjuge;
    }

    public Date getDataDeCasamento() {
        return dataDeCasamento;
    }

    public void setDataDeCasamento(Date dataDeCasamento) {
        this.dataDeCasamento = dataDeCasamento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Igreja getIgreja() {
        return igreja;
    }

    public void setIgreja(Igreja igreja) {
        this.igreja = igreja;
    }

    public String getIgrejaAnterior() {
        return igrejaAnterior;
    }

    public void setIgrejaAnterior(String igrejaAnterior) {
        this.igrejaAnterior = igrejaAnterior;
    }

    public TipoMembro getTipoMembro() {
        return tipoMembro;
    }

    public void setTipoMembro(TipoMembro tipoMembro) {
        this.tipoMembro = tipoMembro;
    }

    public List<Funcao> getFuncoes() {
        return funcoes;
    }

    public void setFuncoes(List<Funcao> funcoes) {
        this.funcoes = funcoes;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Date getDataCadastroSistema() {
        return dataCadastroSistema;
    }

    public void setDataCadastroSistema(Date dataCadastroSistema) {
        this.dataCadastroSistema = dataCadastroSistema;
    }

    public Boolean getDizimista() {
        return dizimista;
    }

    public void setDizimista(Boolean dizimista) {
        this.dizimista = dizimista;
    }

    public Date getDataFiliacao() {
        return dataFiliacao;
    }

    public void setDataFiliacao(Date dataFiliacao) {
        this.dataFiliacao = dataFiliacao;
    }

    public TipoFiliacao getTipoFiliacao() {
        return tipoFiliacao;
    }

    public void setTipoFiliacao(TipoFiliacao tipoFiliacao) {
        this.tipoFiliacao = tipoFiliacao;
    }

}
