package com.revature.models;

public enum AccountTypes {
    CHECKING("checking"),SAVINGS("savings");

    private String type;


    AccountTypes(String type) {
        this.type = type;
    }
    public static AccountTypes getByType(String type){
        for (AccountTypes types: AccountTypes.values()){
            if (types.type.equals(type)){
                return types;
            }
        }
        return CHECKING;
    }
}
