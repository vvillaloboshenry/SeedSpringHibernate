/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ges.com.genesis.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import ges.com.genesis.domain.Imagen;
import ges.com.genesis.service.ImagenService;

@Controller
@RequestMapping("/imagenes")
public class ImagenController {

    private final ImagenService imagenService;
    String folderPhysical = "C:/files/img/";
    String folderLogic = "img/";

    @Autowired
    public ImagenController(ImagenService imagenService) {
        this.imagenService = imagenService;
    }
    
    @GetMapping("/nuevo")
    public String showForm() {
        return "imagenes/nuevo";
    }

    @GetMapping(value = {"/", "/imagenes/list", "/imagenes/index"})
    public String listImagen(Model model) throws IOException {
        /**
         * List<Imagen> usuarios = service.imagenlist();
         * model.addObject("imagenList", usuarios);
         *
         */
        return "imagenes/listar";
    }
    //BindingResult --- si hay un error en el formulario entonces enviar un mensaje del error 
    //<form:errors path="nombre.*">

    @PostMapping(value = {"/uploadFile", "/imagen/#"})
    public String agregarFoto(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest req) throws IOException {
        if (!file.isEmpty()) {
            String nombreImagen = file.getOriginalFilename();
            byte[] bytes = file.getBytes();
            Imagen imagen = new Imagen();
            imagen.setNombre(nombreImagen);
            imagen.setUrl(folderLogic + file.getOriginalFilename());
            imagen.setDataImg(folderLogic + file.getOriginalFilename());
            imagenService.addImagen(imagen);
            Path path = Paths.get(folderPhysical + nombreImagen);
            Files.write(path, bytes);

        }
        return "redirect:/imagenes/nuevo";
    }
}
