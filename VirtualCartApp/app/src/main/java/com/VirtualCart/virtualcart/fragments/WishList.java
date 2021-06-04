package com.VirtualCart.virtualcart.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.VirtualCart.virtualcart.R;
import com.VirtualCart.virtualcart.adapters.WishlistAdapter;
import com.VirtualCart.virtualcart.database.DB_Handler;
import com.VirtualCart.virtualcart.database.SessionManager;
import com.VirtualCart.virtualcart.pojo.Product;
import com.VirtualCart.virtualcart.utils.Constants;

import java.util.List;


public class WishList extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.listview, container, false);

        // get data
        DB_Handler db_handler = new DB_Handler(getActivity());
        SessionManager sessionManager = new SessionManager(getActivity());
        List<Product> productList = db_handler.getShortListedItems(sessionManager.getSessionData(Constants.SESSION_EMAIL));

        // fill listview with data
        ListView listView= view.findViewById(R.id.listview);
        listView.setAdapter(new WishlistAdapter(getActivity(), productList));
        return view;
    }
}
