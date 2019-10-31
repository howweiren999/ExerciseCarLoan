package com.example.exercise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import java.util.Collections.replaceAll
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var locale = Locale.getDefault()
        var currency = Currency.getInstance(locale)
        var symbol = currency.getSymbol()
        buttonCalculate.setOnClickListener{
            //val = value or var = variable
            var filled = true
            if(editTextCarPrice.text.length == 0) {
                editTextCarPrice.setError("Please enter car price")
                filled = false
            }
            if(editTextDownPayment.text.length== 0) {
                editTextDownPayment.setError("Please enter down payment")
                filled = false
            }
            if(editTextLoanPeriod.text.length== 0) {
                editTextLoanPeriod.setError("Please enter loan period")
                filled = false
            }
            if(editTextInterestRate.text.length == 0) {
                editTextInterestRate.setError("Please enter interest rate")
                filled = false
            }
             if(filled == true) {
                 var carPrice = editTextCarPrice.text.toString().toInt()
                 var downPayment = editTextDownPayment.text.toString().toInt()
                 var loanPeriod = editTextLoanPeriod.text.toString().toInt()
                 var interestRate = editTextInterestRate.text.toString().toFloat()
                 //TODO() Continue your calculation here
                 val loan = carPrice - downPayment
                 textViewLoan.text = getString(R.string.loan) + symbol.toString()+ loan.toString()
                 val interest = loan * (interestRate / 100) * loanPeriod
                 textViewInterest.text = getString(R.string.interest) +symbol.toString()+ interest.toString()
                 val monthlyPayment = (loan + interest) / loanPeriod / 12
                 textViewMonthlyPayment.text =
                     getString(R.string.monthly_payment) +symbol.toString()+ monthlyPayment.toString()
             }
        }
    }

    fun resetInputs(view: View) {
        //TODO() Reset all inputs and outputs
        editTextCarPrice.setText("")
        editTextDownPayment.setText("")
        editTextLoanPeriod.setText("")
        editTextInterestRate.setText("")
        textViewLoan.setText(getString(R.string.loan)+"")
        textViewInterest.setText(getString(R.string.interest)+"")
        textViewMonthlyPayment.setText(getString(R.string.monthly_payment)+"")
    }
}
