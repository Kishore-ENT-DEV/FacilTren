package com.project.FacilTren.FacilTren.KTMaterialsApi.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@Table(name="KT_MATERIALS_TBL")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KTMaterialModel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int sNo;
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String KTMaterialId;
    private String KTMaterialName;
    private String contentType;
    @Lob
    private byte[] data;

    public KTMaterialModel(String KTMaterialId, String KTMaterialName, byte[] data) {
        this.KTMaterialId = KTMaterialId;
        this.KTMaterialName = KTMaterialName;
        this.data = data;
    }
}
