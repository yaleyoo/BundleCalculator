package model;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private List<ResultItem> resultItemList;

    public Result(){
        resultItemList = new ArrayList<>();
    }

    public void add(ResultItem item){
        this.resultItemList.add(item);
    }

    public List<ResultItem> getResultItemList() {
        return resultItemList;
    }

    public void setResultItemList(List<ResultItem> resultItemList) {
        this.resultItemList = resultItemList;
    }
}
