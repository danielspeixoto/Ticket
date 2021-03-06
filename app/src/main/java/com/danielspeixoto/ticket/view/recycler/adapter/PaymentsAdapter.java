package com.danielspeixoto.ticket.view.recycler.adapter;

import android.view.ViewGroup;

import com.danielspeixoto.ticket.model.pojo.Payment;
import com.danielspeixoto.ticket.module.Source;
import com.danielspeixoto.ticket.view.activity.BaseActivity;
import com.danielspeixoto.ticket.view.recycler.holder.PaymentHolder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Created by danielspeixoto on 2/15/17.
 */

public abstract class PaymentsAdapter<S extends PaymentHolder<? extends PaymentsAdapter>>
        extends SourceAdapter<Payment, S, Source.Presenter> {

    public PaymentsAdapter(BaseActivity activity) {
        super(activity);
    }

    public abstract S onCreateViewHolder(ViewGroup parent, int viewType);

    @Override
    public void reset() {
        Iterator<Payment> iterator = getIterator();
        while(iterator.hasNext()) {
            iterator.next().setAmount(0);
        }
    }

    public List<Payment> getNotZero() {
        List<Payment> list = new ArrayList<Payment>();
        Iterator<Payment> iterator = getIterator();
        while(iterator.hasNext()) {
            Payment payment = iterator.next();
            if(payment.getAmount() != 0) {
                list.add(payment);
            }
        }
        return list;
    }
}
