package com.example.myapplication.Jogo_Arrocha

class Arrocha (var valormenor: Int, var valormaior:Int) {
    var sorteio: Int
    var status: Status

    init {
        this.sorteio = ((this.valormenor + 1) .. (this.valormaior - 1)).random()
        this.status = Status.EXECUTANDO
    }

    fun arrochado(): Boolean{
        return this.valormenor + 1 == this.valormaior - 1
    }

    fun atualizaIntervalo(chute: Int): Int{
        if (chute < this.sorteio){
            this.valormenor = chute
            return -1
        }else{
            this.valormaior = chute
            return 1
        }
    }

    fun chuteValido(chute: Int): Boolean{
        return chute > this.valormenor && chute < this.valormaior && chute != this.sorteio
    }

    fun jogar(chute: Int): Int{
        if (!this.chuteValido(chute)) {
            this.status = Status.PERDEU
            return 0
        }
        else{
            var valor = this.atualizaIntervalo(chute)
            if (this.arrochado()){
                this.status = Status.GANHOU
            }
            return valor
        }
    }
}