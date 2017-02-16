package com.danielspeixoto.bilheteria.presenter;

import com.danielspeixoto.bilheteria.model.CRUDPayments;
import com.danielspeixoto.bilheteria.model.pojo.PaymentInfo;
import com.danielspeixoto.bilheteria.module.InsertPayment;
import com.danielspeixoto.bilheteria.util.Validate;

/**
 * Created by danielspeixoto on 2/15/17.
 */

public class InsertPaymentPresenter implements InsertPayment.Presenter {

    private InsertPayment.View mView;

    public InsertPaymentPresenter(InsertPayment.View view) {
        mView = view;
    }

    @Override
    public void insert(PaymentInfo payment) {
        String result = Validate.Payment(payment);
        if (result.equals(Validate.OK)) {
            CRUDPayments.insertPayment(payment);
            result = "Payment has been added";
            mView.clear();
        }
        mView.getActivity().showMessage(result);
    }
}
