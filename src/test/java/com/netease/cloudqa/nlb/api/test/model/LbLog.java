package com.netease.cloudqa.nlb.api.test.model;

public class LbLog {
    public static class Data {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Data data = (Data) o;

            return name != null ? name.equals(data.name) : data.name == null;
        }

        @Override
        public int hashCode() {
            return name != null ? name.hashCode() : 0;
        }
    }

    private long timestamp;
    private String ssn;
    private String ssnId;
    private String comment;
    private String operation;
    private Data data;

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getSsnId() {
        return ssnId;
    }

    public void setSsnId(String ssnId) {
        this.ssnId = ssnId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LbLog lbLog = (LbLog) o;

        if (timestamp != lbLog.timestamp) return false;
        if (ssn != null ? !ssn.equals(lbLog.ssn) : lbLog.ssn != null) return false;
        if (ssnId != null ? !ssnId.equals(lbLog.ssnId) : lbLog.ssnId != null) return false;
        if (comment != null ? !comment.equals(lbLog.comment) : lbLog.comment != null) return false;
        if (operation != null ? !operation.equals(lbLog.operation) : lbLog.operation != null) return false;
        return data != null ? data.equals(lbLog.data) : lbLog.data == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (timestamp ^ (timestamp >>> 32));
        result = 31 * result + (ssn != null ? ssn.hashCode() : 0);
        result = 31 * result + (ssnId != null ? ssnId.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (operation != null ? operation.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }
}
