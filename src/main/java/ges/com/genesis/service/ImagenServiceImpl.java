/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ges.com.genesis.service;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ges.com.genesis.dao.ImagenDao;
import ges.com.genesis.domain.Imagen;

@Service("imagenService")
@Transactional
public class ImagenServiceImpl implements ImagenService {

    @Autowired
    private ImagenDao usuarioDao;

    public void addImagen(Imagen usuario) {
        usuarioDao.addImagen(usuario);
    }

    public List<Imagen> imagenlist() {
        return usuarioDao.imagenlist();
    }

    public void deleteImagen(Integer usuariioId) {
        usuarioDao.deleteImagen(usuariioId);
    }

    public Imagen updateImagen(Imagen usuario) {
        return usuarioDao.updateImagen(usuario);
    }

    public Imagen getImagen(int usuario_id) {
        return usuarioDao.getImagen(usuario_id);
    }

}
