/*
 * Copyright (C) 2017 Kleber Kruger
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.ufms.estagio.model.bean;

import br.ufms.estagio.model.bean.enumerate.UF;

/**
 * Classe que mapeia a tabela Municipio do banco de dados.
 *
 * @author Kleber Kruger
 */
public class Municipio extends Bean<Long> {

    private static final long serialVersionUID = 1L;

    private String nome;
    private UF uf;

    /**
     * Cria um novo objeto Municipio com nome e UF nulos.
     */
    public Municipio() {
        super();
    }
    
    /**
     * Cria um novo objeto Municipio com o nome e a Unidade Federativa (UF) informada.
     * 
     * @param nome
     * @param uf 
     */
    public Municipio(String nome, UF uf) {
        this.nome = nome;
        this.uf = uf;
    }

    /**
     * @return the codigoIBGE
     */
    public Long getCodigoIBGE() {
        return super.getID();
    }

    /**
     * @param codigo the codigoIBGE to set
     */
    public void setCodigoIBGE(Long codigo) {
        super.setID(codigo);
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the uf
     */
    public UF getUF() {
        return uf;
    }

    /**
     * @param uf the uf to set
     */
    public void setUF(UF uf) {
        this.uf = uf;
    }

}
