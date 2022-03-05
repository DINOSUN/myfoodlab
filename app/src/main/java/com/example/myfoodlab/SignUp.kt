package com.example.myfoodlab

import android.app.ListActivity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.myfoodlab.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_login.*

class SignUp : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    lateinit var txtEmailCreate: EditText
    lateinit var txtPasswordCreate: EditText
    lateinit var txtUsernameCreate: EditText
    lateinit var layout_constraint_Submit: ConstraintLayout
    lateinit var textLogin : TextView
    lateinit var email: String
    lateinit var password: String
    lateinit var username:String

    lateinit var mAuth: FirebaseAuth
    private lateinit var database: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        txtEmailCreate = findViewById<EditText>(R.id.txtEmailCreate)
        txtPasswordCreate = findViewById<EditText>(R.id.txtPassword)
        layout_constraint_Submit = findViewById<ConstraintLayout>(R.id.layout_constraint_Submit)
        txtUsernameCreate = findViewById<EditText>(R.id.txtUsernameCreate)
        textLogin = findViewById<TextView>(R.id.txtLogin)

        mAuth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance("https://foodapp-f4fe4-default-rtdb.asia-southeast1.firebasedatabase.app")


        layout_constraint_Submit.setOnClickListener {
            validateData()

        }

        textLogin.setOnClickListener{
            val gotoLogin = Intent(this,Login::class.java)
            gotoLogin.putExtra("hello", txtUsernameCreate.text.toString())
            startActivity(gotoLogin)
        }



    }


    override fun onStart(){
        super.onStart()
        val currentUser = mAuth.currentUser
        updateUI(currentUser)

    }


    private fun validateData() {

        //get data
        username = binding.txtUsernameCreate.text.toString().trim()
        email = binding.txtEmailCreate.text.toString().trim()
        password = binding.txtPassword.text.toString().trim()

        //validate data
        if (TextUtils.isEmpty(username)){
            //no password entered
            binding.txtUsernameCreate.error = "Please enter Username"
        }
        else if  (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            //invalid email format
            binding.txtEmailCreate.error = "Invalid email format"
        }
        else if (TextUtils.isEmpty(password)){
            //no password entered
            binding.txtPassword.error = "Please enter password"
        }
        else{
            //data is validate, begin login
            createAccount()

        }


    }



    private fun createAccount() {
        email = txtEmailCreate?.text.toString()
        password = txtPasswordCreate?.text.toString()
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this) {
                task -> if (task.isSuccessful){
            Log.d("My App","Create New User Success!")
            val user = mAuth.currentUser
            val databaseReference = database.reference.child("users").push()
            //val username = user?.displayName
            databaseReference.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val username = snapshot.child("Username").getValue(String::class.java)
                    Log.d("firebase_name", "Username = ${username}")
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })
            databaseReference.child("uid").setValue(user!!.uid)
            databaseReference.child("Email").setValue(user.email)
            databaseReference.child("Username").setValue(txtUsernameCreate.text.toString())
            databaseReference.child("uid").child("username").setValue(username)
            updateUI(user)
            //Log.d("firebase_name", "Username = ${databaseReference.child("uid").child("username").setValue(username)}")
        }
        else{
            Log.w("MyApp","Failure Process!",task.exception)
            Toast.makeText(this@SignUp,"Authentication Failed.", Toast.LENGTH_SHORT).show()
            updateUI(null)
        }

        }

    }



    private fun updateUI(user: FirebaseUser?) {
        if (user != null){
            val uid = user.uid
            val email = user.email

            Toast.makeText(this@SignUp,"Welcome: $email your ID is: $uid", Toast.LENGTH_SHORT).show()
            val intenSession = Intent(this, MainActivity::class.java)
            startActivity(intenSession)
        }
    }

}


