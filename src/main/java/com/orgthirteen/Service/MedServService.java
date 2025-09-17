package com.orgthirteen.Service;

import com.orgthirteen.pojo.MedServ;
import com.orgthirteen.pojo.PageResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MedServService {
    PageResult<MedServ> page(Integer page, Integer pageSize, String medicalName);

    MedServ getById(Integer id);

    void save(MedServ medServ);

    void update(MedServ medServ);

    void delete(List<Integer> id);
}
