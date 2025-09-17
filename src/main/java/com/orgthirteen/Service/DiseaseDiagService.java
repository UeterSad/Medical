package com.orgthirteen.Service;

import com.orgthirteen.pojo.Disease;
import com.orgthirteen.pojo.InpatientDisease;
import com.orgthirteen.pojo.PageResult;
import com.orgthirteen.pojo.RegistrPatient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DiseaseDiagService {
    PageResult<RegistrPatient> find(Integer page, Integer pageSize, String realName);

    List<Disease> findDisease(String diseaseName);

    void addInpatientDisease(InpatientDisease inpatientDisease);
}
