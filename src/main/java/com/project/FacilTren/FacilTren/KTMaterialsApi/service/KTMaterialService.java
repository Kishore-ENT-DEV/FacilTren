package com.project.FacilTren.FacilTren.KTMaterialsApi.service;

import com.project.FacilTren.FacilTren.KTMaterialsApi.model.KTMaterialModel;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface KTMaterialService {

    public KTMaterialModel saveMaterial(MultipartFile file) throws Exception;

    public List<KTMaterialModel> getAllMaterials();

    public KTMaterialModel deleteMaterials(int sno);
}
