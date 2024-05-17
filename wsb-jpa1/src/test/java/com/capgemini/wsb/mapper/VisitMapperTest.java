package com.capgemini.wsb.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.mapper.VisitMapper;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest(classes = VisitMapperTest.class)
public class VisitMapperTest {

    /**
     * Test mapping from VisitEntity to VisitTO.
     */
    @Test
    public void testMapToTO() {
        VisitEntity visitEntity = new VisitEntity();
        visitEntity.setId(1L);
        visitEntity.setDescription("Badanie kontrolne");
        visitEntity.setTime(LocalDateTime.of(2024, 3, 14, 10, 0));

        VisitTO visitTO = VisitMapper.mapToTO(visitEntity);

        assertNotNull(visitTO);
        assertEquals(1L, visitTO.getId());
        assertEquals("Badanie kontrolne", visitTO.getDescription());
        assertEquals(LocalDateTime.of(2024, 3, 14, 10, 0), visitTO.getTime());
    }

    /**
     * Test mapping from VisitTO to VisitEntity.
     */
    @Test
    public void testMapToEntity() {
        VisitTO visitTO = new VisitTO();
        visitTO.setId(1L);
        visitTO.setDescription("Badanie kontrolne");
        visitTO.setTime(LocalDateTime.of(2024, 3, 14, 10, 0));

        VisitEntity visitEntity = VisitMapper.mapToEntity(visitTO);

        assertNotNull(visitEntity);
        assertEquals(1L, visitEntity.getId());
        assertEquals("Badanie kontrolne", visitEntity.getDescription());
        assertEquals(LocalDateTime.of(2024, 3, 14, 10, 0), visitEntity.getTime());
    }
}
