package com.example.sharedpreferences

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var nomeEdit:EditText
    private lateinit var sobrenomeEdit:EditText
    private lateinit var telefoneEdit:EditText
    private lateinit var emailEdit:EditText
    private lateinit var botao:Button
    private lateinit var textNome:TextView
    private lateinit var textSobrenome:TextView
    private lateinit var textTelefone:TextView
    private lateinit var textEmail:TextView
    private var filePref: String = "ArquivoPreferencia"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Edit Text
        nomeEdit = findViewById(R.id.editNome)
        sobrenomeEdit = findViewById(R.id.editSobrenome)
        telefoneEdit = findViewById(R.id.editTelefone)
        emailEdit = findViewById(R.id.editEmail)
        //

        // Botão
        botao = findViewById(R.id.btAdicionar)
        //

        //Text View
        textNome = findViewById(R.id.textNome1)
        textSobrenome = findViewById(R.id.textSobrenome)
        textTelefone = findViewById(R.id.textTelefone)
        textEmail = findViewById(R.id.textEmail)

        botao.setOnClickListener {
            val sharedPref: SharedPreferences = getSharedPreferences(filePref, 0)
            val editor:SharedPreferences.Editor = sharedPref.edit()
            val nome = nomeEdit.text.toString()
            val sobrenome = sobrenomeEdit.text.toString()
            val telefone = telefoneEdit.text.toString()
            val email = emailEdit.text.toString()
            editor.putString("nome", nome)
            editor.putString("sobrenome", sobrenome)
            editor.putString("telefone", telefone)
            editor.putString("email", email)
            editor.commit()
            onRestart()


        }
        val sharedPref: SharedPreferences = getSharedPreferences(filePref, 0)
        if (sharedPref.contains("nome")){
            val nome = sharedPref.getString("nome","Usuario não localizado")
            val sobrenome = sharedPref.getString("sobrenome","Usuario não localizado")
            val telefone = sharedPref.getString("telefone","Usuario não localizado")
            val email = sharedPref.getString("email","Usuario não localizado")

            textNome.setText("NOME: " + nome.toString())
            textSobrenome.setText("SOBRENOME: " + sobrenome.toString())
            textTelefone.setText("TELEFONE: " + telefone.toString())
            textEmail.setText("EMAIL: " + email.toString())



        }else{
            Toast.makeText(this,"Nome não encontrado", Toast.LENGTH_LONG).show()
        }

    }
}