/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ges.com.genesis.dao;

import java.util.List;

import ges.com.genesis.domain.Imagen;

/**
 *
 * @author GescomWeb
 */
public interface ImagenDao {

    public void addImagen(Imagen usuario);

    public List<Imagen> imagenlist();

    public void deleteImagen(Integer usuariioId);

    public Imagen updateImagen(Imagen usuario);

    public Imagen getImagen(int usuario_id);
}
