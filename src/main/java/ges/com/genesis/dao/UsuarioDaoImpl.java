/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ges.com.genesis.dao;


import java.util.List;
import org.springframework.stereotype.Repository;

import ges.com.genesis.domain.Usuario;

@Repository
public class UsuarioDaoImpl extends AbstractDao<Integer, Usuario> implements UsuarioDao {


    public void addUsuario(Usuario usuario) {
        getSession().saveOrUpdate(usuario);
    }


    public List<Usuario> usuarioslist() {
        return getSession().createQuery("from Usuario p left join fetch p.imagen").list();
    }


    public void deleteUsuario(Integer usuariioId) {
        Usuario employee = (Usuario) getSession().load(
                Usuario.class, usuariioId);
        if (null != employee) {
            this.getSession().delete(employee);
        }
    }

 
    public Usuario updateUsuario(Usuario usuario) {
        getSession().update(usuario);
        return usuario;
    }


    public Usuario getUsuario(int usuario_id) {
        return (Usuario) getSession().get( Usuario.class, usuario_id);
    }




}
