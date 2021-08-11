package com.revature.models;

public enum AccountTypes {
    checkings("checkings"),savings("savings");

    private String type;

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return type;

    }

    public void setType(String type) {
        this.type = type;
    }

    AccountTypes(String type) {
        this.type = type;
    }

    public static AccountTypes getByType(String type){
        for (AccountTypes types: AccountTypes.values()){
            if (types.type.equals(type)){
                return types;
            }
        }
        return checkings;
    }
}
