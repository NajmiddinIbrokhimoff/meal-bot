package uz.ibrokhimoff.meal.enums;

public enum Department {
    SELLS,
    ACADEMIC,
    KIDS,
    ENGLISH,
    ECMA,
    HOUSE_HOLD,
    UNDEFINED;

    public static Department getByOrder(int departmentOrder) {
        for (Department department : values()) {
            if (department.ordinal() == departmentOrder)
                return department;
        }
        return Department.UNDEFINED;
    }
}
