package com.danielspeixoto.ticket.module;

/**
 * Created by danielspeixoto on 2/18/17.
 */

public interface OnItemChanged<T> {

    void onItemChanged(T valueChanged);
}