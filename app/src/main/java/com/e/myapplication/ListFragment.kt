package com.e.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class ListFragment : Fragment() {
    private lateinit var image: ImageView
    private lateinit var species: TextView
    private lateinit var gender: TextView
    private lateinit var type: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val myview: View = inflater.inflate(R.layout.fragment_list, container, false)
        image = myview.findViewById(R.id.imageView)
        species = myview.findViewById(R.id.textViewSpecie)
        gender = myview.findViewById(R.id.textViewGender)
        type = myview.findViewById(R.id.textViewType)


        return myview

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        species.text = arguments?.getString("species")
        species.text = arguments?.getString("species")
        type.text = arguments?.getString("gender")
        val imageUrl = arguments?.getString("image")
        Picasso.get().load(imageUrl).into(image)



    }

}
