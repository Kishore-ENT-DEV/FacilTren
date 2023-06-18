package com.project.FacilTren.FacilTren.KTMaterialsApi.controller;

import com.project.FacilTren.FacilTren.KTMaterialsApi.model.KTMaterialModel;
import com.project.FacilTren.FacilTren.KTMaterialsApi.service.KTMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/kt-material")
public class KTMaterialController {

    @Autowired
    private KTMaterialService ktMaterialService;

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> saveMaterial(@RequestParam("file") MultipartFile file) throws Exception
    {
        KTMaterialModel response = ktMaterialService.saveMaterial(file);

        return new ResponseEntity<KTMaterialModel>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/sno/{sno}")
    public ResponseEntity<?> deleteMaterials(@PathVariable int sno)
        {
            KTMaterialModel response = ktMaterialService.deleteMaterials(sno);
            return new ResponseEntity<KTMaterialModel>(response, HttpStatus.OK);
        }

}

