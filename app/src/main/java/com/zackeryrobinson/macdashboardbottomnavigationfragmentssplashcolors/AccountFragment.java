package com.zackeryrobinson.macdashboardbottomnavigationfragmentssplashcolors;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;

import static com.zackeryrobinson.macdashboardbottomnavigationfragmentssplashcolors.R.drawable.ic_chevron_right_black_24dp;
import static com.zackeryrobinson.macdashboardbottomnavigationfragmentssplashcolors.R.drawable.ic_expand_more_black_24dp;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AccountFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class AccountFragment extends Fragment implements  PayFragment.OnFragmentInteractionListener, View.OnClickListener{

    private OnFragmentInteractionListener mListener;
    ConstraintLayout clLodging;
    ScrollView svLodging;
    ImageView ivLodgingChevron;
    CardView cvLodging;

    ConstraintLayout clAccounts;
    ScrollView svAccounts;
    ImageView ivAccountsChevron;
    CardView cvAccounts;



    ConstraintLayout clContacts;
    ScrollView svContacts;
    ImageView ivContactsChevron;
    CardView cvContacts;


    private boolean tabOpen;

    public AccountFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_account, container, false);
        clContacts = (ConstraintLayout) rootView.findViewById(R.id.clContacts);
        svContacts = (ScrollView) rootView.findViewById(R.id.svContacts);
        ivContactsChevron = (ImageView) rootView.findViewById(R.id.ivContactsChevron);
        cvContacts = (CardView) rootView.findViewById(R.id.cvContact);


        clAccounts = (ConstraintLayout) rootView.findViewById(R.id.clAccount);
        svAccounts = (ScrollView) rootView.findViewById(R.id.svAccounts);
        ivAccountsChevron = (ImageView) rootView.findViewById(R.id.ivAccountChevron);
        cvAccounts = (CardView) rootView.findViewById(R.id.cvAccount);



        clLodging = (ConstraintLayout) rootView.findViewById(R.id.clLodging);
        svLodging = (ScrollView) rootView.findViewById(R.id.svLodging);
        ivLodgingChevron = (ImageView) rootView.findViewById(R.id.ivLodgingChevron);
        cvLodging = (CardView) rootView.findViewById(R.id.cvLodging);


        clContacts.setOnClickListener(this);
        clAccounts.setOnClickListener(this);
        clLodging.setOnClickListener(this);
        tabOpen=false;
        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {

        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.clContacts:
                openContacts();
                break;
            case R.id.clAccount:
                openAccount();
                break;
            case R.id.clLodging:
                openLodging();
                break;
        }
    }


    private void openContacts(){
        if(tabOpen == false) {
            svContacts.setVisibility(View.VISIBLE);
            ivContactsChevron.setImageDrawable(ContextCompat.getDrawable(getContext(), ic_expand_more_black_24dp));
            cvAccounts.setVisibility(View.GONE);
            cvLodging.setVisibility(View.GONE);
            tabOpen = true;
        }else{
            svContacts.setVisibility(View.GONE);
            ivContactsChevron.setImageDrawable(ContextCompat.getDrawable(getContext(),ic_chevron_right_black_24dp));
            cvAccounts.setVisibility(View.VISIBLE);
            cvLodging.setVisibility(View.VISIBLE);
            tabOpen = false;
        }
    }

    private void openLodging(){
        if(tabOpen == false) {
            svLodging.setVisibility(View.VISIBLE);
            ivLodgingChevron.setImageDrawable(ContextCompat.getDrawable(getContext(), ic_expand_more_black_24dp));
            cvAccounts.setVisibility(View.GONE);
            cvContacts.setVisibility(View.GONE);
            tabOpen = true;
        }else{
            svLodging.setVisibility(View.GONE);
            ivLodgingChevron.setImageDrawable(ContextCompat.getDrawable(getContext(),ic_chevron_right_black_24dp));
            cvAccounts.setVisibility(View.VISIBLE);
            cvContacts.setVisibility(View.VISIBLE);
            tabOpen = false;
        }
    }

    private void openAccount() {
        if (tabOpen == false) {
            svAccounts.setVisibility(View.VISIBLE);
            ivAccountsChevron.setImageDrawable(ContextCompat.getDrawable(getContext(), ic_expand_more_black_24dp));
            cvLodging.setVisibility(View.GONE);
            cvContacts.setVisibility(View.GONE);
            tabOpen = true;
        } else {
            svAccounts.setVisibility(View.GONE);
            ivAccountsChevron.setImageDrawable(ContextCompat.getDrawable(getContext(), ic_chevron_right_black_24dp));
            cvLodging.setVisibility(View.VISIBLE);
            cvContacts.setVisibility(View.VISIBLE);
            tabOpen = false;
        }
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}

