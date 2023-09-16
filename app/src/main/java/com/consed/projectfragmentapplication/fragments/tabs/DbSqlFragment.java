package com.consed.projectfragmentapplication.fragments.tabs;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.consed.projectfragmentapplication.DB_Sql.DB;
import com.consed.projectfragmentapplication.DB_Sql.Val;
import com.consed.projectfragmentapplication.DB_Sql.ValAdapter;
import com.consed.projectfragmentapplication.databinding.FragmentSqlBinding;
import com.consed.projectfragmentapplication.interfaces.OnClickDelete;
import java.util.ArrayList;
import java.util.List;

public class DbSqlFragment extends Fragment {

    private FragmentSqlBinding binding;
    private DB db;
    private ValAdapter adapter;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        db = new DB(context);
    }



    public DbSqlFragment() {
        // Required empty public constructor
    }


    public static DbSqlFragment newInstance() {
        DbSqlFragment fragment = new DbSqlFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        binding = FragmentSqlBinding.inflate(inflater, container, false);

        All();
        return binding.getRoot();

    }


    private List<Val> GetList(){
        db.openDB();
        ArrayList<Val> valArrayList = db.SelectData();
        db.closeDB();
        return valArrayList;
    }
    private void All() {

        Insert();
        Select();
//        Delete();
    }

    private void Delete() {
        db.openDB();
        adapter = new ValAdapter(new OnClickDelete() {
            @Override
            public void onClick(int position) {


                db.deleteData(position);
                adapter.removeItem(position);


            }
        });
        binding.rv.setAdapter(adapter);
        binding.rv.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rv.setHasFixedSize(true);
        db.closeDB();

    }


    private void Select() {
        db.openDB();
        ArrayList<Val> valArrayList = db.SelectData();
        adapter = new ValAdapter(valArrayList);

        binding.rv.setAdapter(adapter);
        binding.rv.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rv.setHasFixedSize(true);
        db.closeDB();

    }

    private void Insert() {
        binding.button.setOnClickListener(view -> {

            if (!binding.editTextAge.getText().toString().isEmpty() && !binding.editTextName.getText().toString().isEmpty()) {

                db.openDB();
                Val val = new Val(binding.editTextName.getText().toString(), Integer.parseInt(binding.editTextAge.getText().toString()));
                db.insertData(val);
//                adapter.notifyItemInserted();
                Select();
                db.closeDB();
                Toast.makeText(getActivity(), "تم الحفظ", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "قم بتعبة البيانات", Toast.LENGTH_SHORT).show();
            }


        });
    }




//    public void UpdateContact(Contact contact) {
//        sql_db.execSQL("update contacts set name='" + contact.getName() + "', phone='" + contact.getPhone() + "',mobile='" + contact.getMobile() + "' where id = " + contact.getId());
//    }
//
//    public void DeleteContact(int id) {
//        sql_db.execSQL("delete from contacts where id =" + id);
//    }
//
//
//    public ArrayList<Contact> selectContacts() {
//        ArrayList<Contact> allContacts = new ArrayList<>();
//
//        Cursor C = sql_db.rawQuery("select * from contacts", null);
//
//        while (C.moveToNext()) {
//            int id = C.getInt(0);
//            String name = C.getString(1);
//            String phone = C.getString(2);
//            String mobile = C.getString(3);
//            allContacts.add(new Contact(id, name, phone, mobile));
//        }
//
//        return allContacts;
//    }
//
//    public ArrayList<Contact> selectContacts2() {
//        ArrayList<Contact> allContacts = new ArrayList<>();
//
//        Cursor C = sql_db.rawQuery("select * from contacts where phone > 50", null);
//
//        while (C.moveToNext()) {
//            int id = C.getInt(0);
//            String name = C.getString(1);
//            String phone = C.getString(2);
//            String mobile = C.getString(3);
//            allContacts.add(new Contact(id, name, phone, mobile));
//        }
//
//        return allContacts;
//    }
//
//    public ArrayList<Contact> selectContacts3() {
//        ArrayList<Contact> allContacts = new ArrayList<>();
//
//        Cursor C = sql_db.rawQuery("select * from contacts where phone <= 50", null);
//
//        while (C.moveToNext()) {
//            int id = C.getInt(0);
//            String name = C.getString(1);
//            String phone = C.getString(2);
//            String mobile = C.getString(3);
//            allContacts.add(new Contact(id, name, phone, mobile));
//        }
//
//        return allContacts;
//    }



}