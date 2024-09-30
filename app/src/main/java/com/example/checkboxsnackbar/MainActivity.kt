package com.example.checkboxsnackbar

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var inputText: EditText
    private lateinit var outputText: TextView
    private lateinit var saveButton: Button
    private lateinit var deleteButton: Button
    private lateinit var pddTextView: TextView
    private lateinit var pddCheckBox: CheckBox
    private lateinit var pddInfoTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        inputText = findViewById(R.id.inputText)
        outputText = findViewById(R.id.outputText)
        saveButton = findViewById(R.id.saveButton)
        deleteButton = findViewById(R.id.deleteButton)

        pddTextView = findViewById(R.id.pddTextView)
        pddCheckBox = findViewById(R.id.pddCheckBox)
        pddInfoTextView = findViewById(R.id.pddInfoTextView)

        saveButton.setOnClickListener { v ->
            outputText.text = inputText.text
        }

        deleteButton.setOnClickListener { v ->
            val snackbar = Snackbar.make(v, "Подтвердите удаление", Snackbar.LENGTH_LONG)
                .setAction("Удалить") {
                    outputText.text=""
                    inputText.text.clear()
                    Snackbar.make(v, "Данные удалены", Snackbar.LENGTH_LONG).show()
                }
            snackbar.show()
        }

        pddCheckBox.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                pddTextView.text=resources.getString(R.string.pddText)
                pddInfoTextView.text = resources.getString(R.string.pddInfoView)
            }
            else {
                pddInfoTextView.text = ""
                pddTextView.text = resources.getString(R.string.pddTextView)

            }
        }
    }
}