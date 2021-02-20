package com.example.simplecalculator

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigDecimal


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var operand1 = BigDecimal.ZERO
    private var operand2 = BigDecimal.ZERO
    var operation = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setOnClickListener()

    }

    private fun setOnClickListener() {
        button0.setOnClickListener(this)
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)
        dotButton.setOnClickListener(this)
        acButton.setOnClickListener(this)
        addButton.setOnClickListener(this)
        subButton.setOnClickListener(this)
        mulButton.setOnClickListener(this)
        divButton.setOnClickListener(this)
        modButton.setOnClickListener(this)
        equalButton.setOnClickListener(this)
    }

    override fun onClick(v: View) {

        when (v.id) {
            R.id.button0 -> {
                textView.text = "${textView.text}0"

            }
            R.id.button1 -> {
                textView.text = "${textView.text}1"

            }
            R.id.button2 -> {
                textView.text = "${textView.text}2"

            }

            R.id.button3 -> {
                textView.text = "${textView.text}3"

            }

            R.id.button4 -> {
                textView.text = "${textView.text}4"

            }

            R.id.button5 -> {
                textView.text = "${textView.text}5"

            }

            R.id.button6 -> {
                textView.text = "${textView.text}6"

            }

            R.id.button7 -> {
                textView.text = "${textView.text}7"

            }

            R.id.button8 -> {
                textView.text = "${textView.text}8"

            }

            R.id.button9 -> {
                textView.text = "${textView.text}9"

            }

            R.id.dotButton -> {
                if (textView.text.contains(".").not()) {
                    textView.text = "${textView.text}."
                }
            }

            R.id.acButton -> {
                textView.text = ""
            }

            R.id.addButton -> {
                try {
                    if (!(textView.text.toString()).isNullOrEmpty()) {
                        operand1 = (textView.text.toString()).toBigDecimal()
                        operation = Operations.Addition.name
                        textView.text = null
                    } else {
                        textView.text = "+"
                    }
                } catch (e: NumberFormatException) {
                    textView.text = "+"

                }

            }

            R.id.subButton -> {
                try {
                    if (!(textView.text.toString()).isNullOrEmpty()) {
                        operand1 = (textView.text.toString()).toBigDecimal()
                        operation = Operations.Subtraction.name
                        textView.text = null
                    } else {
                        textView.text = "-"
                    }
                } catch (e: NumberFormatException) {
                    textView.text = "-"

                }
            }

            R.id.mulButton -> {
                try {
                    if (!(textView.text.toString()).isNullOrEmpty()) {
                        operand1 = (textView.text.toString()).toBigDecimal()
                        operation = Operations.Multiplication.name
                        textView.text = null
                    }
                } catch (e: NumberFormatException) {
                    textView.text = ""

                }
            }


            R.id.divButton -> {
                try {
                    if (!(textView.text.toString()).isNullOrEmpty()) {
                        operand1 = (textView.text.toString()).toBigDecimal()
                        operation = Operations.Division.name
                        textView.text = null
                    }

                } catch (e: NumberFormatException) {
                    textView.text = ""

                }
            }

            R.id.modButton -> {
                try {
                    if (!(textView.text.toString()).isNullOrEmpty()) {
                        operand1 = (textView.text.toString()).toBigDecimal()
                        operation = Operations.Mod.name
                        textView.text = null
                    }

                } catch (e: NumberFormatException) {
                    textView.text = ""

                }

            }

            R.id.equalButton -> {
                if ((textView.text.toString()).isNullOrEmpty()) {
                    return
                }

                try {
                    operand2 = (textView.text.toString()).toBigDecimal()

                    when (operation) {
                        Operations.Addition.name -> {
                            textView.text = ((operand1 + operand2).toString())

                        }

                        Operations.Subtraction.name -> {
                            textView.text = ((operand1 - operand2).toString())

                        }

                        Operations.Multiplication.name -> {
                            textView.text = ((operand1 * operand2).toString())

                        }

                        Operations.Division.name -> {
                            var result = (operand1.toDouble() / operand2.toDouble())
                           /* var finalResult = result.toBigDecimal().setScale(1, RoundingMode.UP).toDouble()*/
                            textView.text = result.toString()

                        }
                        Operations.Mod.name -> {
                            textView.text = ((operand1 % operand2).toString())

                        }
                    }
                } catch (e: Exception) {

                }

            }

            else -> {
                textView.text = ""

            }
        }
    }


}
