package com.orgthirteen.Service;

import com.orgthirteen.pojo.Drugs;
import com.orgthirteen.pojo.PageResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DrugService {
    PageResult<Drugs> page(Integer page, Integer pageSize, String drugName);

    Drugs findById(Integer id);

    void update(Drugs drugs);

    void save(Drugs drugs);

    void delete(List<Integer> id);
}
