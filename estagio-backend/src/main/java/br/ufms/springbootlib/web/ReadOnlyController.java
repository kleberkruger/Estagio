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
package br.ufms.springbootlib.web;

import br.ufms.estagio.Application;
import br.ufms.estagio.domain.entity.Concedente;
import br.ufms.estagio.domain.entity.PessoaJuridica;
import br.ufms.springbootlib.domain.GenericEntity;
import br.ufms.springbootlib.service.ReadOnlyService;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import br.ufms.springbootlib.domain.ReadOnlyBaseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Kleber Kruger
 *
 * @param <E>
 * @param <ID>
 * @param <S>
 */
public class ReadOnlyController<E extends GenericEntity<ID>, ID extends Serializable, S extends ReadOnlyService<E, ID, ? extends ReadOnlyBaseRepository<E, ID>>> {

    @Autowired
    private S service;

    private static final Logger LOG = LoggerFactory.getLogger(ReadOnlyController.class);

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public E findOne(@PathVariable("id") ID id) {
        LOG.info("Entidades encontrads com findOne(" + id + ")");
        LOG.info("-------------------------------");
        E e = service.findOne(id);
        LOG.info(e != null ? e.toString() : "Inexistente");
        LOG.info("-------------------------------\n");
        return null;
        
//        return getService().findOne(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<E> findAll() {
        LOG.info("Entidades encontrads com findAll():");
        LOG.info("-------------------------------");
        service.findAll().forEach((entity) -> {
            if (entity instanceof Concedente) {
                Concedente<PessoaJuridica> c = (Concedente) entity;
                LOG.info(c.getDados().getNome());
            }
            LOG.info(entity.toString());
        });
        LOG.info("-------------------------------\n");
        return null;

//        return getService().findAll();
    }

    /**
     * @return the service
     */
    public S getService() {
        return service;
    }

}
