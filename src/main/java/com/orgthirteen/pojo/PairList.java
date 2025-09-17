package com.orgthirteen.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class PairList<T, U> {

    private List<T> xList;


    private List<U> yList;

    public PairList(List<T> xList, List<U> yList) {
        this.xList = xList;
        this.yList = yList;
    }
}
