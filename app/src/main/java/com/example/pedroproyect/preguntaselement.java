package com.example.pedroproyect;

public class preguntaselement {

    String preguntas,respuesta1,respuesta2,respuesta3,respuesta4,correct;
     public preguntaselement(String preguntas,String respuesta1,String respuesta2,String respuesta3,String respuesta4,String correct){
         this.preguntas=preguntas;
         this.respuesta1=respuesta1;
         this.respuesta2=respuesta2;
         this.respuesta3=respuesta3;
         this.respuesta4=respuesta4;
         this.correct=correct;
     }

    public String getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(String preguntas) {
        this.preguntas = preguntas;
    }

    public String getRespuesta1() {
        return respuesta1;
    }

    public void setRespuesta1(String respuesta1) {
        this.respuesta1 = respuesta1;
    }

    public String getRespuesta2() {
        return respuesta2;
    }

    public void setRespuesta2(String respuesta2) {
        this.respuesta2 = respuesta2;
    }

    public String getRespuesta3() {
        return respuesta3;
    }

    public void setRespuesta3(String respuesta3) {
        this.respuesta3 = respuesta3;
    }

    public String getRespuesta4() {
        return respuesta4;
    }

    public void setRespuesta4(String respuesta4) {
        this.respuesta4 = respuesta4;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }
}
