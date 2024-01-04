package com.example.picassoapp_gr1.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.picassoapp_gr1.adapters.FlagAdapter
import com.example.picassoapp_gr1.databinding.FragmentHomeBinding
import com.example.picassoapp_gr1.helpers.Helpers.provideRetrofitInstance
import com.example.picassoapp_gr1.models.FlagParent
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showProgressBar()
        getFlagsFromApi()
    }

    private fun getFlagsFromApi() {
        provideRetrofitInstance().getFlags().enqueue(object : Callback<List<FlagParent>?> {
            override fun onResponse(
                call: Call<List<FlagParent>?>,
                response: Response<List<FlagParent>?>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    val listOfFlagParent = response.body()
                    val listOfFlags = listOfFlagParent?.map { it.flags }
                    val flagAdapter = FlagAdapter(listOfFlags!!)
                    binding.rvFlags.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
                    binding.rvFlags.adapter = flagAdapter

                    flagAdapter.onItemClick = {
                        val action = HomeFragmentDirections.actionNavHomeToHomeDetailsFragment(it.description)
                        findNavController().navigate(action)
                    }
                }
                hideProgressBar()
            }

            override fun onFailure(call: Call<List<FlagParent>?>, t: Throwable) {
                hideProgressBar()
            }
        })
    }

    private fun showProgressBar() {
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        binding.progressBar.visibility = View.GONE
    }

}