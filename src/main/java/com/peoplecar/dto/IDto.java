package com.peoplecar.dto;

import com.peoplecar.domain.Model;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 11/11/12
 * Time: 5:43 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IDto<T extends Model> {

    public T toModel();

}
