package com.SenjaMalaka.senjamalakareservation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

private const val ARG_ORDER_SUMMARY = "order_summary"
private const val ARG_TOTAL_PRICE = "total_price"

class Menu_PemesananPaymentFragment : Fragment() {
    private var orderSummary: String? = null
    private var totalPrice: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            orderSummary = it.getString(ARG_ORDER_SUMMARY)
            totalPrice = it.getInt(ARG_TOTAL_PRICE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_menupemesanan_payment, container, false)

        val tvOrderSummary = view.findViewById<TextView>(R.id.tv_order_summary)
        val llOrderItems = view.findViewById<ViewGroup>(R.id.ll_order_items)
        val tvTotalPrice = view.findViewById<TextView>(R.id.tv_total_price)

        // Populate order summary
        orderSummary?.split("\n")?.forEach { item ->
            val textView = TextView(context)
            textView.text = item
            llOrderItems.addView(textView)
        }

        // Populate total price
        tvTotalPrice.text = "Total Price: Rp. $totalPrice"

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(orderSummary: String, totalPrice: Int) =
            Menu_PemesananPaymentFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_ORDER_SUMMARY, orderSummary)
                    putInt(ARG_TOTAL_PRICE, totalPrice)
                }
            }
    }
}
