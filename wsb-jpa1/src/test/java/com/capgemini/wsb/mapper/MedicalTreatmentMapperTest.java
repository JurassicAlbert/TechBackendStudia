package com.capgemini.wsb.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.capgemini.wsb.dto.MedicalTreatmentTO;
import com.capgemini.wsb.mapper.AddressMapperTest;
import com.capgemini.wsb.mapper.MedicalTreatmentMapper;
import com.capgemini.wsb.persistence.entity.MedicalTreatmentEntity;
import com.capgemini.wsb.persistence.enums.TreatmentType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = MedicalTreatmentMapperTest.class)
public class MedicalTreatmentMapperTest {

    /**
     * Test mapping from MedicalTreatmentEntity to MedicalTreatmentTO.
     */
    @Test
    public void testMapToTO() {
        MedicalTreatmentEntity treatmentEntity = new MedicalTreatmentEntity();
        treatmentEntity.setId(1L);
        treatmentEntity.setDescription("Badanie USG");
        treatmentEntity.setType(TreatmentType.USG);

        MedicalTreatmentTO treatmentTO = MedicalTreatmentMapper.mapToTO(treatmentEntity);

        assertNotNull(treatmentTO);
        assertEquals(1L, treatmentTO.getId());
        assertEquals("Badanie USG", treatmentTO.getDescription());
        assertEquals(TreatmentType.USG, treatmentTO.getType());
    }

    /**
     * Test mapping from MedicalTreatmentTO to MedicalTreatmentEntity.
     */
    @Test
    public void testMapToEntity() {
        MedicalTreatmentTO treatmentTO = new MedicalTreatmentTO();
        treatmentTO.setId(1L);
        treatmentTO.setDescription("Badanie USG");
        treatmentTO.setType(TreatmentType.USG);

        MedicalTreatmentEntity treatmentEntity = MedicalTreatmentMapper.mapToEntity(treatmentTO);

        assertNotNull(treatmentEntity);
        assertEquals(1L, treatmentEntity.getId());
        assertEquals("Badanie USG", treatmentEntity.getDescription());
        assertEquals(TreatmentType.USG, treatmentEntity.getType());
    }
}
