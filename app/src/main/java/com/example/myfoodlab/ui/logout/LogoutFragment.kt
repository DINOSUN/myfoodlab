package com.example.myfoodlab.ui.logout

import android.content.Intent
import android.os.Bundle
import android.text.format.DateUtils.LENGTH_SHORT
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.appcompat.app.ActionBar
import com.example.myfoodlab.MainActivity
import com.example.myfoodlab.R
import com.example.myfoodlab.WelcomeSignup
//import com.example.myfoodlab.databinding.FragmentLogout2Binding
import com.example.myfoodlab.ui.fillter.FillterFragment
import com.google.android.material.snackbar.BaseTransientBottomBar.LENGTH_SHORT
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_logout2.*
import kotlinx.android.synthetic.main.fragment_logout2.view.*


class LogoutFragment : Fragment() {

    private  var mAuth: FirebaseAuth? = null
    private  var database: FirebaseDatabase? = null
    private val email: String? = null
    private val username: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_logout2, container, false)


        //init firebase auth
        mAuth = FirebaseAuth.getInstance()
        checkUser(root)

        database =
            FirebaseDatabase.getInstance("https://foodapp-f4fe4-default-rtdb.asia-southeast1.firebasedatabase.app")
        checkUser(root)

        //handle click ,logout
        root.logoutBtn.setOnClickListener {
            mAuth!!.signOut()
            checkUser(root)

        }
        return root
    }

    private fun checkUser(root: View) {
        //check User is logged in or not
        val firebaseUser = mAuth?.currentUser
        //val databaseReference = database?.reference?.child("users")?.get()

        if (firebaseUser != null) {
            //User not null ,user is logged in,get user info
            val email = firebaseUser.email?:  " "
            //val username = firebaseUser.username?: " "

            //val username = firebaseUser.users
            //set to text view
            root.Email_Profile2.text = email
            //root.txtName2.text = username

            //Log.d("Firebase Email : ","$email")

        } else {
            //User is null, user is not logged in,go to login activity
            val intent = Intent(activity, WelcomeSignup::class.java)
            Toast.makeText(context, "You must be logged in", Toast.LENGTH_SHORT).show()
            activity?.startActivity(intent)
            activity?.finish()

        }
    }


}
