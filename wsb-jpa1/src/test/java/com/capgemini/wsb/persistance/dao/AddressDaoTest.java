package com.capgemini.wsb.persistance.dao;

import com.capgemini.wsb.persistence.dao.impl.AddressDaoImpl;
import com.capgemini.wsb.persistence.entity.AddressEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressDaoTest {
    @Autowired
    private AddressDaoImpl addressDao;

    @Transactional
    @Test
    public void testShouldFindAddressById() {
        // given
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddressLine1("ul. Zielona 10");
        addressEntity.setAddressLine2("apt. 8");
        addressEntity.setCity("Warszawa");
        addressEntity.setPostalCode("00-123");
        addressDao.save(addressEntity);

        // when
        AddressEntity foundEntity = addressDao.findById(addressEntity.getId()).orElse(null);

        // then
        assertThat(foundEntity).isNotNull();
        assertThat(foundEntity.getPostalCode()).isEqualTo("00-123");
    }

    @Transactional
    @Test
    public void testShouldSaveAddress() {
        // given
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddressLine1("line1");
        addressEntity.setAddressLine2("line2");
        addressEntity.setCity("City1");
        addressEntity.setPostalCode("66-666");
        long entitiesNumBefore = addressDao.count();

        // when
        final AddressEntity saved = addressDao.save(addressEntity);

        // then
        assertThat(saved).isNotNull();
        assertThat(saved.getId()).isNotNull();
        assertThat(addressDao.count()).isEqualTo(entitiesNumBefore + 1);
    }

    @Transactional
    @Test
    public void testShouldSaveAndRemoveAddress() {
        // given
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddressLine1("line1");
        addressEntity.setAddressLine2("line2");
        addressEntity.setCity("City1");
        addressEntity.setPostalCode("66-666");

        // when
        final AddressEntity saved = addressDao.save(addressEntity);
        assertThat(saved.getId()).isNotNull();
        final AddressEntity newSaved = addressDao.findById(saved.getId()).orElse(null);
        assertThat(newSaved).isNotNull();

        addressDao.delete(saved.getId());

        // then
        final AddressEntity removed = addressDao.findById(saved.getId()).orElse(null);
        assertThat(removed).isNull();
    }
}
