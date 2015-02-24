/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Romain Boutin & William Le Coroller
 */
public enum RelationshipStatusEnum {
    PENDING(0),
    ACCEPTED(1),
    DECLINED(2),
    BLOCKED(3);
    
    private final int value;

    private RelationshipStatusEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
