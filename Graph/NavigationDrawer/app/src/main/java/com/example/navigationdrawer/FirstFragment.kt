package com.example.navigationdrawer

import android.app.ActionBar
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.EditText
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.BarGraphSeries
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.DataPointInterface
import com.jjoe64.graphview.series.LineGraphSeries
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment() {
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
        // Inflate the layout for this fragment

        var view: View = inflater.inflate(R.layout.fragment_first, container, false)

        var dbHelper : DBHelper = DBHelper(view.context)

        //dbHelper.deleteAllData()

        var number : Int = dbHelper.showNumberData()
        var number_salt : Int = dbHelper.showNumberDataSalt()
        var number_pepper : Int = dbHelper.showNumberDataPepper()

        Log.d("DEBUG123", "$number $number_salt $number_pepper")

        var barGraphSeries : BarGraphSeries<DataPointInterface> = BarGraphSeries<DataPointInterface>(arrayOf<DataPoint>(DataPoint(1.0, number_salt.toDouble()), DataPoint(2.0, number_pepper.toDouble())))

        var max : Int = if(number == 0) 1 else number

        ((view.findViewById<View>(R.id.Graph)) as GraphView).viewport.isXAxisBoundsManual = true
        ((view.findViewById<View>(R.id.Graph)) as GraphView).viewport.isYAxisBoundsManual = true

        ((view.findViewById<View>(R.id.Graph)) as GraphView).title = "The ratio of bags of salt and pepper in the warehouse"
        ((view.findViewById<View>(R.id.Graph)) as GraphView).viewport.setMaxY(max.toDouble())
        ((view.findViewById<View>(R.id.Graph)) as GraphView).viewport.setMinY(1.0)
        ((view.findViewById<View>(R.id.Graph)) as GraphView).viewport.setMinX(1.0)
        ((view.findViewById<View>(R.id.Graph)) as GraphView).viewport.setMaxX(2.0)
        //((view.findViewById<View>(R.id.Graph)) as GraphView).gridLabelRenderer.setHumanRounding(false, false)
        ((view.findViewById<View>(R.id.Graph)) as GraphView).gridLabelRenderer.numHorizontalLabels = 2
        //((view.findViewById<View>(R.id.Graph)) as GraphView).gridLabelRenderer.numVerticalLabels = max
        //((view.findViewById<View>(R.id.Graph)) as GraphView)

        //((view.findViewById<View>(R.id.Linear)) as LinearLayout).layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, if(max > 10) 1F else (max / 10).toFloat())

        ((view.findViewById<View>(R.id.Graph)) as GraphView).addSeries(barGraphSeries)

        return view
    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FirstFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FirstFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}