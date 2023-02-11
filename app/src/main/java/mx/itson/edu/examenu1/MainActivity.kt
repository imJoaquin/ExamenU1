package mx.itson.edu.examenu1
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cel: TextView = findViewById(R.id.etC)
        val far: TextView = findViewById(R.id.etF)
        val kel: TextView = findViewById(R.id.etK)
        val calCel: Button = findViewById(R.id.btnC)
        val calFar: Button = findViewById(R.id.btnF)
        val calKel: Button = findViewById(R.id.btnK)
        val aviso: TextView = findViewById(R.id.textView3)

        calCel.setOnClickListener{

            when {
                cel.text.isNotEmpty() ->{
                    cel.setText("")
                    kel.setText("")
                    far.setText("")
                    aviso.setText("Operación inválida")
                }
                kel.text.isEmpty() -> {
                    var resultado = calcularFtoC(far.text.toString().toDouble())
                    cel.setText(resultado.toFloat().toString())
                    far.setText("")
                    aviso.setText("")
                }
                far.text.isEmpty() -> {
                    var resultado2 = calcularKtoC(kel.text.toString().toDouble())
                    cel.setText(resultado2.toString())
                    kel.setText("")
                    aviso.setText("")
                }
            }
        }

        calFar.setOnClickListener {

            when{
                far.text.isNotEmpty() ->{
                    far.setText("")
                    kel.setText("")
                    cel.setText("")
                    aviso.setText("Operación inválida")
                }
                kel.text.isEmpty()->{
                    var resultado = calcularCtoF(cel.text.toString().toDouble())
                    far.setText(resultado.toFloat().toString())
                    cel.setText("")
                    aviso.setText("")
                }
                cel.text.isEmpty()->{
                    var resultado2 = calcularKtoF(kel.text.toString().toDouble())
                    far.setText(resultado2.toString())
                    kel.setText("")
                    aviso.setText("")
                }
            }
        }

        calKel.setOnClickListener {

            when{
                kel.text.isNotEmpty() -> {
                    kel.setText("")
                    cel.setText("")
                    far.setText("")
                    aviso.setText("Operación inválida")
                }
                far.text.isBlank()->{
                    var resultado = calcularCtoK(cel.text.toString().toDouble())
                    kel.setText(resultado.toFloat().toString())
                    cel.setText("")
                    aviso.setText("")
                }
                cel.text.isEmpty()->{
                    var resultado2 = calcularFtoK(far.text.toString().toDouble())
                    kel.setText(resultado2.toString())
                    far.setText("")
                    aviso.setText("")
                }
            }
        }
    }

    fun calcularKtoC(kel:Double):Double{
        return kel - 273.15
    }

    fun calcularCtoK(cel:Double):Double{
        return cel + 273.15
    }

    fun calcularKtoF(kel:Double):Double{
        return (9*kel)-273.15 / 5 + 32
    }

    fun calcularFtoK(far:Double):Double{
        return (5*far)-32 / 9 + 273.15
    }

    fun calcularFtoC(far:Double):Double{
        return (far-32)/1.8
    }

    fun calcularCtoF(cel:Double):Double{
        return (cel*1.8)+32
    }

}