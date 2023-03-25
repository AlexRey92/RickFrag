package com.e.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import java.io.FileDescriptor
import java.io.PrintWriter

class ListFragment : Fragment() {
    private lateinit var image:ImageView
    private lateinit var species:TextView
    private lateinit var gender:TextView
    private lateinit var type:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
val myview:View= inflater.inflate(R.layout.fragment_list, container, false)
        image=myview.findViewById(R.id.imageView)
        species=myview.findViewById(R.id.textViewSpecie)
        gender=myview.findViewById(R.id.textViewGender)
        type=myview.findViewById(R.id.textViewType)


        return myview
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val args= this.arguments
        val bb=  args
        gender.text= bb?.getBundle("gender").toString()
        species.text=bb?.getString("species")
        type.text=bb?.getString("gender")
        val imageUrl=bb?.getString("image")
       Picasso.get().load(imageUrl).into(image)


        super.onViewCreated(view, savedInstanceState)
    }




}