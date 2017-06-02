package mx.org.gg.proyect.ka.juegosecuencia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import  android.os.Handler;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView iAzul,iVerde,iRojo,iAmarillo;
    TextView iNum;
    TextView cuenta;
    int iAleatorio;
    Button boton;
    int nivel = 1;
    int i=0;
    int aleators[];
    Random aleatorio = new Random(System.currentTimeMillis());
    int espera = 500;
    Handler pause = new Handler();
    Boolean jugar=false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cuenta = (TextView)findViewById(R.id.cuenta);
        iAzul = (ImageView) findViewById(R.id.iAzul);
        iNum = (TextView) findViewById(R.id.iNum);
        iVerde = (ImageView) findViewById(R.id.iVerde);
        iAmarillo = (ImageView) findViewById(R.id.iAmarillo);
        iRojo = (ImageView) findViewById(R.id.iRojo);
        boton = (Button) findViewById(R.id.boton);

        /*for (int b; i<nivel; i++)
        {
            aleators[i] = aleatorio.nextInt(3);
        }*/
        if (jugar==true){

            iNum.setText(" jugar = true");
        }

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                jugar = true;

                //iNum.setText(" "+iAleatorio);
                pause.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                while(nivel<=10)
                {
                    cuenta.setText(" "+nivel);

                    iAleatorio = aleatorio.nextInt(3);
                    nivel++;
                    if (iAleatorio==0){
                        iAzul.setVisibility(View.INVISIBLE);
                        pause.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                iAzul.setVisibility(View.VISIBLE);
                            }
                        },espera);

                    }
                    if (iAleatorio==1){
                        iAmarillo.setVisibility(View.INVISIBLE);
                        pause.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                iAmarillo.setVisibility(View.VISIBLE);
                            }
                        },espera);

                    }
                    if(iAleatorio==2){
                        iRojo.setVisibility(View.INVISIBLE);
                        pause.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                iRojo.setVisibility(View.VISIBLE);
                            }
                        },espera);

                    }
                    if(iAleatorio==3){
                        iVerde.setVisibility(View.INVISIBLE);
                        pause.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                iVerde.setVisibility(View.VISIBLE);
                            }
                        },espera);
                    }
                }}
                },espera);








                //try { Thread.sleep(5000); } catch (Exception e) {}



            }
        });



    }
}
