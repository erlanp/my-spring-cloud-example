package cn.cloud.square.first.dto;

import java.util.List;
import cn.cloud.round.first.dto.Park;

public class ParkListResponse {
    private int code;
    private String msg;
    private Data data;

    public ParkListResponse(int code, String msg, List<Park> parkList) {
        this.code = code;
        this.msg = msg;
        this.data = new Data(parkList);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    private class Data {
        private int total;
        private List<Park> rows;

        public Data(List<Park> rows) {
            this.rows = rows;
            this.total = rows.size();
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<Park> getRows() {
            return rows;
        }

        public void setRows(List<Park> rows) {
            this.rows = rows;
        }
    }
}
