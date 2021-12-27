package org.yasynskyi.myshop.dao.jdbc.mapper;

import org.junit.jupiter.api.Test;
import org.yasynskyi.myshop.entity.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProductRowMapperTest {

    @Test
    public void testMapRow() throws SQLException {
        //prepare
        ProductRowMapper productRowMapper = new ProductRowMapper();
        LocalDateTime localDateTime = LocalDateTime.of(2021, 12, 22, 15, 38, 59);
        Timestamp timestamp = Timestamp.valueOf(localDateTime);
        ResultSet resultSetMock = mock(ResultSet.class);
        when(resultSetMock.getInt("id")).thenReturn(1);
        when(resultSetMock.getString("name")).thenReturn("pie");
        when(resultSetMock.getDouble("price")).thenReturn(40.7);
        when(resultSetMock.getInt("number")).thenReturn(24);
        when(resultSetMock.getString("description")).thenReturn("something");
        when(resultSetMock.getTimestamp("date")).thenReturn(timestamp);

        //when
        Product actual = productRowMapper.mapRow(resultSetMock);

        //then:
        assertEquals(1, actual.getId());
        assertEquals("pie", actual.getName());
        assertEquals(40.7, actual.getPrice());
        assertEquals(24, actual.getNumber());
        assertEquals("something", actual.getDescription());
        assertEquals(localDateTime, actual.getDate());
    }
}
