package com.orgthirteen.Service;

import com.orgthirteen.pojo.DrugReimburse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DrugReimburseService {
    List<DrugReimburse> findAll();

    void save(DrugReimburse drugReimburse);

    void update(DrugReimburse drugReimburse);

    void delete(Integer id);
}
