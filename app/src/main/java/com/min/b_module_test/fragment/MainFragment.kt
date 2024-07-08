package com.min.b_module_test.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.min.b_module_test.R
import com.min.b_module_test.adapter.OneCarItemAdapter
import com.min.b_module_test.adapter.TwoCarItemAdapter
import com.min.b_module_test.enity.OneCar
import com.min.b_module_test.enity.TwoCar

class MainFragment : Fragment() {

    private lateinit var oneRecyclerView: RecyclerView
    private lateinit var twoRecyclerView: RecyclerView
    private lateinit var oneCarAdapter: OneCarItemAdapter
    private lateinit var twoCarAdapter: TwoCarItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        oneRecyclerView = view.findViewById(R.id.main_rl_item)
        twoRecyclerView = view.findViewById(R.id.main_rl_bot)

        //设置布局管理器为横向
        oneRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        twoRecyclerView.layoutManager =
            GridLayoutManager(requireContext(), 2)


        //模拟一些数据
        val oneCarList = listOf(
            OneCar(
                "BMW X4 Sports",
                4.5,
                "2019 · COMFORT CLASS",
                5,
                4,
                3,
                R.drawable.bmw_car_img,
                "$210"
            ),
            OneCar(
                "BMW X4 Sports",
                4.5,
                "2019 · COMFORT CLASS",
                5,
                4,
                3,
                R.drawable.bmw_car_img_red,
                "$210"
            ),
            OneCar(
                "BMW X4 Sports",
                4.5,
                "2019 · COMFORT CLASS",
                5,
                4,
                3,
                R.drawable.bmw_car_img_sliver,
                "$210"
            ),
            OneCar(
                "BMW X4 Sports",
                4.5,
                "2019 · COMFORT CLASS",
                5,
                4,
                3,
                R.drawable.bmw_car_img_black,
                "$210"
            )
        )

        val twoCarList = listOf(
            TwoCar(
                R.drawable.bmw_m5_img,
                R.drawable.bmw_user_img,
                "200/day",
                "BMW M5 G-Power",
                "Tel-Aviv, Israel",
            ),
            TwoCar(
                R.drawable.bmw_m5_img,
                R.drawable.bmw_user_img,
                "200/day",
                "BMW M5 G-Power",
                "Tel-Aviv, Israel",
            ),
            TwoCar(
                R.drawable.bmw_m5_img,
                R.drawable.bmw_user_img,
                "200/day",
                "BMW M5 G-Power",
                "Tel-Aviv, Israel",
            ),
            TwoCar(
                R.drawable.bmw_m5_img,
                R.drawable.bmw_user_img,
                "200/day",
                "BMW M5 G-Power",
                "Tel-Aviv, Israel",
            )
        )

        oneCarAdapter = OneCarItemAdapter(oneCarList)
        oneRecyclerView.adapter = oneCarAdapter

        twoCarAdapter = TwoCarItemAdapter(twoCarList)
        twoRecyclerView.adapter = twoCarAdapter


    }
}