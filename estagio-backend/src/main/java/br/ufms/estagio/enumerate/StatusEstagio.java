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
package br.ufms.estagio.enumerate;

/**
 * @author Kleber Kruger
 */
public enum StatusEstagio {

    EM_ANDAMENTO, APROVADO, REPROVADO;

    @Override
    public String toString() {
        switch (this) {
            case EM_ANDAMENTO:
                return "Em andamento";
            case APROVADO:
                return "Aprovado";
            case REPROVADO:
                return "Reprovado";
        }
        return super.toString();
    }

}
