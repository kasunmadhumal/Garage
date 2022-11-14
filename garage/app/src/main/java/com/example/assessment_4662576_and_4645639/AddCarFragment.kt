package com.example.assessment_4662576_and_4645639

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.assessment_4662576_and_4645639.app_database.AppDatabase
import com.example.assessment_4662576_and_4645639.data_entity.Car
import com.example.assessment_4662576_and_4645639.databinding.FragmentSecondBinding


class AddCarFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null


    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.addInterfaceAddCarButton.setOnClickListener {
            val carBrand = binding.addCarInterfaceBrandInput.text.toString()
            val carModel = binding.addCarInterfaceModelInput.text.toString()
            val carPrice = binding.addCarInterfaceCarPriceInput.text.toString()

            if(carBrand != "" && carModel != "" && carPrice != ""){
                val db = AppDatabase.getAppDatabase()
                val carDao = db!!.carDao()
                val car = Car(null,carBrand,carModel,carPrice)
                carDao.insertAll(car)
                Toast.makeText(view.context,"Car has been added successfully.",Toast.LENGTH_SHORT).show()
                binding.addCarInterfaceBrandInput.setText("")
                binding.addCarInterfaceModelInput.setText("")
                binding.addCarInterfaceCarPriceInput.setText("")

            }else{
                Toast.makeText(view.context,"Data has not been added.",Toast.LENGTH_SHORT).show()
            }
        }



    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}