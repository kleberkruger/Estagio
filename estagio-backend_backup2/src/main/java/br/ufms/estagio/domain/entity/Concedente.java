/*
 * Copyright (C) 2017 Universidade Federal de Mato Grosso do Sul
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
package br.ufms.estagio.domain.entity;

import br.ufms.springbootlib.domain.GenericEntity;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe que mapeia a entidade Concedente.
 *
 * @author Kleber Kruger
 * @param <P>
 */
@Entity
@Table(name = "tb_concedente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Concedente.findAll", query = "SELECT t FROM Concedente t")
    , @NamedQuery(name = "Concedente.findById", query = "SELECT t FROM Concedente t WHERE t.id = :id")
    , @NamedQuery(name = "Concedente.findByConveniado", query = "SELECT t FROM Concedente t WHERE t.conveniado = :conveniado")})
//public class Concedente<P extends Pessoa> extends GenericEntity<Long> {
public class Concedente extends GenericEntity<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "con_id")
    private Long id;

    @JoinColumn(name = "con_id", referencedColumnName = "p_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
//    @OneToOne(targetEntity = Pessoa.class, optional = false)
//    private P dados;
    private Pessoa dados;

    @JoinColumn(name = "rep_id_representante_legal", referencedColumnName = "rep_id")
    @ManyToOne(optional = false)
    private RepresentanteLegal representanteLegal;

    @Column(name = "con_conveniado")
    private Boolean conveniado;

    /**
     * @return the id
     */
    @Override
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @param <P>
     * @return the dados
     */
//    public P getDados() {
//        return dados;
//    }
    public <P extends Pessoa> P getDados() {
        return (P) dados;
    }

    /**
     * @param <P>
     * @param dados the dados to set
     */
//    public void setDados(P dados) {
    public <P extends Pessoa> void setDados(P dados) {
        this.dados = dados;
    }

    /**
     * @return the representanteLegal
     */
    public RepresentanteLegal getRepresentanteLegal() {
        return representanteLegal;
    }

    /**
     * @param representanteLegal the representanteLegal to set
     */
    public void setRepresentanteLegal(RepresentanteLegal representanteLegal) {
        this.representanteLegal = representanteLegal;
    }

    /**
     * @return the conveniado
     */
    public Boolean getConveniado() {
        return conveniado;
    }

    /**
     * @param conveniado the conveniado to set
     */
    public void setConveniado(Boolean conveniado) {
        this.conveniado = conveniado;
    }

}
