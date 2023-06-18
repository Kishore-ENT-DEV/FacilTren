package com.project.FacilTren.FacilTren.KTMaterialsApi.repo;

import com.project.FacilTren.FacilTren.KTMaterialsApi.model.KTMaterialModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KTMaterialRepo extends JpaRepository<KTMaterialModel, Integer> {
}
