package com.example.assessment_4662576_and_4645639

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.assessment_4662576_and_4645639.app_database.AppDatabase
import com.example.assessment_4662576_and_4645639.databinding.FragmentCheckCarBinding



class CheckCarFragment : Fragment() {


    private var _binding: FragmentCheckCarBinding? = null


    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCheckCarBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.checkCarInterfaceCheckCarButton.setOnClickListener {
            val carBrand = binding.checkCarInterfaceBrandInput.text.toString()
            val carModel = binding.checkCarInterfaceModelInput.text.toString()


            if(carBrand != "" && carModel != ""){
                val db = AppDatabase.getAppDatabase()
                val carDao = db!!.carDao()
                val price = carDao.loadById(carBrand,carModel)
                if(price != null) {
                    binding.checkCarInterfaceCarPriceInput.setText(price)
                }else{
                    Toast.makeText(view.context,"Not found this type of car.", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(view.context,"Data has not been added(car brand and car model.", Toast.LENGTH_SHORT).show()
            }
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}