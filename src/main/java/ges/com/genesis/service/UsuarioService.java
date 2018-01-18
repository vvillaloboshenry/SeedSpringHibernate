
package ges.com.genesis.service;


import java.util.List;

import ges.com.genesis.domain.Usuario;

public interface UsuarioService {

    public void addUsuario(Usuario usuario);

    public List<Usuario> usuarioslist();

    public void deleteUsuario(Integer usuariioId);

    public Usuario updateUsuario(Usuario usuario);

    public Usuario getUsuario(int usuario_id);
}
