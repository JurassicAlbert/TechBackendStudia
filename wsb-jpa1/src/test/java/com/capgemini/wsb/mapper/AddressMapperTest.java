package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.AddressTO;
import com.capgemini.wsb.persistence.entity.AddressEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for AddressMapper.
 */
@SpringBootTest(classes = AddressMapperTest.class)
class AddressMapperTest {

    @Test
    void testMapToTO() {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setId(1L);
        addressEntity.setCity("Warsaw");
        addressEntity.setAddressLine1("ul. Zielona 10");
        addressEntity.setAddressLine2("apt. 8");
        addressEntity.setPostalCode("00-123");

        AddressTO addressTO = AddressMapper.mapToTO(addressEntity);

        assertNotNull(addressTO);
        assertEquals(1L, addressTO.getId());
        assertEquals("Warsaw", addressTO.getCity());
        assertEquals("ul. Zielona 10", addressTO.getAddressLine1());
        assertEquals("apt. 8", addressTO.getAddressLine2());
        assertEquals("00-123", addressTO.getPostalCode());
    }

    @Test
    void testMapToEntity() {
        AddressTO addressTO = new AddressTO();
        addressTO.setId(1L);
        addressTO.setCity("Warsaw");
        addressTO.setAddressLine1("ul. Zielona 10");
        addressTO.setAddressLine2("apt. 8");
        addressTO.setPostalCode("00-123");

        AddressEntity addressEntity = AddressMapper.mapToEntity(addressTO);

        assertNotNull(addressEntity);
        assertEquals(1L, addressEntity.getId());
        assertEquals("Warsaw", addressEntity.getCity());
        assertEquals("ul. Zielona 10", addressEntity.getAddressLine1());
        assertEquals("apt. 8", addressEntity.getAddressLine2());
        assertEquals("00-123", addressEntity.getPostalCode());
    }
}
