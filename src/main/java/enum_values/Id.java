package enum_values;

public enum Id {

    STUDENT_ID(100000, 999999),
    LECTURER_ID(100, 999),
    MAJOR_ID(1,9),
    SUBJECT_ID(10,99);

    private Integer minId;
    private Integer maxId;

    Id(int minId, int maxId){
        this.minId = minId;
        this.maxId = maxId;
    }

    public Integer getMinId() {
        return minId;
    }

    public Integer getMaxId() {
        return maxId;
    }
}
