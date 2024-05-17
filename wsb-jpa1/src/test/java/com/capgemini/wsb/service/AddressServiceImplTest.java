//package com.capgemini.wsb.service;
//
//import com.capgemini.wsb.WsbJpaApplication;
//import com.capgemini.wsb.dto.AddressTO;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest(classes = WsbJpaApplication.class)
//public class AddressServiceImplTest {
//
//    @Autowired
//    private AddressService addressService;
//
//    @Test
//    public void testFindById() {
//        AddressTO address = addressService.findById(1L);
//        assertNotNull(address);
//        assertEquals("Warszawa", address.getCity());
//    }
//
//    @Test
//    public void testAddAddress() {
//        AddressTO addressTO = new AddressTO();
//        addressTO.setCity("Kraków");
//        addressTO.setAddressLine1("ul. Testowa 1");
//        addressTO.setPostalCode("31-001");
//
//        AddressTO createdAddress = addressService.addAddress(addressTO);
//        assertNotNull(createdAddress);
//        assertNotNull(createdAddress.getId());
//        assertEquals("Kraków", createdAddress.getCity());
//    }
//
//    @Test
//    public void testUpdateAddress() {
//        AddressTO addressTO = addressService.findById(1L);
//        assertNotNull(addressTO);
//        addressTO.setCity("Updated City");
//
//        AddressTO updatedAddress = addressService.updateAddress(addressTO);
//        assertNotNull(updatedAddress);
//        assertEquals("Updated City", updatedAddress.getCity());
//    }
//
//    @Test
//    public void testRemoveAddress() {
//        AddressTO addressTO = new AddressTO();
//        addressTO.setCity("City to be removed");
//        addressTO.setAddressLine1("ul. Remove 1");
//        addressTO.setPostalCode("00-000");
//
//        AddressTO createdAddress = addressService.addAddress(addressTO);
//        Long id = createdAddress.getId();
//        addressService.removeAddress(id);
//        assertNull(addressService.findById(id));
//    }
//}
