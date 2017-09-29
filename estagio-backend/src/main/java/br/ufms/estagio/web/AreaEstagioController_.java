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
package br.ufms.estagio.web;

import br.ufms.estagio.domain.entity.AreaEstagio;
import br.ufms.estagio.domain.repository.AreaEstagioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author kleberkruger
 */
@RestController
@RequestMapping(path = "/areas")
public class AreaEstagioController_ {
    
    @Autowired
    private AreaEstagioRepository repository;

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public AreaEstagio findOne(@PathVariable("id") Long id) {
        return repository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<AreaEstagio> findAll() {
        return repository.findAll();
    }
}
