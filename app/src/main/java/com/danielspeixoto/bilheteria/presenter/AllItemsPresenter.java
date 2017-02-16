package com.danielspeixoto.bilheteria.presenter;

import com.danielspeixoto.bilheteria.model.CRUDItems;
import com.danielspeixoto.bilheteria.model.pojo.ItemInfo;
import com.danielspeixoto.bilheteria.module.Source;

import rx.Subscriber;

/**
 * Created by danielspeixoto on 2/15/17.
 */

public class AllItemsPresenter implements Source.Presenter {

    private Source.View<ItemInfo> mView;

    public AllItemsPresenter(Source.View<ItemInfo> view) {
        mView = view;
    }

    @Override
    public void getItems() {
        CRUDItems.getAll().subscribe(new Subscriber<ItemInfo>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                mView.getActivity().showMessage(e.getMessage());
            }

            @Override
            public void onNext(ItemInfo paymentInfo) {
                mView.addItem(paymentInfo);
            }
        });
    }
}