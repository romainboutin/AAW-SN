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
public enum NotificationTypeEnum {
    FRIEND_REQUEST(0),
    FRIEND_MESSAGE(1),
    FRIEND_QUOTE(2);
    
    private final int _value;

    private NotificationTypeEnum(int value) {
        this._value = value;
    }

    public int getValue() {
        return _value;
    }
}
