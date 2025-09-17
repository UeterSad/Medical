package com.orgthirteen.Service;

import com.orgthirteen.pojo.HospReimburse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HospReimburseService {
    List<HospReimburse> findByLevel(String level);


    void savelevel(HospReimburse hospReimburse);


    void updatelevel(HospReimburse hospReimburse);


    void delete(Integer id);

}
