package com.SenjaMalaka.senjamalakareservation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Menu_PemesananFragment : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_menupemesanan, container, false)

        // Sample data
        val makananList = listOf(
            Triple("Nasi Goreng", "Rp. 15.000", "Nasi goreng dengan telur"),
            Triple("Mie Goreng", "Rp. 12.000", "Mie goreng dengan sayuran"),
            Triple("Ayam Goreng", "Rp. 20.000", "Ayam goreng tepung")
        )

        val minumanList = listOf(
            Triple("Es Teh", "Rp. 5.000", "Teh manis dingin"),
            Triple("Kopi", "Rp. 10.000", "Kopi hitam hangat"),
            Triple("Jus Jeruk", "Rp. 8.000", "Jus jeruk segar")
        )

        // Populate makanan
        makananList.forEachIndexed { index, makanan ->
            val makananView = view.findViewById<View>(resources.getIdentifier("makanan_$index", "id", context?.packageName))
            makananView?.findViewById<TextView>(R.id.Pesanan_NamaMakanan)?.text = makanan.first
            makananView?.findViewById<TextView>(R.id.Pesanan_HargaMakanan)?.text = makanan.second
            makananView?.findViewById<TextView>(R.id.Pesanan_DeskripsiMakanan)?.text = makanan.third
        }

        // Populate minuman
        minumanList.forEachIndexed { index, minuman ->
            val minumanView = view.findViewById<View>(resources.getIdentifier("minuman_$index", "id", context?.packageName))
            minumanView?.findViewById<TextView>(R.id.Pesanan_NamaMinuman)?.text = minuman.first
            minumanView?.findViewById<TextView>(R.id.Pesanan_HargaMinuman)?.text = minuman.second
            minumanView?.findViewById<TextView>(R.id.Pesanan_DeskripsiMinuman)?.text = minuman.third
        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Menu_PemesananFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
