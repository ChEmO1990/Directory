package com.communitytax.directory.ui;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.arlib.floatingsearchview.FloatingSearchView;
import com.arlib.floatingsearchview.suggestions.model.SearchSuggestion;
import com.communitytax.directory.R;
import com.communitytax.directory.http.CommunityTaxRestClient;
import com.communitytax.directory.models.Datum;
import com.communitytax.directory.models.EmployeeResponse;
import com.google.gson.Gson;
import com.loopj.android.http.TextHttpResponseHandler;
import java.util.ArrayList;
import cz.msebera.android.httpclient.Header;

public class EmployeeFragment extends Fragment {
    public static ArrayList<Datum> items = null;
    private RecyclerView recyclerView = null;
    private FloatingSearchView mSearchView;
    private OnListFragmentInteractionListener mListener;
    private MyEmployeeRecyclerViewAdapter mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public EmployeeFragment() {}

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static EmployeeFragment newInstance() {
        EmployeeFragment fragment = new EmployeeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_employee_list, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration( new DividerItemDecoration(getActivity(), 1));
        recyclerView.setNestedScrollingEnabled(false);

        mSearchView = (FloatingSearchView) rootView.findViewById(R.id.floating_search_view);

        CommunityTaxRestClient.get("employees", null, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                EmployeeResponse jsonObject = new Gson().fromJson(responseString, EmployeeResponse.class);
                items = new ArrayList<>();
                items.addAll(jsonObject.getData());
                mAdapter = new MyEmployeeRecyclerViewAdapter(items, mListener);
                recyclerView.setAdapter(mAdapter);
            }
        });

        mSearchView.setOnSearchListener(new FloatingSearchView.OnSearchListener() {
            @Override
            public void onSuggestionClicked(SearchSuggestion searchSuggestion) {

            }

            @Override
            public void onSearchAction(String currentQuery) {
                mAdapter.filter(currentQuery);
            }
        });

        mSearchView.setOnQueryChangeListener(new FloatingSearchView.OnQueryChangeListener() {
            @Override
            public void onSearchTextChanged(String oldQuery, String newQuery) {
                if( newQuery.length() == 0 ) {
                    mAdapter.filter("");
                }
            }
        });

        return rootView;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(Datum item);
    }
}
