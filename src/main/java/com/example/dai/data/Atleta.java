package com.example.dai.data;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="Atleta")
public class Atleta extends Utilizador {

    @Column(name="cipa")
    private String cipa;

    @Column(name="numeroCamisola")
    private int numeroCamisola;

    @Transient
    private long numeroParticipacaoJogos;

    @Column(name="numeroParticipacaoTreinos")
    private long numeroParticipacaoTreinos;

    @Column(name="golos")
    private long golos;

    @Column(name="assistencias")
    private long assistencias;

    @Enumerated(EnumType.STRING)
    private Escalao escalao;

    //Mudar Equipa
    @JsonIgnoreProperties("atleta")
    @OneToMany(
            mappedBy = "atleta",
            cascade = CascadeType.ALL,
            fetch=FetchType.LAZY
    )
    private Set<EquipaAtleta> equipa;

    @OneToMany(
            mappedBy = "jogo",
            cascade = CascadeType.ALL,
            fetch=FetchType.LAZY
    )
    private Set<JogoAtleta> jogo;



    public Atleta() {
    }

    public Atleta(Long idUtilizador, String nomeUtilizador) {
        super(idUtilizador, nomeUtilizador);
    }

    public Atleta(String nomeUtilizador, String nomeCompleto, String password, Date dataNascimento, String email, String numeroTelemovel, String cipa, int numeroCamisola, long numeroParticipacaoJogos, long numeroParticipacaoTreinos, long golos, long assistencias, Escalao escalao) {
        super(nomeUtilizador, nomeCompleto, password, dataNascimento, email, numeroTelemovel);
        this.cipa = cipa;
        this.numeroCamisola = numeroCamisola;
        this.numeroParticipacaoJogos = numeroParticipacaoJogos;
        this.numeroParticipacaoTreinos = numeroParticipacaoTreinos;
        this.golos = golos;
        this.assistencias = assistencias;
        this.escalao = escalaoPelaDataNascimento(dataNascimento);
        //escalaoPelaDataNascimento(dataNascimento)
    }

    public Atleta(String nomeUtilizador, String nomeCompleto, String password, Date dataNascimento, String email, String numeroTelemovel, String tipoUtilizador) {
        super(nomeUtilizador, nomeCompleto, password, dataNascimento, email, numeroTelemovel, tipoUtilizador);
        this.escalao= escalaoPelaDataNascimento(dataNascimento);
    }

    public Set<EquipaAtleta> getEquipa() {
        return equipa;
    }

    public void setEquipa(Set<EquipaAtleta> equipa) {
        this.equipa = equipa;
    }

    public String getCipa() {
        return cipa;
    }

    public void setCipa(String cipa) {
        this.cipa = cipa;
    }

    public int getNumeroCamisola() {
        return numeroCamisola;
    }

    public void setNumeroCamisola(int numeroCamisola) {
        this.numeroCamisola = numeroCamisola;
    }

    public long getNumeroParticipacaoJogos() {
        return numeroParticipacaoJogos;
    }

    public void setNumeroParticipacaoJogos(long numeroParticipacaoJogos) {
        this.numeroParticipacaoJogos = numeroParticipacaoJogos;
    }

    public long getGolos() {
        return golos;
    }

    public void setGolos(long golos) {
        this.golos = golos;
    }

    public long getNumeroParticipacaoTreinos() {
        return numeroParticipacaoTreinos;
    }

    public void setNumeroParticipacaoTreinos(long numeroParticipacaoTreinos) {
        this.numeroParticipacaoTreinos = numeroParticipacaoTreinos;
    }

    public long getAssistencias() {
        return assistencias;
    }

    public void setAssistencias(long assistencias) {
        this.assistencias = assistencias;
    }

    public Escalao getEscalao() {
        return escalao;
    }

    public void setEscalao(Escalao escalao) {
        this.escalao = escalao;
    }

    public Escalao escalaoPelaDataNascimento(Date dataNascimento){
        boolean jaFezAnos = true;
        int years = Period.between(convert2LocalDate(dataNascimento), LocalDate.now()).getYears() + 1;

        System.out.printf("asdihndfouihgsuahdfugoihdafoigjid" + convert2LocalDate(dataNascimento));
/*
        //default time zone
        ZoneId defaultZoneId = ZoneId.systemDefault();

        //creating the instance of LocalDate using the day, month, year info
        LocalDate localDate = LocalDate.of(2004, LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth());

        //local date + atStartOfDay() + default time zone + toInstant() = Date
        Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

        //Displaying LocalDate and Date
        System.out.println("LocalDate is: " + localDate);
        System.out.println("Date is: " + date);

        jaFezAnos = dataNascimento.before(date);

        System.out.println("years: " + years);
        System.out.println("Já fez anos : " + jaFezAnos);*/

        if( 7 == years  || years == 8  ){
            return Escalao.BAMBIS;
        }
        if(9 == years  || years == 10){
            return Escalao.MINIS;
        }
        if(11 == years  || years == 12  ){
            return Escalao.INFANTIS;
        }
        if(13 == years  || years == 14){
            return Escalao.INICIADOS;
        }
        if(15 == years  || years == 16){
            return Escalao.JUVENIS;
        }
        if(17 == years  || years == 18){
            return Escalao.JUNIORES;
        }
        if(years >= 19){
            return Escalao.SENIORES;
        }else {
            return null;
        }
    }

    public LocalDate convert2LocalDate(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
}
