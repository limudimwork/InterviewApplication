package com.boriskunda.interviewapplication.ui.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.boriskunda.interviewapplication.R
import com.boriskunda.interviewapplication.ui.fragments.MovieDetailsFragment
import com.boriskunda.interviewapplication.ui.fragments.MoviesListFragment
import com.boriskunda.interviewapplication.viewmodel.SharedViewModel

class MainActivity : AppCompatActivity() {

    private val sharedViewModel: SharedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_ll)

        replaceFr(MoviesListFragment())
        observeViewModel(sharedViewModel)


    }

    private fun observeViewModel(sharedVM:SharedViewModel) {

        sharedVM.openDetailsScreenLD.observe(this, Observer {
            replaceFrWithBackStack(MovieDetailsFragment())
        })

    }

    private fun replaceFr(fr: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fr_container, fr).commit()
    }

    private fun replaceFrWithBackStack(fr: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fr_container, fr)
            .addToBackStack(null).commit()
    }

}