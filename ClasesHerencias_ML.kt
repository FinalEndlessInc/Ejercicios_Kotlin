/******************************************************************************
Contexto: Las siguientes clases estan basadas en algunos personajes dentro del juego
Monster Legends, siendo mas especificos de la era Condenada,
donde basicamente se está almacenando algunas de sus estadisticas,
atributos y tipos de reliquias que utilizan, primordialmente en su version "vanilla"
sin mejoras y a nivel 100.

Ciertos monstruos pueden tener uno o dos elementos (fuego, tierra, magia, etc), así 
en esos casos se usa un data class para tener ambos datos.

Cada uno tiene un metodo unico que es basicamente como una habilidad especial

*******************************************************************************/
data class elementosDobles(val tipo1: String, val tipo2: String);
data class espacio_reliquias(val espacio1: String, val espacio2: String);

class ArchDuke(
    var nombre: String = "Arch Duke",
    val elemento: String = "Luz",
    val atributo: String = "Inmune a la ceguera",
    var vida: Int = 122449,
    var fuerza: Int = 10560,
    var velocidad: Int = 7513,
    val reliquias: espacio_reliquias = espacio_reliquias("Espada", "Armadura")
){
    fun mostrar_informacion():String{
        return "${nombre} es de elemento ${elemento} con el atributo de ${atributo} y puede usar como reliquias ${regresarReliquias()}";
    }
    fun gospel():String{
        return "Daño intenso: ${fuerza}, aplica ceguera total y Mega aturdimiento"
    }
    
    fun regresarReliquias():String{
        return "${reliquias.espacio1} y ${reliquias.espacio2}"
    }
}

class MGoldfield(
    var nombre: String = "Master Goldfield",
    val elemento: String = "Magia",
    val atributo: String = "Inmunidad al aturdimiento",
    var vida: Int = 125465,
    var fuerza: Int = 10142,
    var velocidad: Int = 8129,
    val reliquias: espacio_reliquias = espacio_reliquias("Trampa", "Amuleto")
){
    fun mostrar_informacion():String{
        return "${nombre} es de elemento ${elemento} con el atributo de ${atributo} y puede usar como reliquias ${regresarReliquias()}";
    }
    fun MagiaProhibida():String{
        return "Remueve el 50% de vida de todos los enemigod, elimina el vigor de todos los enemigos, recupera 50% de vida y recupera vigor a los aliados"
    }
    
    fun regresarReliquias():String{
        return "${reliquias.espacio1} y ${reliquias.espacio2}"
    }
}

class UrielDiv(
    var nombre: String = "Uriel the Divine",
    val elementos: elementosDobles = elementosDobles("Luz", "Tierra"),
    val atributo: String = "Celestial",
    var vida: Int = 120640,
    var fuerza: Int = 10032,
    var velocidad: Int = 7920,
    val reliquias: espacio_reliquias = espacio_reliquias("Esencia", "Bastón")
){
    fun mostrar_informacion():String{
        return "${nombre} es de elementos ${regresarElementos()} con el atributo de ${atributo} y puede usar como reliquias ${regresarReliquias()}";
    }
    fun AngelElegido():String{
        return "Daño intenso: ${fuerza}, elimina los estados de efecto positivo, deshabilita atrubutos y aplica Mega aturdimiento a todos los enemigos"
    }
    
    fun regresarReliquias():String{
        return "${reliquias.espacio1} y ${reliquias.espacio2}"
    }
    
    fun regresarElementos(): String{
        return "${elementos.tipo1} y ${elementos.tipo2}"
    }
}

class Cherub(
    var nombre: String = "Cherub Cupid",
    val elementos: elementosDobles = elementosDobles("Luz", "Fuego"),
    val atributo: String = "Perforación",
    var vida: Int = 125465,
    var fuerza: Int = 10560,
    var velocidad: Int = 7711,
    val reliquias: espacio_reliquias = espacio_reliquias("Mascara", "Esencia")
){
    fun mostrar_informacion():String{
        return "${nombre} es de elementos ${regresarElementos()} con el atributo de ${atributo} y puede usar como reliquias ${regresarReliquias()}";
    }
    fun EncantamientoTotal():String{
        return "Aplica Mega posesion e ignicion a todos los enemigos, desactiva los tiempos de recuperacion de si mismo"
    }
    
    fun regresarReliquias():String{
        return "${reliquias.espacio1} y ${reliquias.espacio2}"
    }
    
    fun regresarElementos(): String{
        return "${elementos.tipo1} y ${elementos.tipo2}"
    }
}

class Elvira(
    var nombre: String = "Elvira Demonslayer",
    val elementos: elementosDobles = elementosDobles("Luz", "Fuego"),
    val atributo: String = "Celestial",
    var vida: Int = 125465,
    var fuerza: Int = 10758,
    var velocidad: Int = 7722,
    val reliquias: espacio_reliquias = espacio_reliquias("Espada", "Amuleto")
){
    fun mostrar_informacion():String{
        return "${nombre} es de elementos ${regresarElementos()} con el atributo de ${atributo} y puede usar como reliquias ${regresarReliquias()}";
    }
    fun ArrepientetePecador():String{
        return "Daño intenso: ${fuerza}, aplica arrepentimiento, ignision y quemadura a todos los enemigos"
    }
    
    fun regresarReliquias():String{
        return "${reliquias.espacio1} y ${reliquias.espacio2}"
    }
    
    fun regresarElementos(): String{
        return "${elementos.tipo1} y ${elementos.tipo2}"
    }
}

fun main() {
    val Arch_Duke = ArchDuke();
    val Master_Goldfield = MGoldfield();
    val Uriel_Divine = UrielDiv();
    val Cherub_Cupid = Cherub();
    val Elvira_DS = Elvira();
    
    
    println(Arch_Duke.mostrar_informacion());
    println(Arch_Duke.gospel());
    println("");
    println(Master_Goldfield.mostrar_informacion());
    println(Master_Goldfield.MagiaProhibida());
    println("");
    println(Uriel_Divine.mostrar_informacion());
    println(Uriel_Divine.AngelElegido());
    println("");
    println(Cherub_Cupid.mostrar_informacion());
    println(Cherub_Cupid.EncantamientoTotal());
    println("");
    println(Elvira_DS.mostrar_informacion());
    println(Elvira_DS.ArrepientetePecador());
}
