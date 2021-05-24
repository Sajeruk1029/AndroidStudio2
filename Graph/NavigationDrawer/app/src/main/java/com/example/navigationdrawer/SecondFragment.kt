package com.example.navigationdrawer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.VerifiedInputEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_second.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SecondFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View = inflater.inflate(R.layout.fragment_second, container, false)

        ((view.findViewById<View>(R.id.ButAdd)) as Button).setOnClickListener {
            var dbHelper : DBHelper = DBHelper(view.context)

            if(((view.findViewById<View>(R.id.Number)) as EditText).text.toString() == "")
            {
                return@setOnClickListener
            }

            if(((view.findViewById<View>(R.id.Number)) as EditText).text.toString().toInt() == 0)
            {
                return@setOnClickListener
            }

            dbHelper.addData(ModelData(((view.findViewById<View>(R.id.Number)) as EditText).text.toString().toInt(), ((view.findViewById<View>(R.id.Type)) as Spinner).selectedItemPosition))
        }

        ((view.findViewById<View>(R.id.ButDelete)) as Button).setOnClickListener {
            var dbHelper : DBHelper = DBHelper(view.context)

            dbHelper.deleteAllData()
        }

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SecondFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SecondFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}