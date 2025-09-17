package com.orgthirteen.Service.Impl;

import com.orgthirteen.Mapper.HospReimburseMapper;
import com.orgthirteen.Service.HospReimburseService;
import com.orgthirteen.pojo.HospReimburse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospReimburseServiceImpl implements HospReimburseService {
    @Autowired
    private HospReimburseMapper hospReimburseMapper;
    @Override
    public List<HospReimburse> findByLevel(String level) {
        List<HospReimburse> hospReimburses = hospReimburseMapper.findByLevel(level);
        return hospReimburses;
    }

    @Override
    public void savelevel(HospReimburse hospReimburse) {
        hospReimburseMapper.save(hospReimburse);
    }

    @Override
    public void updatelevel(HospReimburse hospReimburse) {
        hospReimburseMapper.update(hospReimburse);
    }


    @Override
    public void delete(Integer id) {
        hospReimburseMapper.delete(id);
    }


}
