package com.orgthirteen.Mapper;

import com.orgthirteen.pojo.OrderBase;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MedOrderMapper {
    void add(OrderBase orderBase);
}
