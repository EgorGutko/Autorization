package by.egorgutko.autorization.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import by.egorgutko.autorization.R;

public class ForAddFragment extends Fragment implements View.OnClickListener {

    private EditText editText;
    private Button button;
    private NavController navController;
    ForAddActivityPresenter forAddActivityPresenter = new ForAddActivityPresenter();


    //final String SAVED_TEXT = "saved_text";

    //AuthorizationPreferences authorizationPreferences = new AuthorizationPreferences();

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup containre, Bundle saveInstanceState) {

        View view = inflater.inflate(R.layout.fragment_for_add, containre, false);

        //authorizationPreferences.init(getActivity().getApplicationContext());

        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);

        editText = (EditText) view.findViewById(R.id.etext);

        button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(this);

        return view;
    }


   /* public String onLoadNameUser() {
        preferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        String savedText = preferences.getString(SAVED_TEXT, "");
        Toast.makeText(getActivity().getApplicationContext(), savedText, Toast.LENGTH_SHORT).show();

        return savedText;
    }

    public void putSet() {
        preferences = getActivity().getSharedPreferences(onLoadNameUser(), MODE_PRIVATE);
        set= preferences.getStringSet(onLoadNameUser(), new HashSet<String>());
        SharedPreferences.Editor ed = preferences.edit();
        set.add(editText.getText().toString());
        ed.putStringSet(onLoadNameUser(), set);
        ed.commit();
    }
    */


    @Override
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("arg", editText.getText().toString());
        forAddActivityPresenter.putFunc(getActivity().getApplicationContext(),editText.getText().toString());
        //authorizationPreferences.putSet(editText.getText().toString());
       //putSet();
        //navController.navigate(R.id.action_forAddFragment_to_listFragment,bundle);
        //navController.navigate(R.id.listFragment);
        navController.popBackStack();
        //navController.navigate(R.id.listFragment, bundle);
        //Intent intent = new Intent(getActivity(),)
    }
}
