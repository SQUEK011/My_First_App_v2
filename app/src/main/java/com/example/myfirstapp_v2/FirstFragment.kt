package com.example.myfirstapp_v2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.myfirstapp_v2.databinding.FragmentFirstBinding
import com.example.myfirstapp_v2.model.CountViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    //Binding object instance corresponds to fragment_first.xml
    private var binding: FragmentFirstBinding? = null

    //Set up shared view model
    private val sharedViewModel: CountViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = FragmentFirstBinding.inflate(inflater,container,false)
        binding = fragmentBinding
        return fragmentBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            viewModel = sharedViewModel
            lifecycleOwner = viewLifecycleOwner
            firstFragment = this@FirstFragment
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    /**
     * Increment count after every count click
     */
    fun countMe(count: Int){
        //Display the new value in the text view
        sharedViewModel.setCount(count)
    }

    /**
     * Generate a random number and navigate to Random (Second Fragment)
     */
    fun goToRandom(count: Int) {

        sharedViewModel.setRandomNumber(count)
        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
    }

    /**
     * Create Toast Message
     */
    fun toastMessage(){
        Toast.makeText(context, resources.getString(R.string.toast_msg), Toast.LENGTH_SHORT).show()
    }
}