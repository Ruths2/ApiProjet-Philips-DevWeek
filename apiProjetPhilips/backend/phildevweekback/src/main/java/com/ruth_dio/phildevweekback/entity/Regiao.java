package com.ruth_dio.phildevweekback.entity;

import javax.persistence.*;


@Entity
public class Regiao {
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(nullable = false)
    private Long id;
    private String Regiao;
    private Integer Total_exames;

    public Regiao(String regiao, Integer total_exames) {
		Regiao = regiao;
		Total_exames = total_exames;
    }

    public Regiao() {}

    public Long getId() {
        return id;
    }

    public String getRegiao() {
        return Regiao;
    }

    public void setRegiao(String regiao) {
       this.Regiao = regiao;
    }

    public Integer getTotal() {
        return Total_exames;
    }

    public void setTotal(Integer total_exames) {
        this.Total_exames = total_exames;
    }
}

