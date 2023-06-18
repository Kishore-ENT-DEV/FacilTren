package com.project.FacilTren.FacilTren.KTMaterialsApi.service.Impl;

import com.project.FacilTren.FacilTren.KTMaterialsApi.model.KTMaterialModel;
import com.project.FacilTren.FacilTren.KTMaterialsApi.repo.KTMaterialRepo;
import com.project.FacilTren.FacilTren.KTMaterialsApi.service.KTMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class KTMaterialImpl implements KTMaterialService {

    @Autowired
    private KTMaterialRepo ktMaterialRepo;

    public KTMaterialModel saveMaterial(MultipartFile file) throws Exception {
        // TODO Auto-generated method stub

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try
        {
            if(fileName.contains(".."))
            {
                throw new Exception("File Name contains invalid path sequence " + fileName);
            }

            KTMaterialModel KTMaterialPayload = new KTMaterialModel(fileName, file.getContentType(), file.getBytes());

            return ktMaterialRepo.save(KTMaterialPayload);
        }
        catch(Exception e)
        {
            throw new Exception("Could not save file: " + fileName);
        }

    }

    public List<KTMaterialModel> getAllMaterials() {
        // TODO Auto-generated method stub
        return ktMaterialRepo.findAll();
    }

    public KTMaterialModel deleteMaterials(int sno) {
        // TODO Auto-generated method stub
        try
        {
            Optional<KTMaterialModel> op = ktMaterialRepo.findById(sno);

            ktMaterialRepo.deleteById(sno);

            return op.get();
        }
        catch(Exception e)
        {
            return null;
        }
    }
}
