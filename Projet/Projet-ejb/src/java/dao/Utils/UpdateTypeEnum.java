/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Utils;

/**
 *
 * @author William
 */
public enum UpdateTypeEnum {
    PENDING(0);
    
    private final int _value;

    private UpdateTypeEnum(int value) {
        this._value = value;
    }

    public int getValue() {
        return _value;
    }
}
