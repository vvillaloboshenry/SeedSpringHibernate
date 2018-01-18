package ges.com.genesis.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import ges.com.genesis.domain.Imagen;
import ges.com.genesis.domain.Usuario;
import ges.com.genesis.service.ImagenService;
import ges.com.genesis.service.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final ImagenService imagenService;

    String folderPhysical = "C:/files/img/";
    String folderLogic = "img/";

    @Autowired
    public UsuarioController(UsuarioService usuarioService, ImagenService imagenService) {
        this.usuarioService = usuarioService;
        this.imagenService = imagenService;
    }

    @GetMapping("/nuevo")
    public String showform() {
        return "usuarios/nuevo";
    }

    @PostMapping(value = "/ajax/uploadFile")
    public String AgregarUsuario(@RequestParam("nombreuser") String name, @RequestParam("direccion") String direccion,
            @RequestParam("telefono") String telefono, @RequestParam("file") CommonsMultipartFile file,
            HttpServletRequest req) throws IOException {
        new File("C:/files").mkdir();
        new File("C:/files/img").mkdir();
        String nombreImagen = "";
        if (!file.isEmpty()) {
            nombreImagen = file.getOriginalFilename();
            byte[] bytes = file.getBytes();
            Imagen imagen = new Imagen();
            imagen.setNombre(nombreImagen);
            imagen.setUrl(folderLogic + nombreImagen);
            imagen.setDataImg(folderLogic + nombreImagen);
            imagenService.addImagen(imagen);

            Usuario usuario = new Usuario();
            usuario.setImagen(imagen);
            usuario.setNombre(name);
            usuario.setTelefono(telefono);
            usuario.setDireccion(direccion);
            usuarioService.addUsuario(usuario);

            Path path = Paths.get(folderPhysical + nombreImagen);
            Files.write(path, bytes);
        }
        return "redirect:/usuarios/";
    }

    @GetMapping(value = {"/", "/list", "/index"})
    public String listUsuario(Model model) throws IOException {
        List<Usuario> usuarios = usuarioService.usuarioslist();
        model.addAttribute("usuarioList", usuarios);
        return "usuarios/index";
    }

    @GetMapping(value = {"/U/{id}"})
    public String UpdateUser(@PathVariable int id, Model model) {
        Usuario usuario = usuarioService.getUsuario(id);
        model.addAttribute("usuario", usuario);
        return "usuarios/edit";
    }

    @GetMapping(value = {"/D/{id}"})
    public String DeleteUser(@PathVariable int id, Model model) {
        usuarioService.deleteUsuario(id);
        model.addAttribute("message", "Ususario Eliminado");
        return "usuarios/index";
    }
}
