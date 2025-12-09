package com.example.tenbi.service;

// Archivo: CloudinaryService.java

import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class CloudinaryService {

    // Inyecta el bean de Cloudinary que creaste en el paso anterior
    @Autowired
    private Cloudinary cloudinary;

    /**
     * Sube un archivo a Cloudinary y retorna su URL segura.
     * @param file El archivo a subir (MultipartFile).
     * @param folder La carpeta de Cloudinary donde se almacenará (ej: "hitos").
     * @return La URL pública del archivo.
     */
    public String uploadFile(MultipartFile file, String folder) throws IOException {

        Map<String, Object> options = new HashMap<>();
        options.put("folder", folder); // Usamos el parámetro folder

        // La carga real a Cloudinary
        Map uploadResult = cloudinary.uploader().upload(file.getBytes(), options);

        // Devolvemos la URL segura (HTTPS) para guardar en tu base de datos
        return uploadResult.get("secure_url").toString();
    }
}
