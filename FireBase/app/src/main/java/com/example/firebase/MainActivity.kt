package com.example.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit  var mFirebaseAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mFirebaseAuth = FirebaseAuth.getInstance()

        ButLogIn.setOnClickListener(){
            mFirebaseAuth.signInWithEmailAndPassword(Login.text.toString(), Password.text.toString()).addOnCompleteListener(){
                if(it.isSuccessful){
                    Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this, "Fail!", Toast.LENGTH_SHORT).show()
                }
            }
        }

        ButSignIn.setOnClickListener(){
            mFirebaseAuth.createUserWithEmailAndPassword(Login.text.toString(), Password.text.toString()).addOnCompleteListener(){
                if(it.isSuccessful){
                    Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this, "Fail: ${it.exception}", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}