package com.example.ejemplosem1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import com.example.ejemplosem1.databinding.ActivityMainBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.auth.ktx.oAuthCredential
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        FirebaseApp.initializeApp(this)
        auth =Firebase.auth

        binding.btlogin.setOnClickListener{
            hacelogin();
        }
        binding.btlogin.setOnClickListener{
            hacelogin();
        }

        private fun haceRegister(){
            val email =binding.etEmail.text.toString()
            val clave =binding.EtPassword.text.toString()

            auth.createuserwithemailandpassord(email,clave).addoncompletelistener(this){task ->
                if(task.isSuccessful){
                    log.d("Creando usuario","Registrado")
                    val user = auth.currentUser
                    actualiza(user)
                }else{
                    Log.d("Creando Usuario","Fallo")
                    Toast.makeText(baseContext, "Fallo", Toast.LENGTH_SHORT).show()
                    actualiza(null)
                }
            }
        }
        private fun hacelogin(){
            TODO("not yet implmented")
        }
        private fun actualiza(user:FirebaseUser?){
            if(user!= null){
                val intent =intent(this, principal::class.java)
                startActivity(Intent)
            }
            private fun onStart(){
                super.onstart()
                val usuario =auth.currentuser
                actualiza(usuario)
                }
        }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            return when (item.itmeid){
              R.id.action_logoff ->{
                  firebase.auth.singout()
                  finish()
                  true
              }  else -> super.onOptionsItemSelected(item)
            }
        }
    }
}