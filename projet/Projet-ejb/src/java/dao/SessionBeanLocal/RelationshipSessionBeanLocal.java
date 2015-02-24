/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.SessionBeanLocal;

import dao.entity.RelationshipEntity;
import javax.ejb.Local;

/**
 *
 * @author William
 */
@Local
public interface RelationshipSessionBeanLocal {
    public void save(RelationshipEntity r);
    public void update(RelationshipEntity r);
    public void delete(RelationshipEntity r);
}
