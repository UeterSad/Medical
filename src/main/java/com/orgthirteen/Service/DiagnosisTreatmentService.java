package com.orgthirteen.Service;

import com.orgthirteen.pojo.DiagnosisTreatment;
import com.orgthirteen.pojo.PageResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DiagnosisTreatmentService {
    PageResult<DiagnosisTreatment> page(Integer page, Integer pageSize, String medicalName);

    DiagnosisTreatment getById(Integer id);

    void save(DiagnosisTreatment diagnosisTreatment);

    void update(DiagnosisTreatment diagnosisTreatment);

    void delete(List<Integer> ids);
}
