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

import ges.com.genesis.dao.UsuarioDao;
import ges.com.genesis.domain.Usuario;

@Service("usuarioService")
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;


    public void addUsuario(Usuario usuario) {
        usuarioDao.addUsuario(usuario);
    }


    public List<Usuario> usuarioslist() {
        return usuarioDao.usuarioslist();
    }


    public void deleteUsuario(Integer usuariioId) {
        usuarioDao.deleteUsuario(usuariioId);
    }


    public Usuario updateUsuario(Usuario usuario) {
        return usuarioDao.updateUsuario(usuario);
    }


    public Usuario getUsuario(int usuario_id) {
        return usuarioDao.getUsuario(usuario_id);
    }

}
